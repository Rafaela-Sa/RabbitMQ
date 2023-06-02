package com.rabbitmq.projeto2.controller;

import com.rabbitmq.projeto2.model.EmailModel;
import com.rabbitmq.projeto2.model.UserModel;
import com.rabbitmq.projeto2.service.EmailService;
import com.rabbitmq.projeto2.service.RequestService;
import com.rabbitmq.projeto2.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private RequestService requestService;

    @PostMapping("/{enviar-email}")
    public ResponseEntity<EmailModel> enviarEmail(@RequestBody @Valid  EmailModel emailModel) {
        emailService.sendEmail(emailModel);
        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
    }
    @GetMapping
    public List<UserModel> obterTodo() {
        return userService.obterTodo();
    }

    @GetMapping("/{id}")
    public Optional<UserModel> obterId(@PathVariable UUID id) {
        return userService.obterId(id);
    }

    @PostMapping("/add")
    public UserModel adicionar(@RequestBody @Valid UserModel userModel) {
        return userService.adicionar(userModel);
    }

    @PutMapping("/{id}")
    public UserModel atualizar(@RequestBody UserModel userModel, @PathVariable UUID id) {
        userModel.setUserId(id);
        return userService.atualizar(userModel, id);
    }
}
