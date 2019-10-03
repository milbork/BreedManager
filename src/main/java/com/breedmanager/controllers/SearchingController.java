package com.breedmanager.controllers;

import com.breedmanager.DTO.BreedingDTO;
import com.breedmanager.services.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SearchingController {


    private SearchService searchService;

    public SearchingController(SearchService searchService) {
        this.searchService = searchService;
    }

    @RequestMapping(path = "/user/search", method = RequestMethod.GET)
    public String findBreeder(Model model) {
        model.addAttribute("search", new BreedingDTO());
        return "user/search/searching";
    }

    @RequestMapping(path = "/user/search", method = RequestMethod.POST)
    public String findBreeder(Model model, @ModelAttribute("search") BreedingDTO searchDTO, BindingResult result) {
        model.addAttribute("search", searchService.searchForBreedings(searchDTO));
        showBreeder(model, searchDTO);
        return "user/search/searchingResults";
    }

    @RequestMapping(path = {"/user/search/results"}, method = RequestMethod.GET)
    public String showBreeder(Model model, BreedingDTO searchDTO) {
        model.addAttribute("find", searchService.searchForBreedings(searchDTO));

        return "user/search/searchingResults";
    }

}

