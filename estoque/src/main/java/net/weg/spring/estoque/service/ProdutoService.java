package net.weg.spring.estoque.service;

import lombok.AllArgsConstructor;
import net.weg.spring.estoque.controller.dto.Request.ProdutoRequestDTO;
import net.weg.spring.estoque.controller.dto.Response.ProdutoResponseDTO;
import net.weg.spring.estoque.model.Produto;
import net.weg.spring.estoque.repository.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProdutoService {

    private ProdutoRepository repository;
    private FabricanteService fabricanteService;
    private CategoriaService categoriaService;

    public Produto create(ProdutoRequestDTO produtoDto) {
        if(repository.existsByBarras(produtoDto.getBarras())) {
            throw new RuntimeException();
        }
        Produto produto = produtoDto.convert();
        return repository.save(produto);
    }

    public Produto update(Produto produto, Integer id) {
        produto.setId(id);
        System.out.println(produto);
        return repository.save(produto);
    }

    public Produto findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }


    public Page<Produto> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Produto DtoToEntity(ProdutoRequestDTO produtoRequestDTO) {
        Produto produto = new Produto();
        produto.setNome(produtoRequestDTO.getNome());
        produto.setPreco(produtoRequestDTO.getPreco());
        produto.setEstoque(produtoRequestDTO.getEstoque());
        produto.setData_validade(produtoRequestDTO.getData_validade());
        produto.setDescricao(produtoRequestDTO.getDescricao());
        produto.setBarras(produtoRequestDTO.getBarras());
        produto.setMedida(produtoRequestDTO.getMedida());
        produto.setPeso(produtoRequestDTO.getPeso());
        produto.setPeso(produtoRequestDTO.getPeso());
        produto.setMedida(produtoRequestDTO.getMedida());
        produto.setCategoria(produtoRequestDTO.getCategoria());
        produto.setFabricante(produtoRequestDTO.getFabricante());
        return produto;
    }

    public ProdutoResponseDTO EntityToDto(Produto produto) {
        return new ProdutoResponseDTO(produto.getId(), produto.getNome(), produto.getPreco(), produto.getEstoque(), produto.getData_validade(), produto.getDescricao(),
                produto.getBarras(), produto.getMedida(), produto.getPeso(),
                fabricanteService.EntityToDto(produto.getFabricante()), categoriaService.EntityToDto(produto.getCategoria()));
    }
}
