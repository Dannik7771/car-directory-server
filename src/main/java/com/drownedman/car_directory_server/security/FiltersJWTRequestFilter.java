package com.drownedman.car_directory_server.security;

import com.drownedman.car_directory_server.model.Client;
import com.drownedman.car_directory_server.service.ClientDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class FiltersJWTRequestFilter extends OncePerRequestFilter {
    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private JWTController jwtController;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");

        String userName = null;
        String jwt = null;
        List<Client.Role> role = null;

        ObjectMapper mapper = new ObjectMapper();
        CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Client.Role.class);

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            userName = jwtController.extractUsername(jwt);
            role = jwtController.extractRoles(jwt);
        }

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer "))
            System.out.println("the client did not provide a token");
        else {
            System.out.println("username: " + userName);
            System.out.println("roles: " + role);
        }

        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.clientDetailsService.loadUserByUsername(userName);

            if (jwtController.validateToken(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = null;
                if (mapper.writeValueAsString(role).equals(userDetails.getAuthorities().iterator().next().getAuthority())) {
                    usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                } else {
                    //TODO: reconsider the problem mapper.writeValueAsString(role)
                    usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, Collections.singletonList(new SimpleGrantedAuthority(mapper.writeValueAsString(role))));
                }

                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}