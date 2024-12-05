package net.weg.spring.estoque.controller;

import lombok.AllArgsConstructor;
import net.weg.spring.estoque.model.Categoria;
import net.weg.spring.estoque.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoriaController {
    private CategoriaService service;

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria) {
        categoria = service.create(categoria);
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@RequestBody Categoria categoria, @PathVariable Integer id) {
        categoria = service.update(categoria, id);
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
        try {
            Categoria categoria = service.findById(id);
            return new ResponseEntity<>(categoria, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        List<Categoria> categorias = service.findAll();
        if (!categorias.isEmpty()) {
            return new ResponseEntity<>(categorias, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
