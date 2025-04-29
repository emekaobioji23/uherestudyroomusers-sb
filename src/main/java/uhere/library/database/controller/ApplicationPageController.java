/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uhere.library.database.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * This class serves as the web application entry point that loads the react
 * front end pages.
 * @author emeka
 */
@Controller
public class ApplicationPageController {
    
/**
 * This method is for redirecting all unknown routes to index.html .
 * @return it index.html
 */    
    @GetMapping("/")
    public String redirect() {
        return "forward:/index.html";
    }
}