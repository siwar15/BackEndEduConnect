package com.esprit.picloud.Services;

import com.esprit.picloud.entities.Course;
import com.esprit.picloud.entities.Documentt;

import java.util.List;

public interface IDocumentService {
    List<Documentt> retrieveDocument();
    Documentt AddDocument(Documentt documentt);
    Documentt UpdateDocument(Documentt documentt);
    Documentt retrieveDocument(String DocumentID);
    void DeleteDocument(String DocumentID);
    public void associerDocumentAuCours(String DocumentID, String courseID);
    public void desaffecterDocumentDuCours(String DocumentID, String courseID);
}
