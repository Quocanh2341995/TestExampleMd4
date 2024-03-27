package com.example.managercity_module4.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "citys")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "City name cannot be left blank.")
    private String name;

    @ManyToOne
    @NotNull(message = "National cannot be left blank.")
    private National national;

    @NotBlank(message = "Area cannot be left blank.")
    private Long area;

    @NotBlank(message = "Population cannot be left blank.")
    private Long population;

    @NotBlank(message = "Gdp cannot be left blank.")
    private Long gdp;

    @NotBlank(message = "Description cannot be left blank.")
    private String description;


}
