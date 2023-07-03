package com.example.service;

import java.util.List;

import com.example.dto.PeliculaDTO;
import com.example.models.PeliculaEntity;

public interface PeliculaService {

    public PeliculaEntity registrar(PeliculaDTO peliculaDTO);

    public List<PeliculaEntity> listado();

    public PeliculaEntity findById(Long id);

    public String eliminarPelicula(Long id);

    public PeliculaEntity actualizar(PeliculaDTO peliculaDTO, Long id);

    public PeliculaEntity buscarPelicula(String titulo);

}
