package net.weg.spring.estoque.controller;

import lombok.AllArgsConstructor;
import net.weg.spring.estoque.model.Fabricante;
import net.weg.spring.estoque.service.FabricanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/manufactures")
@AllArgsConstructor
public class FabricanteController {
    private FabricanteService service;

    @PostMapping
    public ResponseEntity<Fabricante> create(@RequestBody Fabricante fabricante) {
        fabricante = service.create(fabricante);
        return new ResponseEntity<>(fabricante, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fabricante> update(@RequestBody Fabricante fabricante, @PathVariable Integer id) {
        fabricante = service.update(fabricante, id);
        return new ResponseEntity<>(fabricante, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fabricante> findById(@PathVariable Integer id) {
        try {
            Fabricante fabricante = service.findById(id);
            return new ResponseEntity<>(fabricante, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Fabricante>> findAll() {
        List<Fabricante> fabricantes = service.findAll();
        if (!fabricantes.isEmpty()) {
            return new ResponseEntity<>(fabricantes, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
