package com.breedmanager.controllers;

import com.breedmanager.model.DTO.MessageDTO;
import com.breedmanager.configuration.CurrentUser;
import com.breedmanager.services.message.MessageService;
import com.breedmanager.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private UserService userService;

    @Autowired
    public MessagesController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
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
        messageDTO.setReceiver(userService.getUserById(id));
        messageService.sendMessage(messageDTO);
        return "/user/userPanel";
    }

    @RequestMapping(path = {"/inbox"}, method = RequestMethod.GET)
    public String getMessagesByRecipient(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        model.addAttribute("inbox", messageService.findAllByReceiver(currentUser.getUser()));
        return "user/message/inbox";
    }

    @RequestMapping(path = {"/sent"}, method = RequestMethod.GET)
    public String getMessagesBySender(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        model.addAttribute("sent", messageService.findAllBySender(currentUser.getUser()));
        return "user/message/sent";
    }

}
