package com.resumedmodel.resumedmodel.models.DTO;

public record UserDTO(
        Long id,
        String name,
        String email,
        String description
) {
}
