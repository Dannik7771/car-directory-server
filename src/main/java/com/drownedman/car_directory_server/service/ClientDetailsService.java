package com.drownedman.car_directory_server.service;

import com.drownedman.car_directory_server.model.Client;
import com.drownedman.car_directory_server.repository.ClientRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ClientDetailsService implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Client personCredentials = clientRepository.findByNameLike(userName);
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (personCredentials != null) {
                return new User(
                        personCredentials.getName(),
                        personCredentials.getPassword(),
                        Collections.singletonList(new SimpleGrantedAuthority(mapper.writeValueAsString(personCredentials.getRoles())))
                );
            } else {
                return null;
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
