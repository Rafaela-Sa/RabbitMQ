package com.rabbitmq.projeto2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "TB_REQUEST")
public class RequestModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID requestId;
    private String nameUser;
    private Double valorTotal;

    @ManyToOne(cascade=CascadeType.ALL)
    private UserModel userModel;

    @ManyToOne(cascade=CascadeType.ALL)
    private  ProductModel productModel;
}
