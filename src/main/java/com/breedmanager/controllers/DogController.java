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

import javax.validation.Valid;

@Controller
@RequestMapping("/user/dog")
public class DogController {

    private DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }


    @RequestMapping(path = {"/add"}, method = RequestMethod.GET)
    public String addDog(Model model) {
        model.addAttribute("dog", new DogDTO());
        return "dog/addDog";
    }

    @RequestMapping(path = {"/add"}, method = RequestMethod.POST)
    public String addDog(@ModelAttribute("dog") @Valid DogDTO dogDTO,
                         BindingResult result,
                         @AuthenticationPrincipal CurrentUser customUser) {

        if (result.hasErrors()) {
            return "/add";
        }
        User entityUser = customUser.getUser();
        dogDTO.setOwner(entityUser);
        dogService.addDog(dogDTO);
        return "redirect:/user";
    }

    @RequestMapping(path = {"/edit/{id}"}, method = RequestMethod.GET)
    public String editDog(Model model, @PathVariable Long id) {
        model.addAttribute("dog", new DogDTO());
        return "dog/editDog";
    }

    @RequestMapping(path = {"/edit/{id}"}, method = RequestMethod.POST)
    public String editDog(@ModelAttribute("dog") @Valid DogDTO dogDTO,
                          @PathVariable Long id,
                          @AuthenticationPrincipal CurrentUser customUser,
                          BindingResult result) {

        if (result.hasErrors()) {
            return "/edit/{id}";
        }
        dogDTO.setId(id);
        dogDTO.setOwner(customUser.getUser());
        dogService.editDog(dogDTO);
        return "redirect:show";
    }

    @RequestMapping(path = "/remove/{id}", method = RequestMethod.GET)
    public String deleteDog(@PathVariable Long id) {
        dogService.removeDog(id);
        return "redirect:/user/dog/show";
    }

}
