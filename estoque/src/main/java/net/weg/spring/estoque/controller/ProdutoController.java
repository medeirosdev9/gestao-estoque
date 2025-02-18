package net.weg.spring.estoque.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.spring.estoque.controller.dto.Request.ProdutoRequestDTO;
import net.weg.spring.estoque.model.Produto;
import net.weg.spring.estoque.service.ProdutoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
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

//    @GetMapping("/categoria/{id}")
//    public ResponseEntity<Page<Produto>> getProdutosByCategory(@PageableDefault(
//            size = 20, sort = "nome", direction = Sort.Direction.ASC) Pageable pageable, @PathVariable (name = "id") Integer categoryId) {
//        Page<Produto> produtos = service.getProductsByCategoryId(categoryId);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Integer id) {
        try {
            Produto produto = service.findById(id);
            return new ResponseEntity<>(produto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Produto>> findAll(
            @PageableDefault(page = 0, size = 20, sort = "nome", direction = Sort.Direction.DESC) Pageable pageable) {
        try {
            Page<Produto> produtos = service.findAll(pageable);
            return new ResponseEntity<>(produtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
