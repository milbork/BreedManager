package com.breedmanager.interfaces;

import com.breedmanager.entitis.Breeder;
import com.breedmanager.entitis.Dog;
import com.breedmanager.entitis.User;

public interface UserInterface {
    User editUser();
    User removeAccount();

    Breeder findBreeding();
    Dog addDog();
    Dog editDog();
    Dog removeDog();

}
