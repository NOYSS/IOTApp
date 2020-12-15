package com.noy.iot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class MainController {

    private static Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @GetMapping
    public String main(HttpServletRequest request, ModelMap model) {
        LOGGER.info("main");
        return "main";
    }
}
