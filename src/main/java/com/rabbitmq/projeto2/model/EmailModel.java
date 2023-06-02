package com.rabbitmq.projeto2.model;

import com.rabbitmq.projeto2.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;


@Data
@Entity
@Table(name = "TB_EMAIL")
public class EmailModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID emailId;
    private String emailFrom;
    private String emailTo;
    private String subject; //Título
    @Column(columnDefinition = "TEXT") //Notação possibilita utilizar textos grandes no corpo do email
    private String text;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail; //Status importado do Enum: SENT, ERROR

    @ManyToOne
    private UserModel userModel; // userModel é o nome do campo da tabela que será mapeada como "dona" da relação

//    public EmailModel(UserModel userEmail) {
//        this.emailFrom = userEmail;
//    }
}
