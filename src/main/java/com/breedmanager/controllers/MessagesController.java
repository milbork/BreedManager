package com.breedmanager.controllers;

import com.breedmanager.DTO.MessageDTO;
import com.breedmanager.data.CurrentUser;
import com.breedmanager.services.MessageService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = {"/user/message"})
public class MessagesController {

    private MessageService messageService;

    public MessagesController(MessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping(path = {"/send/{id}"}, method = RequestMethod.GET)
    public String sendMessage(Model model, @PathVariable Long id) {
        model.addAttribute("messages", new MessageDTO());

        return "user/message/sendMessages";
    }

    @RequestMapping(path = {"/send/{id}"}, method = RequestMethod.POST)
    public String sendMessage(@ModelAttribute("messages") MessageDTO messageDTO, BindingResult result,
                              @AuthenticationPrincipal CurrentUser currentUser, @PathVariable Long id) {

        if (result.hasErrors()) {
            return "/send";
        }

        messageDTO.setSender(currentUser.getUser());
        messageDTO.setRecipientsID(id);
        messageService.sendMessage(messageDTO);

        return "/user/userPanel";
    }

}
