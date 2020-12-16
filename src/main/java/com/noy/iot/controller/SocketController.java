package com.noy.iot.controller;

import com.noy.iot.websocket.model.InputData;
import com.noy.iot.websocket.model.OutputData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
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
        return new OutputData(message.getCelsiusTemp(), message.getHumidityTemp(), time);
    }

    @GetMapping("/send")
    @ResponseBody
    public String send(){
      this.template.convertAndSend("/topic/messages", new OutputData(0,0,"12/12/2020"));
        return "ok";
    }

    @PostMapping("/dataSensor")
    public String dataSensor(@RequestBody String dataJson){
        JSONObject jsonObject = new JSONObject(dataJson);
        double celsiusTemp = jsonObject.optDouble("celsiusTemp", 0);
        double humidityTemp = jsonObject.optDouble("humidityTemp", 0);
        final String time = new SimpleDateFormat("HH:mm").format(new Date());
        this.template.convertAndSend("/topic/messages", new OutputData(celsiusTemp,humidityTemp,time));
        return "OK";
    }
}
