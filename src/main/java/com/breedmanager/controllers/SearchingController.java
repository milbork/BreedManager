package com.breedmanager.controllers;

import com.breedmanager.model.DTO.BreedingDTO;
import com.breedmanager.services.search.SearchServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SearchingController {


    private SearchServiceImpl searchServiceImpl;

    public SearchingController(SearchServiceImpl searchServiceImpl) {
        this.searchServiceImpl = searchServiceImpl;
    }

    @RequestMapping(path = "/user/search", method = RequestMethod.GET)
    public String findBreeder(Model model) {
        model.addAttribute("search", new BreedingDTO());
        return "user/search/searching";
    }

    @RequestMapping(path = "/user/search", method = RequestMethod.POST)
    public String findBreeder(Model model, @ModelAttribute("search") BreedingDTO searchDTO, BindingResult result) {
        model.addAttribute("search", searchServiceImpl.searchForBreedings(searchDTO));
        showBreeder(model, searchDTO);
        return "user/search/searchingResults";
    }

    @RequestMapping(path = {"/user/search/results"}, method = RequestMethod.GET)
    public String showBreeder(Model model, BreedingDTO searchDTO) {
        model.addAttribute("find", searchServiceImpl.searchForBreedings(searchDTO));

        return "user/search/searchingResults";
    }

}

