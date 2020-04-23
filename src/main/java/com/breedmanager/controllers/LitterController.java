package com.breedmanager.controllers;

import com.breedmanager.model.DTO.LitterDTO;
import com.breedmanager.configuration.CurrentUser;
import com.breedmanager.services.litter.LitterService;
import com.breedmanager.services.litter.LitterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user/litter")
public class LitterController {

    private LitterService litterService;

    @Autowired
    public LitterController(LitterServiceImpl litterInterface) {
        this.litterService = litterInterface;
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
        litterService.createLitter(litterDTO);
        return "redirect:/user";
    }

    @RequestMapping(path = {"/show"}, method = RequestMethod.GET)
    public String showLitter(Model model, @AuthenticationPrincipal CurrentUser customUser) {
        model.addAttribute("litter", litterService.getLitters(customUser.getUser().getBreeding().getName()));
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
        litterService.updateLitter(litterDTO);
        return "redirect:/user";
    }

    @RequestMapping(path = "/remove/{id}", method = RequestMethod.GET)
    public String removeLitter(@PathVariable Long id) {
        litterService.deleteLitter(id);
        return "redirect:/user";
    }
}

