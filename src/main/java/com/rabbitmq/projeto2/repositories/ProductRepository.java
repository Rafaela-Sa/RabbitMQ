package com.rabbitmq.projeto2.repositories;

import com.rabbitmq.projeto2.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductModel, UUID> {
}
