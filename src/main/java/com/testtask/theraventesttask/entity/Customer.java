package com.testtask.theraventesttask.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.Instant;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "full_name", nullable = false, length = 50)
    @NotBlank
    @Size(min = 2, max = 50)
    private String fullName;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    @NotBlank
    @Email
    @Size(max = 100)
    private String email;

    @Column(name = "phone", length = 14)
    @Valid
    @Pattern(regexp = "^\\+?[0-9]{6,14}$")
    private String phone;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "created", nullable = false, updatable = false)
    private Long created;

    @Column(name = "updated", nullable = false)
    private Long updated;

    @PrePersist
    protected void onCreate() {
        created = updated = Instant.now().getEpochSecond();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = Instant.now().getEpochSecond();
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
            isActive = active;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }
}