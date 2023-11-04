package com.catalogo.auth.domain.user;

public record LoginResponseDTO(String token, UserDTO user) {
}
