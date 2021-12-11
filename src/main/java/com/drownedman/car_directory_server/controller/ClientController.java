package com.drownedman.car_directory_server.controller;

import com.drownedman.car_directory_server.model.Client;
import com.drownedman.car_directory_server.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping ("/client")
public class ClientController {
    @Autowired
    private ClientService service;

    @GetMapping()
    public ResponseEntity<List<Client>> getAllClients() {
        log.info("get all clients request");
        return ResponseEntity.ok(service.getAllClients());
    }

    @GetMapping("/email/{email}")
    ResponseEntity<Client> findClient(@PathVariable("email") String email) {
        log.info("find client request: {}", email);
        return ResponseEntity.ok(service.findClientByEmail(email));
    }

    @GetMapping("/exist/email/{email}")
    ResponseEntity<Boolean> isClientExist(@PathVariable("email") String email) {
        log.info("is client exist request: {}", email);
        return ResponseEntity.ok(service.isClientExist(email));
    }

    @PostMapping()
    ResponseEntity<Client> addClient(@RequestBody Client client) {
        log.info("add client request: {}", client);
        return ResponseEntity.ok(service.addClient(client));
    }

    //TODO: debug, delete that
    @DeleteMapping()
    @ResponseStatus(value = HttpStatus.OK)
    void deleteClients() {
        log.info("delete all clients");
        service.deleteClients();
    }
}
