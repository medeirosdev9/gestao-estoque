package net.weg.spring.estoque.controller.dto.Request;

import lombok.Data;

public record FabricanteRequestDTO(
         String nome,
         String descricao
) {
}
