package com.breedmanager.controllers;

import com.breedmanager.DTO.UserDTO;
import com.breedmanager.data.CurrentUser;
import com.breedmanager.entitis.User;
import com.breedmanager.services.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String showUserPanel(Model model, @AuthenticationPrincipal CurrentUser customUser) {
        model.addAttribute("username", userService.getUsersDataById(customUser.getUser().getId()));
        model.addAttribute("function", userService.getUsersFunctionById(customUser.getUser().getId()));
        return "user/userPanel";
    }


    @RequestMapping(path = {"/edit"}, method = RequestMethod.GET)
    public String editUser(Model model) {
        model.addAttribute("user", new UserDTO());
        return "user/editUser";
    }

    @RequestMapping(path = {"/edit"}, method = RequestMethod.POST)
    public String editUser(@ModelAttribute("user") @Valid UserDTO userDTO,
                           BindingResult result,
                           @AuthenticationPrincipal CurrentUser customUser) {

        if (result.hasErrors()) {
            return "user/editUser";
        }
        User entityUser = customUser.getUser();
        userDTO.setId(entityUser.getId());
        userService.editProfile(userDTO);
        return "redirect:/user";
    }

    @RequestMapping(path = {"/dog/show"}, method = RequestMethod.GET)
    public String showDogs(Model model, @AuthenticationPrincipal CurrentUser customUser) {
        model.addAttribute("doggo", userService.getDogsForUser(customUser.getUser().getId()));

        return "dog/showDogs";
    }

//    @RequestMapping(path = "/removeUser", method = RequestMethod.GET)
//    public String deleteUser(@AuthenticationPrincipal CurrentUser customUser) {
//        User entityUser = customUser.getUser();
//        userService.removeUser(entityUser.getId());
//        return "redirect:/index";
//    }
}


