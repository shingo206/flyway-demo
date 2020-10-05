package com.example.flywaydemo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    @Size(max = 50)
    private String name;
    @NonNull
    @Email
    @Size(max = 50)
    private String email;
    @NonNull
    @Size(max = 20)
    private String gender;
    @OneToMany(targetEntity = Product.class, orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_customer"))
    private List<Product> products = new ArrayList<>();
}
