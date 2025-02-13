package net.weg.spring.estoque.repository;

import jakarta.validation.constraints.NotNull;
import net.weg.spring.estoque.model.Categoria;
import net.weg.spring.estoque.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    Page<Produto> findByCategoria(Pageable pageable, Categoria categoria);
    boolean existsByBarras(String barcode);
}
