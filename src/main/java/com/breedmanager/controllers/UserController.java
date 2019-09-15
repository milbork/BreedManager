package com.breedmanager.controllers;

import com.breedmanager.DTO.DogDTO;
import com.breedmanager.DTO.UserDTO;
import com.breedmanager.data.CurrentUser;
import com.breedmanager.entitis.User;
import com.breedmanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String showUserPanel(Model model, @AuthenticationPrincipal CurrentUser customUser) {
        model.addAttribute("username", userService.getUsersDataById(customUser.getUser().getId()));
        return "userPanel";
    }

    @RequestMapping(path = {"/addDog"}, method = RequestMethod.GET)
    public String addDog(Model model) {
        model.addAttribute("dog", new DogDTO());
        return "addDog";
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
        userService.addDog(dogDTO);
        return "redirect:/user";
    }

    @RequestMapping(path = {"/editUser"}, method = RequestMethod.GET)
    public String editUser(Model model) {
        model.addAttribute("user", new UserDTO());
        return "editUser";
    }

    @RequestMapping(path = {"/editUser"}, method = RequestMethod.POST)
    public String editUser(@ModelAttribute("user") UserDTO userDTO,
                           BindingResult result,
                           @AuthenticationPrincipal CurrentUser customUser) {

        if (result.hasErrors()) {
            return "error";
        }
        User entityUser = customUser.getUser();
        userDTO.setId(entityUser.getId());
        userService.editProfile(userDTO);
        return "redirect:/user";
    }

    @RequestMapping(path = {"/showDogs"}, method = RequestMethod.GET)
    public String showDogs(Model model, @AuthenticationPrincipal CurrentUser customUser) {
        model.addAttribute("doggo", userService.getDogsForUser(customUser.getUser().getId()));

        return "showDogs";
    }

    @RequestMapping(path = {"/editDog/{id}"}, method = RequestMethod.GET)
    public String editDog(Model model, @PathVariable Long id) {
        model.addAttribute("dog", new DogDTO());
        return "editDog";
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
        userService.editDog(dogDTO);
        return "redirect:showDogs";
    }

    @RequestMapping (path = {"/removeDog/{id}"}, method = RequestMethod.GET)
    public String removeDog(Model model, @PathVariable Long id) {
        model.addAttribute("dog", new DogDTO());
        return "removeDog";
    }
}


