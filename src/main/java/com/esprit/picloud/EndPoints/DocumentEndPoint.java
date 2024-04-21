package com.esprit.picloud.EndPoints;

import com.esprit.picloud.Services.ICourseService;
import com.esprit.picloud.Services.IDocumentService;
import com.esprit.picloud.entities.Course;
import com.esprit.picloud.entities.Documentt;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/Documents")

public class DocumentEndPoint {
    IDocumentService iDocumentService;
    @GetMapping("/retrieveAllDocument")
    public List<Documentt> retrieveDocument(){return iDocumentService.retrieveDocument();}
    @PostMapping("/addDocument")
    public Documentt AddDocument(@RequestBody Documentt documentt){return iDocumentService.AddDocument(documentt);}
    @PutMapping("/updateDocument")
    public Documentt UpdateDocument(@RequestBody Documentt documentt){return iDocumentService.UpdateDocument(documentt);}
    @GetMapping("/retrievebyId/{DocumentID}")
    public Documentt retrieveDocument(@PathVariable String DocumentID){return iDocumentService.retrieveDocument(DocumentID);}
    @DeleteMapping("/delete/{DocumentID}")
    public void DeleteDocument(@PathVariable String DocumentID){ iDocumentService.DeleteDocument(DocumentID);}
    @PutMapping("/affecterDoc/{DocumentID}/{courseID}")
    public void AffecterDoc(@PathVariable String DocumentID,@PathVariable String courseID){iDocumentService.associerDocumentAuCours(DocumentID,courseID);}
    @PutMapping("/desaffecterDoc/{DocumentID}/{courseID}")
    public void DesaffecterDoc(@PathVariable String DocumentID,@PathVariable String courseID){iDocumentService.desaffecterDocumentDuCours(DocumentID,courseID);}
}
