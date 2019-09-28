package com.breedmanager.controllers;

import com.breedmanager.DTO.BreedingDTO;
import com.breedmanager.data.CurrentUser;
import com.breedmanager.services.BreedingService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/user/breeding")
public class BreedingController {

    private BreedingService breedingService;

    public BreedingController(BreedingService breedingService) {
        this.breedingService = breedingService;
    }


    @RequestMapping(path = {"/add"}, method = RequestMethod.GET)
    public String addBreed(Model model) {
        model.addAttribute("breeding", new BreedingDTO());
        return "breeding/addBreeding";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String addBreed(@ModelAttribute("breeding") @Valid BreedingDTO breedingDTO, BindingResult result, @AuthenticationPrincipal CurrentUser currentUser) {

        if (result.hasErrors()) {
            return "breeding/addBreeding";
        }

        breedingDTO.setBreeder(currentUser.getUser());
        breedingService.addBreeding(breedingDTO);

        return "/";
    }
}
