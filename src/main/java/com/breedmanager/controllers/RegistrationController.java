package com.breedmanager.controllers;

import com.breedmanager.DTO.UserDTO;
import com.breedmanager.entitis.User;
import com.breedmanager.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @RequestMapping(path = {"/home"}, method = RequestMethod.GET)
    public  String viewHome(){
        return "index";
    }

    @RequestMapping(path = {"/user"}, method = RequestMethod.GET)
    public String addUser(Model model) {
        model.addAttribute("user", new UserDTO());
        return "addUser";
    }

    @RequestMapping(path = {"/user"}, method = RequestMethod.POST)
    public String registerUserAccount(@ModelAttribute("user") @Valid UserDTO userDTO,
                                      BindingResult result) {
        User existing = registrationService.findUserByEmail(userDTO.getEmail());

        if (result.hasErrors()) {
            return "403";
        }

        registrationService.addUser(userDTO);
        return "redirect:/registration/home";
    }

}
