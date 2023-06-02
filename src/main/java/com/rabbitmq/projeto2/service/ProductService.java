package com.rabbitmq.projeto2.service;

import com.rabbitmq.projeto2.model.ProductModel;
import com.rabbitmq.projeto2.model.RequestModel;
import com.rabbitmq.projeto2.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductModel> obterTodo() {
        return productRepository.findAll();
    }

    public Optional<ProductModel> obterId(UUID id) {
        return productRepository.findById(id);
    }

    public ProductModel adicionar(ProductModel productModel) {
        return productRepository.save(productModel);
    }

    public ProductModel atualizar(ProductModel productModel, UUID id) {
        productModel.setProductId(id);
        return productRepository.save(productModel);
    }
    public void deletar(UUID id) {
    }
}
