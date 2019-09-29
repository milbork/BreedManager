package com.breedmanager.controllers;

import com.breedmanager.DTO.BreedingDTO;
import com.breedmanager.services.BreedingService;
import com.breedmanager.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SearchController {

    private UserService userService;
    private BreedingService breedingService;

    public SearchController(UserService userService, BreedingService breedingService) {
        this.userService = userService;
        this.breedingService = breedingService;
    }

    @RequestMapping(path = "/user/search", method = RequestMethod.GET)
        public String findBreeder(Model model, @RequestParam String text){
        System.out.println(text);
        model.addAttribute("search", breedingService.findBreedings(text));
        return "user/search";
    }

}
