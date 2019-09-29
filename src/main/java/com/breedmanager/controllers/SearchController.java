package com.breedmanager.controllers;

import com.breedmanager.services.BreedingService;
import com.breedmanager.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SearchController {

    private BreedingService breedingService;

    public SearchController(BreedingService breedingService) {
        this.breedingService = breedingService;
    }

    @RequestMapping(path = "/user/search", method = RequestMethod.GET)
        public String findBreeder(Model model, @RequestParam String text){
        System.out.println(text);
        model.addAttribute("search", breedingService.searchForBreedingsByDogsBreed(text));
        return "user/search";
    }

}
