package teamFire.JavaMongUs.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import teamFire.JavaMongUs.models.UserTexts;
import teamFire.JavaMongUs.models.MessageThing;

@Controller
public class MessageController {

    @MessageMapping("/userTexts")
    @SendTo("/game/messages")
    public UserTexts userTexts(MessageThing message) throws Exception{
        return new UserTexts(HtmlUtils.htmlEscape(message.getMessage()));
    }

}
