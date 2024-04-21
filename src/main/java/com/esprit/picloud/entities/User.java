package com.esprit.picloud.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document

public class User {
    @Id
    private String id;
    private String firstname;
    private String lastname;
}
