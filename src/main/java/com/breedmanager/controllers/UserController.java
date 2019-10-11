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
public class UserController {

    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // REGISTRATION

    @RequestMapping(path = {"/registration"}, method = RequestMethod.GET)
    public String addUser(Model model) {
        model.addAttribute("user", new UserDTO());
        return "user/addUser";
    }

    @RequestMapping(path = {"/registration"}, method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") @Valid UserDTO userDTO,
                                      BindingResult result) {

        if (result.hasErrors()) {
            return "user/addUser";
        }

        userService.addUser(userDTO);
        return "redirect:/login";
    }

    // DISPLAY USER

    @GetMapping(path = "/user")
    public String showUserPanel(Model model, @AuthenticationPrincipal CurrentUser customUser) {
        model.addAttribute("username", userService.getUsersDataById(customUser.getUser().getId()));
        model.addAttribute("function", userService.getUsersFunctionById(customUser.getUser().getId()));
        return "user/userPanel";
    }

    // EDIT

    @RequestMapping(path = {"/user/edit"}, method = RequestMethod.GET)
    public String editUser(Model model) {
        model.addAttribute("user", new UserDTO());
        return "user/editUser";
    }

    @RequestMapping(path = {"/user/edit"}, method = RequestMethod.POST)
    public String editUser(@ModelAttribute("user") @Valid UserDTO userDTO,
                           BindingResult result,
                           @AuthenticationPrincipal CurrentUser customUser) {

        if (result.hasErrors()) {
            return "user/editUser";
        }
        userDTO.setId(customUser.getUser().getId());
        userService.editProfile(userDTO);
        return "redirect:/user";
    }


//    @RequestMapping(path = "/removeUser", method = RequestMethod.GET)
//    public String deleteUser(@AuthenticationPrincipal CurrentUser customUser) {
//        User entityUser = customUser.getUser();
//        userService.removeUser(entityUser.getId());
//        return "redirect:/index";
//    }
}


