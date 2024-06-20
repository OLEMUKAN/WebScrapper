package com.gilbert.webscrapper.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String firstName;
    private String lastName;
    private String organizationName;
    private String postalAddress;
    private String serviceType;
    private String gender;
    private String countryRegion;
    private String mobilePhone;

    // Constructors, getters, setters
}
