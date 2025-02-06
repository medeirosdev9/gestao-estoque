package net.weg.spring.estoque.controller.dto.Request;

import jakarta.validation.constraints.NotBlank;

public record CategoryPostRequestDTO(@NotBlank String nome, String descricao) {
}
