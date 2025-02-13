package net.weg.spring.estoque.controller.dto.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import net.weg.spring.estoque.model.Categoria;
public record CategoryPostRequestDTO(
        @NotBlank String nome,
        String descricao) {
    public Categoria convert() {
        return Categoria.builder()
                .nome(this.nome)
                .descricao(this.descricao)
                .build();
    }
}
