package com.drownedman.car_directory_server.service;

import com.drownedman.car_directory_server.model.Client;
import com.drownedman.car_directory_server.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClientService {
    @Autowired
    private ClientRepository repository;

    public Client findClient(String email) {
        return repository.findByEmail(email);
    }

    public Boolean isClientExist(String email) {
        return repository.existsByEmail(email);
    }

    public Client addClient(Client client) {
        return repository.save(client);
    }

    public List<Client> getAllClients() {
        return repository.findAll();
    }

    public void deleteClients() {
        repository.deleteAll();
    }
}
