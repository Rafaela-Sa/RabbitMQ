package com.rabbitmq.projeto2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_USER")
public class UserModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID userId;
    private String nameUser;
    @Column(unique = true)
    private String userEmail;

    @OneToMany(mappedBy = "userModel", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<EmailModel> emailsModel;

    @OneToMany(mappedBy = "userModel", cascade = CascadeType.ALL)
    @JsonIgnore
    private  List<RequestModel> requestModel;

//    public UserModel(EmailModel emailFrom) {
//        this.userEmail = emailFrom;
//    }
}
