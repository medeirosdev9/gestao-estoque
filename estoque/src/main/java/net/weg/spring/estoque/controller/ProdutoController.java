package net.weg.spring.estoque.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.spring.estoque.controller.dto.Request.ProdutoRequestDTO;
import net.weg.spring.estoque.controller.dto.Response.ProdutoResponseDTO;
import net.weg.spring.estoque.model.Produto;
import net.weg.spring.estoque.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProdutoController {
    private ProdutoService service;

    @PostMapping
    public ResponseEntity<Produto> createProduct(@RequestBody @Valid ProdutoRequestDTO produtoDto) {
        try {
            Produto produto = service.create(produtoDto);
            return new ResponseEntity<>(produto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@RequestBody Produto produto, @PathVariable Integer id) {
        produto = service.update(produto, id);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Integer id) {
        try {
            Produto produto = service.findById(id);
            return new ResponseEntity<>(produto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> produtos = service.findAll();
        if (!produtos.isEmpty()) {
            return new ResponseEntity<>(produtos, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
