package com.example.odeonAirlines.service.Impl;

import com.example.odeonAirlines.controller.model.UserRequestDTO;
import com.example.odeonAirlines.controller.model.UserResponseDTO;
import com.example.odeonAirlines.entity.Role;
import com.example.odeonAirlines.entity.User;
import com.example.odeonAirlines.exception.RoleNotFoundException;
import com.example.odeonAirlines.exception.UsernameAlreadyException;
import com.example.odeonAirlines.repository.RoleRepository;
import com.example.odeonAirlines.repository.UserRepository;
import com.example.odeonAirlines.service.SaveUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SaveUserServiceImpl implements SaveUserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDTO save(UserRequestDTO request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new UsernameAlreadyException();
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setCity(request.getCity());

        String roleName = request.getRole().equalsIgnoreCase("ADMIN") ? "ADMIN" : "USER";

        Role role = roleRepository.findByName(roleName).orElseThrow(RoleNotFoundException::new);

        user.getRoles().add(role);

        User savedUser = userRepository.save(user);

        UserResponseDTO response = new UserResponseDTO();
        response.setUsername(savedUser.getUsername());
        response.setFirstName(savedUser.getFirstName());
        response.setLastName(savedUser.getLastName());
        response.setCity(savedUser.getCity());

        Set<String> roleNames = savedUser.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toSet());
        response.setRoles(roleNames);

        return response;
    }
}
