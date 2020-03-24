package com.breedmanager.services;

import com.breedmanager.DTO.DogDTO;
import com.breedmanager.entitis.User;
import com.breedmanager.repositories.DogRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DogServiceTest {

    @Test
    void shouldReturnFalseIfDogDoesNotExist() {

        DogRepository dogRepository = mock(DogRepository.class);
        DogService dogService = new DogService(dogRepository);
        User user = new User();
        when(dogRepository.findByOwnerAndDateOfBirthAndBreedAndName(user, "01.01.2001", "golden", "burek"))
                .thenReturn(null);

        Assertions.assertFalse(
        dogService.checkIfDogAlreadyExist(new DogDTO("golden", "burek", user, "01.01.2001")));
    }
}