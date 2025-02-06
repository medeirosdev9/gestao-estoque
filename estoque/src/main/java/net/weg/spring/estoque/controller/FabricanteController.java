package net.weg.spring.estoque.controller;

import lombok.AllArgsConstructor;
import net.weg.spring.estoque.controller.dto.Response.FabricanteResponseDTO;
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
    public ResponseEntity<FabricanteResponseDTO> create(@RequestBody Fabricante fabricante) {
        return new ResponseEntity<>(service.create(fabricante) , HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FabricanteResponseDTO> update(@RequestBody Fabricante fabricante, @PathVariable Integer id) {
        return new ResponseEntity<>(service.update(fabricante, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FabricanteResponseDTO> findById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>( service.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<FabricanteResponseDTO>> findAll() {
        List<FabricanteResponseDTO> fabricantes = service.findAll();
        if (!fabricantes.isEmpty()) {
            return new ResponseEntity<>(fabricantes, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
