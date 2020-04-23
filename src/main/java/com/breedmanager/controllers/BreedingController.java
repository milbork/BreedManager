package com.breedmanager.controllers;

import com.breedmanager.model.DTO.BreedingDTO;
import com.breedmanager.configuration.CurrentUser;
import com.breedmanager.services.breeding.BreedingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/user/breeding")
public class BreedingController {

    private BreedingService breedingService;

    @Autowired
    public BreedingController(BreedingService breedingService) {
        this.breedingService = breedingService;
    }


    @GetMapping(path = {"/add"})
    public String addBreed(Model model) {
        model.addAttribute("breeding", new BreedingDTO());
        return "breeding/addBreeding";
    }

    @PostMapping(path = "/add")
    public String addBreed(@ModelAttribute("breeding") @Valid BreedingDTO breedingDTO, BindingResult result, @AuthenticationPrincipal CurrentUser currentUser) {

        if (result.hasErrors()) {
            return "breeding/addBreeding";
        }

        if (breedingService.findBreedingByBreeder(currentUser.getUser()) != null) {
            return "user/userPanel";
        }

        breedingDTO.setBreeder(currentUser.getUser());
        breedingService.addBreeding(breedingDTO);

        return "user/userPanel";
    }

    @GetMapping(path = {"/show"})
    public String showBreeding(Model model, @AuthenticationPrincipal CurrentUser customUser) {
        model.addAttribute("breeding", breedingService.findBreedingByBreeder(customUser.getUser()));
        return "breeding/showBreeding";
    }

    @GetMapping(path = {"/edit"})
    public String editBreeding(Model model) {
        model.addAttribute("breeding", new BreedingDTO());
        return "breeding/editBreeding";
    }

    @PostMapping(path = {"/edit"})
    public String editBreeding(@ModelAttribute("breeding") @Valid BreedingDTO breedingDTO,
                               BindingResult result,
                               @AuthenticationPrincipal CurrentUser customUser) {

        if (result.hasErrors()) {
            return "/edit";
        }

        breedingDTO.setId(customUser.getUser().getBreeding().getId());
        breedingDTO.setBreeder(customUser.getUser());
        breedingService.editBreeding(breedingDTO);

        return "redirect:/user";
    }

    @GetMapping(path = "/delete")
    public String deleteBreeding(@AuthenticationPrincipal CurrentUser currentUser) {
        breedingService.deleteBreeding(currentUser.getUser().getId());
        return "breeding/show";
    }

}
