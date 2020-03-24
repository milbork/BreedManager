package com.breedmanager.services;

import com.breedmanager.DTO.UserDTO;
import com.breedmanager.entitis.User;
import com.breedmanager.repositories.RoleRepository;
import com.breedmanager.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Test
    void shouldReturnFalseIfUserDoesNotExist() {

        UserRepository userRepository = mock(UserRepository.class);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        RoleRepository roleRepository = mock(RoleRepository.class);
        UserService userService = new UserService(userRepository, passwordEncoder, roleRepository);

        when(userRepository.findUserByEmail("abc@xyz.com")).thenReturn(null);

        Assertions.assertFalse(userService.checkIfUserAlreadyExist(new UserDTO("abc@xyz.com")));
    }

    @Test
    void shouldReturnTrueIfEmailIsAlreadyUsed() {

        User user = new User();
        UserDTO userDTO = new UserDTO("aaa@abc.abc");
        UserRepository userRepository = mock(UserRepository.class);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        RoleRepository roleRepository = mock(RoleRepository.class);
        UserService userService = new UserService(userRepository, passwordEncoder, roleRepository);

        when(userRepository.findUserByEmail("aaa@abc.abc")).thenReturn(user);

        Assertions.assertTrue(userService.checkIfEmailIsAlreadyUsed("abc@abc.abc", userDTO));
    }
}