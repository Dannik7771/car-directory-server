package com.drownedman.car_directory_server.service;

import com.drownedman.car_directory_server.model.Client;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class ClientService {

    public Client findClient(String email) {
        return null;
    }

    public Boolean isClientExist(String email) {
        return null;
    }

    public Void addClient(Client client) {
        return null;
    }
}
