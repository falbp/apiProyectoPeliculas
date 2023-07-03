package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.PeliculaDTO;
import com.example.models.PeliculaEntity;
import com.example.repositories.PeliculaRepository;
import com.example.service.PeliculaService;

import jakarta.validation.Valid;

@RestController
public class PeliculaController {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private PeliculaService peliculaService;

    @PostMapping("/registrarPelicula")
    public ResponseEntity<?> createUser(@Valid @RequestBody PeliculaDTO peliculaDTO) {

        peliculaService.registrar(peliculaDTO);

        return ResponseEntity.ok(peliculaDTO);
    }

    @GetMapping("/listadoPeliculas")
    public List<PeliculaEntity> listado() {
        return (List<PeliculaEntity>) peliculaRepository.findAll();
    }

    @GetMapping("/verPelicula/{id}")
    public PeliculaEntity verPelicula(@PathVariable("id") Long id) {
        return peliculaService.findById(id);
    }

    @DeleteMapping("/eliminarPelicula/{id}")
    public String eliminarPelicula(@PathVariable("id") Long id) {
        return peliculaService.eliminarPelicula(id);
    }

    @GetMapping("/buscarPelicula")
    public PeliculaEntity buscarPelicula(@RequestParam(value = "buscar") String titulo) {
        return peliculaService.buscarPelicula(titulo);
    }

    @PutMapping({ "/actualizarPelicula/{id}" })
    public ResponseEntity<?> updateTodo(@PathVariable("id") Long id, @RequestBody PeliculaDTO peliculaDTO) {

        peliculaService.actualizar(peliculaDTO, id);

        return ResponseEntity.ok(peliculaDTO);
    }

}