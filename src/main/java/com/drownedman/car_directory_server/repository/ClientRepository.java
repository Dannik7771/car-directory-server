package com.drownedman.car_directory_server.repository;

import com.drownedman.car_directory_server.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByEmail(String email);
    Client findByName(String name);
    boolean existsByEmail(String email);
    Client findByNameLike(String name);
    boolean existsByNameLike(String name);
}
