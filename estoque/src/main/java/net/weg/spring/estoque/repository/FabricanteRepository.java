package net.weg.spring.estoque.repository;

import net.weg.spring.estoque.model.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Integer> {
}
