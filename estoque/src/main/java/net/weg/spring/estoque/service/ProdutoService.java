package net.weg.spring.estoque.service;

import lombok.AllArgsConstructor;
import net.weg.spring.estoque.model.Produto;
import net.weg.spring.estoque.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {
    private ProdutoRepository repository;

    public Produto create(Produto produto) {
        return repository.save(produto);
    }

    public Produto update(Produto produto, Integer id) {
        produto.setId(id);
        return repository.save(produto);
    }

    public Produto findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }


    public List<Produto> findAll() {
        return repository.findAll();
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }


}
