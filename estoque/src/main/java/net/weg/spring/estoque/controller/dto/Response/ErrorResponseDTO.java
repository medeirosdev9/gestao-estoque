package net.weg.spring.estoque.controller.dto.Response;

import java.time.Instant;

public record ErrorResponseDTO(String mensagem, Instant instant) {
}
