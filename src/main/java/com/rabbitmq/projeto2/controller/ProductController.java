package com.rabbitmq.projeto2.controller;

import com.rabbitmq.projeto2.model.ProductModel;
import com.rabbitmq.projeto2.model.RequestModel;
import com.rabbitmq.projeto2.service.ProductService;
import com.rabbitmq.projeto2.service.RequestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductModel> obterTodo() {
        return productService.obterTodo();
    }

    @GetMapping("/{id}")
    public Optional<ProductModel> obterId(@PathVariable UUID id) {
        return productService.obterId(id);
    }

    @PostMapping("/add")
    public ProductModel adicionar(@RequestBody @Valid ProductModel productModel) {
        return productService.adicionar(productModel);
    }

    @PutMapping("/{id}")
    public ProductModel atualizar(@RequestBody ProductModel productModel, @PathVariable UUID id) {
        productModel.setProductId(id);
        return productService.atualizar(productModel, id);
    }
}
