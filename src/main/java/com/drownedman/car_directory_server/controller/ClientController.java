package com.drownedman.car_directory_server.controller;

import com.drownedman.car_directory_server.model.Client;
import com.drownedman.car_directory_server.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping ("/client")
public class ClientController {
    ClientService service = new ClientService();

    @GetMapping("/readbyemail")
    ResponseEntity<Client> findClient(String email) {
        log.info("find client request: {}", email);
        return ResponseEntity.ok(service.findClient(email));
    }

    @GetMapping("/exist")
    ResponseEntity<Boolean> isClientExist(String email) {
        log.info("is client exist request: {}", email);
        return ResponseEntity.ok(service.isClientExist(email));
    }

    @PostMapping("/create")
    ResponseEntity<Void> addClient(Client client) {
        log.info("add client request: {}", client);
        return ResponseEntity.ok(service.addClient(client));
    }
}
