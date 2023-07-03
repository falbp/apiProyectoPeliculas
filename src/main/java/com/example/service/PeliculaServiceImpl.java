package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.PeliculaDTO;
import com.example.models.PeliculaEntity;
import com.example.repositories.PeliculaRepository;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public PeliculaEntity registrar(PeliculaDTO peliculaDTO) {
        PeliculaEntity pelicula = PeliculaEntity.builder()
                .titulo(peliculaDTO.getTitulo())
                .direccion(peliculaDTO.getDireccion())
                .guion(peliculaDTO.getGuion())
                .idioma(peliculaDTO.getIdioma())
                .genero(peliculaDTO.getGenero())
                .duracion(peliculaDTO.getDuracion())
                .anioEstreno(peliculaDTO.getAnioEstreno())
                .portada(peliculaDTO.getPortada())
                .url(peliculaDTO.getUrl())
                .build();
        return peliculaRepository.save(pelicula);
    }

    @Override
    public List<PeliculaEntity> listado() {
        return (List<PeliculaEntity>) peliculaRepository.findAll();
    }

    @Override
    public PeliculaEntity findById(Long id) {
        return peliculaRepository.findById(id).get();
    }

    @Override
    public String eliminarPelicula(Long id) {
        if (peliculaRepository.existsById(id)) {
            peliculaRepository.deleteById(id);
            return "Pelicula Eliminada";
        } else {
            return "No se pudo eliminar la Pelicula";
        }
    }

    @Override
    public PeliculaEntity actualizar(PeliculaDTO peliculaDTO, Long id) {
        PeliculaEntity pelicula = peliculaRepository.findById(id).get();

        pelicula.setTitulo(peliculaDTO.getTitulo());
        pelicula.setDireccion(peliculaDTO.getDireccion());
        pelicula.setGuion(peliculaDTO.getGuion());
        pelicula.setIdioma(peliculaDTO.getIdioma());
        pelicula.setGenero(peliculaDTO.getGenero());
        pelicula.setDuracion(peliculaDTO.getDuracion());
        pelicula.setAnioEstreno(peliculaDTO.getAnioEstreno());
        pelicula.setPortada(peliculaDTO.getPortada());
        pelicula.setUrl(peliculaDTO.getUrl());

        return peliculaRepository.save(pelicula);

    }

    @Override
    public PeliculaEntity buscarPelicula(String titulo) {
        return peliculaRepository.findByTitulo(titulo);
    }

}
