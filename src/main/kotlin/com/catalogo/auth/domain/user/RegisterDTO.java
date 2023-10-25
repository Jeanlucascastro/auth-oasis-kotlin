package com.catalogo.auth.domain.user;

import com.catalogo.auth.domain.Company;

public record RegisterDTO(String login, String password, UserRole role, Company company) {
}
