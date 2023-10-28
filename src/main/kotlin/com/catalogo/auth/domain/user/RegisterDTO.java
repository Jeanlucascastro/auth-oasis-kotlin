package com.catalogo.auth.domain.user;

public record RegisterDTO(String login, String password, UserRole role, Long companyId) {
}
