package com.drownedman.car_directory_server.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name="client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "roles")
    private List<Role> roles;

    public Client() {}

    public Client(String name, String email, String password, List<Role> roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public enum Role {
        Admin(0),
        Moder(1),
        User(2),
        Organization(3),
        Subscriber(4),
        Block(5),
        Guest(6);

        int value;
        private static Map map = new HashMap<>();

        Role(int value) {
            this.value = value;
        }

        static {
            for (Role role : Role.values()) {
                map.put(role.value, role);
            }
        }

        public static Role valueOf(int role) {
            return (Role) map.get(role);
        }

        public int getValue() {
            return value;
        }
    }

    /*public List<Integer> getRoleValues() {
        List<Integer> roleValues = new ArrayList<>();
        for (Role role : roles) roleValues.add(role.getValue());
        return roleValues;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
