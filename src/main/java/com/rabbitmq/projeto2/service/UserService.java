package com.rabbitmq.projeto2.service;

import com.rabbitmq.projeto2.model.UserModel;
import com.rabbitmq.projeto2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> obterTodo() {
        return userRepository.findAll();
    }

    public Optional<UserModel> obterId(UUID id) {
        return userRepository.findById(id);
    }

    public UserModel adicionar(UserModel userModel) {
        return userRepository.save(userModel);
    }

    public UserModel atualizar(UserModel userModel, UUID id) {
        userModel.setUserId(id);
        return userRepository.save(userModel);
    }

    public void deletar(UUID id) {
    }
}
