package com.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "peliculas")
public class PeliculaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 100)
    private String titulo;
    @NotBlank
    @Size(max = 50)
    private String direccion;
    @NotBlank
    @Size(max = 50)
    private String guion;

    @NotBlank
    @Size(max = 50)
    private String idioma;

    @NotBlank
    @Size(max = 50)
    private String genero;

    private int duracion;
    private int anioEstreno;
    @NotBlank
    @Size(max = 255)
    private String portada;
    @NotBlank
    @Size(max = 255)
    private String url;

}
