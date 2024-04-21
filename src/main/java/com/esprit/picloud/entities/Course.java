package com.esprit.picloud.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document
public class Course{
    @Id
    private String courseID;
    CourseCategory courseCat;
    private String title;
    private User userC;
    private Date courseDate;
    private String duration;
    private int disponibility;
    CourseType courseType;
    @DBRef
    List<Documentt>documentts= new ArrayList<>();

}
