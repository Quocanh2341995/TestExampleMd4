package com.example.managercity_module4.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "nationals")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class National {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "national", fetch = FetchType.LAZY)
    private List<City> cities;
}
