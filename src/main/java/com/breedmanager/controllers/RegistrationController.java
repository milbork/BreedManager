package com.breedmanager.controllers;

import com.breedmanager.DTO.BreederDTO;
import com.breedmanager.DTO.UserDTO;
import com.breedmanager.entitis.Breeder;
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
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()) {
            return "registration";
        }

        registrationService.addUser(userDTO);
        return "redirect:index";
    }


    @RequestMapping(path = {"/breeder"}, method = RequestMethod.GET)
    public String addBreeder(Model model) {
        model.addAttribute("breeder", new BreederDTO());
        return "addBreeder";
    }

    @RequestMapping(path = {"/breeder"}, method = RequestMethod.POST)
    public String registerBreederAccount(@ModelAttribute("breeder") @Valid BreederDTO breederDTO,
                                      BindingResult result) {

        Breeder existing = registrationService.findBreederByEmail(breederDTO.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()) {
            return "registration";
        }

        registrationService.addBreeder(breederDTO);
        return "redirect:index";
    }
}
