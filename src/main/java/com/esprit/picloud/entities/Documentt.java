package com.esprit.picloud.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document

public class Documentt{
    @Id
    private String documentID;
    private String title;
    private String content;
    @JsonIgnore
    @DBRef
    Course CourseDoc;

}
