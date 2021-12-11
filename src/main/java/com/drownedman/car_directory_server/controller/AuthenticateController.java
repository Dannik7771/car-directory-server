package com.drownedman.car_directory_server.controller;

import com.drownedman.car_directory_server.model.Client;
import com.drownedman.car_directory_server.repository.ClientRepository;
import com.drownedman.car_directory_server.security.JWTController;
import com.drownedman.car_directory_server.service.ClientDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
public class AuthenticateController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private JWTController jwtController;

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("auth")
    public ResponseEntity<String> authentication(@RequestBody Client body) throws Exception {
        log.info("auth request: {}", body);
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            body.getName(),
                            body.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            LoggerFactory.getLogger(AuthenticateController.class).warn("Incorrect username or password");
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        final UserDetails userDetails = clientDetailsService
                .loadUserByUsername(body.getName());

        if (userDetails != null) {
            final String token = jwtController.generateToken(userDetails);

            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("register")
    public ResponseEntity<String> registration(@RequestBody Client body) throws Exception {
        log.info("register request: {}", body);
        if (body.getName() != null && body.getPassword()!= null
                && !clientRepository.existsByNameLike(body.getName())) {

            clientRepository.save(
                    new Client(
                            body.getName(),
                            body.getEmail(),
                            passwordEncoder.encode(body.getPassword()),
                            Arrays.asList(Client.Role.User, Client.Role.Admin)
                    )
            );
        } else {
            return ResponseEntity.badRequest().build();
        }

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            body.getName(),
                            body.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            LoggerFactory.getLogger(AuthenticateController.class).warn("Incorrect username or password");
            return ResponseEntity.badRequest().build();
        }

        final UserDetails userDetails = clientDetailsService
                .loadUserByUsername(body.getName());

        if (userDetails != null) {
            final String token = jwtController.generateToken(userDetails);

            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/auth/oauth")
    ResponseEntity<OutAuthResponse> outAuth(@RequestParam OAUTH2Provider provider) {
        log.info("out auth: {}", provider);
        return ResponseEntity.ok(
                new OutAuthResponse(
                        "path",
                        UUID.randomUUID()
                )
        );
    }

    public static final class OutAuthResponse{
        public String path;
        public UUID session_id;

        public OutAuthResponse(String path, UUID session_id) {
            this.path = path;
            this.session_id = session_id;
        }
    }

    public enum OAUTH2Provider{
        VK,
        Google,
        Meta
    }
}
