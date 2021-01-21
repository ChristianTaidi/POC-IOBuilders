package com.christian.iobuilders.demo.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Map;

@Entity
public class User {


    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(max = 9, min = 7)
    private String dni;

    @NotNull
    @Size(max = 30)
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min=8)
    private String password;
    private Map credentials;

    public User(){
        //JPA default constructor
    }

    public User(String dni, String name, String email){
        this.dni = dni;
        this.name = name;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public void setCredentials(Map credentials) {
        this.credentials = credentials;
    }
}
