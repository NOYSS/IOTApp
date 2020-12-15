package com.noy.iot.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorsController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model ui) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        ui.addAttribute("status",statusCode.toString());
        ui.addAttribute("message",exception==null? "N/A": exception.getMessage());
        return "error-404";
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
