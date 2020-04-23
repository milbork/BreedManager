package com.breedmanager.controllers;

import com.breedmanager.model.DTO.DogDTO;
import com.breedmanager.configuration.CurrentUser;
import com.breedmanager.services.dog.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user/dog")
public class DogController {

    private DogService dogService;

    @Autowired
    public DogController(DogService dogService) {
        this.dogService = dogService;
    }


    @GetMapping(path = {"/add"})
    public String addDog(Model model) {
        model.addAttribute("dog", new DogDTO());

        return "dog/addDog";
    }

    @PostMapping(path = {"/add"})
    public String addDog(@ModelAttribute("dog") @Valid DogDTO dogDTO,
                         BindingResult result,
                         @AuthenticationPrincipal CurrentUser customUser) {

        if (result.hasErrors() || dogService.checkIfDogAlreadyExist(dogDTO)) {
            return "dog/addDog";
        }

        dogDTO.setOwner(customUser.getUser());
        dogService.addDog(dogDTO);
        return "redirect:/user";
    }

    @GetMapping(path = {"/edit/{id}"})
    public String editDog(Model model, @PathVariable Long id) {
        model.addAttribute("dog", new DogDTO());
        return "dog/editDog";
    }

    @PostMapping(path = {"/edit/{id}"})
    public String editDog(@ModelAttribute("dog") @Valid DogDTO dogDTO,
                          BindingResult result,
                          @PathVariable Long id,
                          @AuthenticationPrincipal CurrentUser customUser) {

        if (result.hasErrors()) {
            return "/edit/{id}";
        }

        dogDTO.setId(id);
        dogDTO.setOwner(customUser.getUser());
        dogService.editDog(dogDTO);
        return "redirect:/user";
    }

    @GetMapping(path = "/remove/{id}")
    public String deleteDog(@PathVariable Long id) {
        dogService.removeDog(id);
        return "redirect:/user";
    }

    @GetMapping(path = {"/show"})
    public String showDogs(Model model, @AuthenticationPrincipal CurrentUser customUser) {
        model.addAttribute("doggo", dogService.showDogs(customUser.getUser().getId()));
        return "dog/showDogs";
    }


}
