package com.esprit.picloud.Services;

import com.esprit.picloud.entities.Course;
import com.esprit.picloud.entities.Documentt;
import com.esprit.picloud.repositories.CourseRepo;
import com.esprit.picloud.repositories.DocumentRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class DocumentServiceImpl implements IDocumentService{
    DocumentRepo documentRepo;
    CourseRepo courseRepo;
    @Override
    public List<Documentt> retrieveDocument() {
        return documentRepo.findAll();
    }

    @Override
    public Documentt AddDocument(Documentt documentt) {
        Documentt savedDocument = documentRepo.save(documentt);

        String fileName = "document_" + savedDocument.getTitle() + ".txt";
        File file = new File(fileName);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Titre du document : " + savedDocument.getTitle() + "\n");
            writer.write("Contenu du document : " + savedDocument.getContent());
            log.info("Fichier texte créé avec succès : {}", fileName);
        } catch (IOException e) {
            log.error("Erreur lors de la création du fichier texte : {}", e.getMessage());
        }

        return savedDocument;
    }

    @Override
    public Documentt UpdateDocument(Documentt documentt) {
        return documentRepo.save(documentt);
    }

    @Override
    public Documentt retrieveDocument(String DocumentID) {
        return documentRepo.findById(DocumentID).orElse(null);
    }

    @Override
    public void DeleteDocument(String DocumentID) {
    documentRepo.deleteById(DocumentID);
    }
    @Override
    public void associerDocumentAuCours(String DocumentID, String courseID) {
        Documentt document = documentRepo.findById(DocumentID).orElse(null);
        Course course = courseRepo.findById(courseID).orElse(null);

        if (document != null && course != null) {
            List<Documentt> documentts = course.getDocumentts();
            if (documentts != null && !documentts.isEmpty()) {
                for (Documentt existingDocument : documentts) {
                    if (existingDocument.getDocumentID().equals(DocumentID)) {
                        log.info("Le document existe déjà dans ce cours.");
                        return;
                    }
                }
            }
            course.getDocumentts().add(document);
            document.setCourseDoc(course);
            courseRepo.save(course);
            documentRepo.save(document);
        } else {
            throw new RuntimeException("Le document ou le cours avec l'ID spécifié n'existe pas dans la base de données.");
        }
    }

    @Override
    public void desaffecterDocumentDuCours(String DocumentID, String courseID) {
        Documentt document = documentRepo.findById(DocumentID).orElse(null);
        Course course = courseRepo.findById(courseID).orElse(null);

        if (document != null && course != null) {
            document.setCourseDoc(null);

            List<Documentt> documentts = course.getDocumentts();
            if (documentts != null && !documentts.isEmpty()) {
                documentts.removeIf(doc -> doc.getDocumentID().equals(DocumentID));
            }
            courseRepo.save(course);
            documentRepo.save(document);
        } else {
            throw new RuntimeException("Le document ou le cours avec l'ID spécifié n'existe pas dans la base de données.");
        }
    }


}
