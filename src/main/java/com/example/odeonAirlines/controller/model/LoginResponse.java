package com.example.odeonAirlines.controller.model;


import lombok.*;

import java.util.List;
import java.util.Objects;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginResponse {
    private String token;
    private List<String> roles;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        LoginResponse that = (LoginResponse) object;
        return Objects.equals(token, that.token) && Objects.equals(roles, that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, roles);
    }
}
