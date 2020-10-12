package teamFire.JavaMongUs.controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import teamFire.JavaMongUs.models.UserTexts;

@Controller
public class MessageController {

    @MessageMapping("/userTexts")
    @SendTo("/game/messages")
    public UserTexts userTexts (Message message) throws Exception{
        return new UserTexts("testing");// TODO: Add userText
    }
}
