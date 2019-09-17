package com.breedmanager.controllers;

import com.breedmanager.DTO.LitterDTO;
import com.breedmanager.data.CurrentUser;
import com.breedmanager.entitis.User;
import com.breedmanager.services.LitterService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class LitterController {

    private LitterService litterService;

    public LitterController(LitterService litterService) {
        this.litterService = litterService;
    }

    @RequestMapping(path = {"/addLitter"}, method = RequestMethod.GET)
    public String allLitter(Model model) {
        model.addAttribute("litter", new LitterDTO());
        return "dog/addLitter";
    }

    @RequestMapping(path = {"/addLitter"}, method = RequestMethod.POST)
    public String addDog(@ModelAttribute("litter") LitterDTO litterDTO,
                         BindingResult result,
                         @AuthenticationPrincipal CurrentUser customUser) {

        if (result.hasErrors()) {
            return "error";
        }
        User entityUser = customUser.getUser();
        litterDTO.setBreeder(entityUser);
        litterService.createLitter(litterDTO);
        return "redirect:/user";
    }
}
