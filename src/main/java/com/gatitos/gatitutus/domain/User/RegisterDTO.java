package com.gatitos.gatitutus.domain.User;

public record RegisterDTO(String login, String password, UserRole role) {
}
