/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uhere.library.database.controller;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
/**
 * This class serves as the web application entry point that handles any unspecified URL or unhandled endpoint.
 * @author emeka
 */
@Controller
public class ApplicationErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        // Optional: inspect request attributes or status
        // Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        return "forward:/index.html";
    }
}
