package com.example.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeliculaDTO {
    @NotBlank
    private String titulo;
    @NotBlank
    private String direccion;
    @NotBlank
    private String guion;
    @NotBlank
    private String idioma;
    @NotBlank
    private String genero;
    private int duracion;
    private int anioEstreno;
    @NotBlank
    private String portada;
    @NotBlank
    private String url;
}
