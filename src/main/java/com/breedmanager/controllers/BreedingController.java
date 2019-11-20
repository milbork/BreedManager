package com.breedmanager.controllers;

import com.breedmanager.DTO.BreedingDTO;
import com.breedmanager.data.CurrentUser;
import com.breedmanager.interfaces.BreedingInterface;
import com.breedmanager.services.BreedingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/user/breeding")
public class BreedingController {

    private BreedingInterface breedingInterface;

    @Autowired
    public BreedingController(BreedingInterface breedingInterface) {
        this.breedingInterface = breedingInterface;
    }


    @RequestMapping(path = {"/add"}, method = RequestMethod.GET)
    public String addBreed(Model model) {
        model.addAttribute("breeding", new BreedingDTO());
        return "breeding/addBreeding";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String addBreed(@ModelAttribute("breeding") @Valid BreedingDTO breedingDTO, BindingResult result, @AuthenticationPrincipal CurrentUser currentUser) {

        if (result.hasErrors()) {
            return "breeding/addBreeding";
        }

        if (breedingInterface.findBreedingByBreeder(currentUser.getUser()) != null) {
            return "user/userPanel";
        }

        breedingDTO.setBreeder(currentUser.getUser());
        breedingInterface.addBreeding(breedingDTO);

        return "user/userPanel";
    }

    @RequestMapping(path = {"/show"}, method = RequestMethod.GET)
    public String showBreeding(Model model, @AuthenticationPrincipal CurrentUser customUser) {
        model.addAttribute("breeding", breedingInterface.findBreedingByBreeder(customUser.getUser()));
        return "breeding/showBreeding";
    }

    @RequestMapping(path = {"/edit"}, method = RequestMethod.GET)
    public String editBreeding(Model model) {
        model.addAttribute("breeding", new BreedingDTO());
        return "breeding/editBreeding";
    }

    @RequestMapping(path = {"/edit"}, method = RequestMethod.POST)
    public String editBreeding(@ModelAttribute("breeding") @Valid BreedingDTO breedingDTO,
                               BindingResult result,
                               @AuthenticationPrincipal CurrentUser customUser) {

        if (result.hasErrors()) {
            return "/edit";
        }

        breedingDTO.setId(customUser.getUser().getBreeding().getId());
        breedingDTO.setBreeder(customUser.getUser());
        breedingInterface.editBreeding(breedingDTO);

        return "redirect:/user";
    }

    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String deleteBreeding(@AuthenticationPrincipal CurrentUser currentUser) {
        breedingInterface.deleteBreeding(currentUser.getUser().getId());
        return "breeding/show";
    }

}
