package com.example.odeonAirlines.controller.model;

import lombok.*;

import java.util.Objects;
import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private String username;
    private String firstName;
    private String lastName;
    private String city;
    private Set<String> roles;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        UserResponseDTO that = (UserResponseDTO) object;
        return Objects.equals(username, that.username) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(city, that.city) && Objects.equals(roles, that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, firstName, lastName, city, roles);
    }
}

