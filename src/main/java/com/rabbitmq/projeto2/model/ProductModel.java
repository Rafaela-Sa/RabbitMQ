package com.rabbitmq.projeto2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_PRODUCT")
public class ProductModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID productId;
    private String nameProduct;
    private Integer qtdEstoque;
    private Double valorCusto;
    private Double valorVenda;

    @OneToMany(mappedBy = "productModel", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<RequestModel> requestModel;
}
