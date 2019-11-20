package com.breedmanager.controllers;

import com.breedmanager.DTO.MessageDTO;
import com.breedmanager.data.CurrentUser;
import com.breedmanager.interfaces.MessageInterface;
import com.breedmanager.interfaces.UserInterface;
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

    private MessageInterface messageInterface;
    private UserInterface userInterface;

    @Autowired
    public MessagesController(MessageInterface messageInterface, UserInterface userInterface) {
        this.messageInterface = messageInterface;
        this.userInterface = userInterface;
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
        messageDTO.setReceiver(userInterface.getUserById(id));
        messageInterface.sendMessage(messageDTO);
        return "/user/userPanel";
    }

    @RequestMapping(path = {"/inbox"}, method = RequestMethod.GET)
    public String getMessagesByRecipient(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        model.addAttribute("inbox", messageInterface.findAllByReceiver(currentUser.getUser()));
        return "user/message/inbox";
    }

    @RequestMapping(path = {"/sent"}, method = RequestMethod.GET)
    public String getMessagesBySender(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        model.addAttribute("sent", messageInterface.findAllBySender(currentUser.getUser()));
        return "user/message/sent";
    }

}
