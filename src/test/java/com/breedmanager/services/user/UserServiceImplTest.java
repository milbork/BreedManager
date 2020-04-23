package com.breedmanager.services.user;

import com.breedmanager.model.DTO.UserDTO;
import com.breedmanager.model.User;
import com.breedmanager.repositories.RoleRepository;
import com.breedmanager.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserServiceImplTest {

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;
    private UserServiceImpl userServiceImpl;

    @BeforeEach
    void initialize() {
        userRepository = mock(UserRepository.class);
        passwordEncoder = new BCryptPasswordEncoder();
        roleRepository = mock(RoleRepository.class);
        userServiceImpl = new UserServiceImpl(userRepository, passwordEncoder, roleRepository);
    }

    @Test
    void shouldReturnFalseIfUserDoesNotExist() {

        when(userRepository.findUserByEmail("abc@xyz.com")).thenReturn(null);

        Assertions.assertFalse(userServiceImpl.checkIfUserAlreadyExist(new UserDTO("abc@xyz.com")));
    }

    @Test
    void shouldReturnTrueIfEmailIsAlreadyUsed() {

        User user = new User();
        UserDTO userDTO = new UserDTO("aaa@abc.abc");

        when(userRepository.findUserByEmail("aaa@abc.abc")).thenReturn(user);

        Assertions.assertTrue(userServiceImpl.checkIfEmailIsAlreadyUsed("abc@abc.abc", userDTO));
    }

    @Test
    void shouldPassIfObjectsAreEquals() {
        // test created only for education purpose, dosen't have logical value

        User user = new User("Jan", "Kowalski", "aaa@aa.aa");
        when(userRepository.findUserById(1L)).thenReturn(user);

        Assertions.assertEquals(user, userRepository.findUserById(1L));
    }


}
