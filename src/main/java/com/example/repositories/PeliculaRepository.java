package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.PeliculaEntity;

@Repository
public interface PeliculaRepository extends CrudRepository<PeliculaEntity, Long> {

    PeliculaEntity findByTitulo(String titulo);

}
