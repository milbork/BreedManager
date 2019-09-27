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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/user/litter")
public class LitterController {

    private LitterService litterService;

    public LitterController(LitterService litterService) {
        this.litterService = litterService;
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
        User entityUser = customUser.getUser();
        litterDTO.setBreeder(entityUser);
        litterService.createLitter(litterDTO);
        return "redirect:/user";
    }

    @RequestMapping(path = {"/show"}, method = RequestMethod.GET)
    public String showLitter(Model model, @AuthenticationPrincipal CurrentUser customUser) {
        LitterDTO litterDTO = new LitterDTO();
        litterDTO.setId(customUser.getUser().getId());
        model.addAttribute("litter", litterService.readLitter(litterDTO));
        return "litter/litters";
    }

    @RequestMapping(path = {"/edit/{id}"}, method = RequestMethod.GET)
    public String editLitter(Model model, @PathVariable Long id) {
        model.addAttribute("litter", new LitterDTO());
        return "litter/editLitter";
    }

    @RequestMapping(path = {"/edit/{id}"}, method = RequestMethod.POST)
    public String editLitter(@ModelAttribute("litter") @Valid LitterDTO litterDTO,
                             @PathVariable Long id,
                             BindingResult result,
                             @AuthenticationPrincipal CurrentUser customUser) {

        if (result.hasErrors()) {
            return "/edit/{id}";
        }
        User entityUser = customUser.getUser();
        litterDTO.setId(id);
        litterDTO.setBreeder(entityUser);
        litterService.updateLitter(litterDTO);
        return "redirect:/user";
    }

    @RequestMapping(path = "/remove/{id}", method = RequestMethod.GET)
    public String removeLitter(@PathVariable Long id) {
        litterService.deleteLitter(id);
        return "redirect:/user";
    }
}

