package com.breedmanager.controllers;

import com.breedmanager.DTO.LitterDTO;
import com.breedmanager.data.CurrentUser;
import com.breedmanager.interfaces.LitterInterface;
import com.breedmanager.services.LitterService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/user/litter")
public class LitterController {

    private LitterInterface litterInterface;

    @Autowired
    public LitterController(LitterService litterInterface) {
        this.litterInterface = litterInterface;
    }

    @RequestMapping(path = {"/add"}, method = RequestMethod.GET)
    public String allLitter(Model model) {
        model.addAttribute("litter", new LitterDTO());
        return "litter/addLitter";
    }

    @RequestMapping(path = {"/add"}, method = RequestMethod.POST)
    public String addLitter(@ModelAttribute("litter") LitterDTO litterDTO,
                            BindingResult result,
                            @AuthenticationPrincipal CurrentUser customUser) {

        if (result.hasErrors()) {
            return "/add";
        }

        litterDTO.setBreeding(customUser.getUser().getBreeding());
        System.out.println(litterDTO.getBreeding());
        litterInterface.createLitter(litterDTO);
        return "redirect:/user";
    }

    @RequestMapping(path = {"/show"}, method = RequestMethod.GET)
    public String showLitter(Model model, @AuthenticationPrincipal CurrentUser customUser) {
        model.addAttribute("litter", litterInterface.getLitters(customUser.getUser().getBreeding().getName()));
        return "litter/litters";
    }

    @RequestMapping(path = {"/edit/{id}"}, method = RequestMethod.GET)
    public String editLitter(Model model, @PathVariable Long id) {
        model.addAttribute("litter", new LitterDTO());
        return "litter/editLitter";
    }

    @RequestMapping(path = {"/edit/{id}"}, method = RequestMethod.POST)
    public String editLitter(@ModelAttribute("litter") @Valid LitterDTO litterDTO, BindingResult result,
                             @PathVariable Long id,
                             @AuthenticationPrincipal CurrentUser customUser) {

        if (result.hasErrors()) {
            return "/edit/{id}";
        }
        litterDTO.setId(id);
        litterDTO.setBreeding(customUser.getUser().getBreeding());
        litterInterface.updateLitter(litterDTO);
        return "redirect:/user";
    }

    @RequestMapping(path = "/remove/{id}", method = RequestMethod.GET)
    public String removeLitter(@PathVariable Long id) {
        litterInterface.deleteLitter(id);
        return "redirect:/user";
    }
}

