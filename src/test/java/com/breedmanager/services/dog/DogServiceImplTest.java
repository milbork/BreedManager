package com.breedmanager.services.dog;


import com.breedmanager.model.DTO.DogDTO;
import com.breedmanager.model.User;
import com.breedmanager.repositories.DogRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DogServiceImplTest {

    @Test
    void shouldReturnFalseIfDogDoesNotExist() {

        DogRepository dogRepository = mock(DogRepository.class);
        DogServiceImpl dogService = new DogServiceImpl(dogRepository);
        User user = new User();
        when(dogRepository.findByOwnerAndDateOfBirthAndBreedAndName(user, "01.01.2001", "golden", "burek"))
                .thenReturn(null);

        Assertions.assertFalse(
        dogService.checkIfDogAlreadyExist(new DogDTO("golden", "burek", user, "01.01.2001")));
    }
}
