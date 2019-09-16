package com.breedmanager.controllers;

import com.breedmanager.DTO.DogDTO;
import com.breedmanager.data.CurrentUser;
import com.breedmanager.entitis.User;
import com.breedmanager.services.DogService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class DogController {

    private DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }


    @RequestMapping(path = {"/addDog"}, method = RequestMethod.GET)
    public String addDog(Model model) {
        model.addAttribute("dog", new DogDTO());
        return "dog/addDog";
    }

    @RequestMapping(path = {"/addDog"}, method = RequestMethod.POST)
    public String addDog(@ModelAttribute("dog") DogDTO dogDTO,
                         BindingResult result,
                         @AuthenticationPrincipal CurrentUser customUser) {

        if (result.hasErrors()) {
            return "error";
        }
        User entityUser = customUser.getUser();
        dogDTO.setOwner(entityUser);
        dogService.addDog(dogDTO);
        return "redirect:/user";
    }

    @RequestMapping(path = {"/editDog/{id}"}, method = RequestMethod.GET)
    public String editDog(Model model, @PathVariable Long id) {
        model.addAttribute("dog", new DogDTO());
        return "dog/editDog";
    }

    @RequestMapping(path = {"/editDog/{id}"}, method = RequestMethod.POST)
    public String editDog(@ModelAttribute("dog") DogDTO dogDTO,
                          @PathVariable Long id,
                          @AuthenticationPrincipal CurrentUser customUser,
                          BindingResult result) {

        if (result.hasErrors()) {
            return "error";
        }
        dogDTO.setId(id);
        dogDTO.setOwner(customUser.getUser());
        dogService.editDog(dogDTO);
        return "redirect:showDogs";
    }

    @RequestMapping(path = "/removeDog/{id}", method = RequestMethod.GET)
    public String deleteDog(@PathVariable Long id) {
        dogService.removeDog(id);
        return "redirect:/user/showDogs";
    }

}
