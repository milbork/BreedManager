package com.breedmanager.interfaces;

import com.breedmanager.entitis.Breeder;
import com.breedmanager.entitis.Dog;
import com.breedmanager.entitis.Litter;

public interface BreederInterface {
    Breeder editBreeder();

    Dog addDog();
    Dog editDog();
    Dog removeDog();

    Litter addLitter();
    Litter editLitter();
    Litter removeLitter();

}
