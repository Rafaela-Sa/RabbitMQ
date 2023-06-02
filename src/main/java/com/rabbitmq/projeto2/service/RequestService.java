package com.rabbitmq.projeto2.service;

import com.rabbitmq.projeto2.model.RequestModel;
import com.rabbitmq.projeto2.model.UserModel;
import com.rabbitmq.projeto2.repositories.RequestRepository;
import com.rabbitmq.projeto2.repositories.UserRepository;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public List<RequestModel> obterTodo() {
        return requestRepository.findAll();
    }

    public Optional<RequestModel> obterId(UUID id) {
        return requestRepository.findById(id);
    }

    public RequestModel adicionar(RequestModel requestModel) {
        return requestRepository.save(requestModel);
    }

    public RequestModel atualizar(RequestModel requestModel, UUID id) {
        requestModel.setRequestId(id);
        return requestRepository.save(requestModel);
    }
    public void deletar(UUID id) {
    }
}
