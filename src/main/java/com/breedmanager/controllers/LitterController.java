package com.breedmanager.controllers;

import com.breedmanager.services.LitterService;
import org.springframework.stereotype.Controller;

@Controller
public class LitterController {

    private LitterService litterService;

    public LitterController(LitterService litterService) {
        this.litterService = litterService;
    }
}
