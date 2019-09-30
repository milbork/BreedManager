package com.breedmanager.controllers;

import com.breedmanager.DTO.SearchDTO;
import com.breedmanager.services.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SearchController {

    private SearchService searchService;


    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @RequestMapping(path = "/user/search", method = RequestMethod.POST)
        public String findBreeder(Model model){
        model.addAttribute("search", new SearchDTO());
        return "user/search";
    }
    @RequestMapping(path = "/user/search", method = RequestMethod.POST)
    public String findBreeder(Model model, @ModelAttribute("search")  SearchDTO searchDTO){
        model.addAttribute("find", searchService.searchForBreedings(searchDTO));

        return "user/search";
    }




}
