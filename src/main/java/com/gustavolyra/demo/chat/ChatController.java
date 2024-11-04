package com.gustavolyra.demo.chat;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@RequestBody ChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")

    public ChatMessage addUser(@RequestBody ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        // add username to websocket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

}
