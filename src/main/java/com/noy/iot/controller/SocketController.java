package com.noy.iot.controller;

import com.noy.iot.websocket.model.InputData;
import com.noy.iot.websocket.model.OutputData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class SocketController {

    private SimpMessagingTemplate template;

    @Autowired
    public SocketController(SimpMessagingTemplate template) {
        this.template = template;
    }


    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputData send(final InputData message) throws Exception {

        final String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputData(message.getFrom(), message.getText(), time);
    }

    @GetMapping("/send")
    @ResponseBody
    public String send(){
      this.template.convertAndSend("/topic/messages", new OutputData("jdgfh","jshdfkjh","tomedhfkdj"));
        return "ok";
    }
}
