package com.breedmanager.controllers;

import com.breedmanager.DTO.DogDTO;
import com.breedmanager.DTO.UserDTO;
import com.breedmanager.data.CurrentUser;


import com.breedmanager.entitis.User;
import com.breedmanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String userPanel(Model model, @AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        model.addAttribute("username", entityUser.getFirstName());
        return "userPanel";
    }

    @RequestMapping(path = {"/addDog"}, method = RequestMethod.GET)
    public String addUser(Model model) {
        model.addAttribute("dog", new DogDTO());
        return "addDog";
    }

    @RequestMapping(path = {"/addDog"}, method = RequestMethod.POST)
    public String registerUserAccount(@ModelAttribute("dog") DogDTO dogDTO,
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
    public String addUserUser(Model model) {
        model.addAttribute("user", new UserDTO());
        return "editUser";
    }

    @RequestMapping(path = {"/editUser"}, method = RequestMethod.POST)
    public String registerUserAccount(@ModelAttribute("user") UserDTO userDTO,
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
}


