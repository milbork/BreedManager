package com.breedmanager.controllers;

import com.breedmanager.DTO.UserDTO;
import com.breedmanager.data.CurrentUser;
import com.breedmanager.entitis.User;
import com.breedmanager.interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class UserController {

    private UserInterface userInterface;

    @Autowired
    public UserController(UserInterface userInterface) {
        this.userInterface = userInterface;
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

        if (result.hasErrors() || userInterface.checkIfUserAlreadyExist(userDTO)) {
            return "user/addUser";
        }

        userInterface.createUser(userDTO);
        return "redirect:/login";
    }

    // DISPLAY USER

    @GetMapping(path = "/user")
    public String showUserPanel(HttpServletRequest request, HttpServletResponse response,
                                Model model, @AuthenticationPrincipal CurrentUser customUser) {

        Cookie cookie = new Cookie("name", customUser.getUser().getFirstName());
        response.addCookie(cookie);

        model.addAttribute("username", customUser.getUser().getFirstName());
        model.addAttribute("function", customUser.getUser().getFunction());

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

        if (result.hasErrors() ||
                userInterface.checkIfEmailIsAlreadyUsed(customUser.getUser().getEmail(), userDTO)) {
            return "user/editUser";
        }
        userDTO.setId(customUser.getUser().getId());
        userInterface.editProfile(userDTO);
        return "redirect:/user";
    }


//    @RequestMapping(path = "/removeUser", method = RequestMethod.GET)
//    public String deleteUser(@AuthenticationPrincipal CurrentUser customUser) {
//        User entityUser = customUser.getUser();
//        userInterface.removeUser(entityUser.getId());
//        return "redirect:/index";
//    }
}


