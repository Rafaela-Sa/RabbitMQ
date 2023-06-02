package com.rabbitmq.projeto2.controller;

import com.rabbitmq.projeto2.model.RequestModel;
import com.rabbitmq.projeto2.service.RequestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/request")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @GetMapping
    public List<RequestModel> obterTodo() {
        return requestService.obterTodo();
    }

    @GetMapping("/{id}")
    public Optional<RequestModel> obterId(@PathVariable UUID id) {
        return requestService.obterId(id);
    }

    @PostMapping("/add")
    public RequestModel adicionar(@RequestBody @Valid RequestModel requestModel) {
        return requestService.adicionar(requestModel);
    }

    @PutMapping("/{id}")
    public RequestModel atualizar(@RequestBody RequestModel requestModel, @PathVariable UUID id) {
        requestModel.setRequestId(id);
        return requestService.atualizar(requestModel, id);
    }
}
