/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uhere.library.database.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import uhere.library.database.model.User;
import uhere.library.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import uhere.library.database.service.UserProcessingService;
import uhere.library.database.service.UserComparisonService;
/**
 * This class serves as the backend application entry point where the endpoint
 * URLs are specified.When the developer conceives a service that it wants 
 * rendered, it comes to this class and defines the endpoint and the method that
 * would invoke the service. Usually, the service is wrapped as a method of
 * another class defined as a service with the @Service generics.
 * @author emeka
 */
@RestController
@RequestMapping("/api")
public class ApplicationAPIController {
    /*@Autowired
    private UserRepository userRepository;*/
    private final UserService userService;
    private final UserComparisonService userComparisonService;
    private final UserProcessingService userProcessingService;
/**
 * This method is the constructor of the class, it accept 3 services
 * xxxService. A service is a class annotated with @Service. @Service classes 
 * are used to encapsulate complex routines that can be exposed as endpoints.
 * The container/app server that hosts the spring-boot application is responsible
 * for instantiating the @Service classes.
 * @param userService is an instance of the UserService class.
 * @param userComparisonService is an instance of the userComparisonService class.
 * @param userProcessingService is an instance of the userProcessingService class.
 */
    @Autowired  // This is optional in newer Spring versions but good practice
    public ApplicationAPIController(UserService userService, 
            UserComparisonService userComparisonService,
            UserProcessingService userProcessingService) {
        this.userService = userService;
        this.userComparisonService = userComparisonService;
        this.userProcessingService = userProcessingService;
    }
/**
 * This method is for retrieving user entities that the searchTerm string from
 * the RequestBody matches any of their surname, firstname or othernames 
 * properties. Before the search, the entities are updated from their corresponding
 * rows in the spreadsheet, new user entities are created from new spreadsheet
 * rows, the photographs of the new entities are uploaded to the image database,
 * and the new user entities are persisted. Then the search is conducted, and the
 * matched entities are returned. This method calls other methods of other classes
 * registered as services.
 * @param searchTerm is an instance of a String that in itself is retrieved from
 * the @RequestBody object.
 * @return it returns the {@code matched users}
 */   
    @GetMapping("/users")
    public List<User> getUsers(@RequestParam String searchTerm) {
        System.out.println("ApplicationController:getUsers:begins");
        System.out.println("searchTerm="+searchTerm);
        try {
           userComparisonService.updateEntities();
           List<User> newUsers = userComparisonService.updateDatabseWithNewUsersInGoogleSheet();
           userProcessingService.processUsersPassportPhotographs(newUsers);
           System.out.println("About to persist new Users");
           userService.saveUsers(newUsers);
           System.out.println("has finished persisting new Users");
           List<User> matchedUsers = userService.getBySurnameIgnoreCaseOrFirstnameIgnoreCaseOrOthernamesIgnoreCase(searchTerm, searchTerm, searchTerm);
           System.out.println("ApplicationController:getUsers:"+searchTerm+" matched users count is "+matchedUsers.size());
           System.out.println("ApplicationController:getUsers:exits");
           return matchedUsers;
           //return userService.findAll();
        }catch(IOException | GeneralSecurityException | ParseException e){
           System.out.println("Error: " + e.getMessage());
           return userService.findAll();
        }
    }
 /**
 * This method is for updating the image URLs of the entities with that of 
 * Cloudinary. It calls a method of another class registered as service.
 */   
    @GetMapping("/users/update-image-url")
    public void updateImageUrl() {
        System.out.println("ApplicationController:updateImageUrl:begins");
        try {
           userProcessingService.updateImageUrlWithCloudinarys(userService.findAll());
        }catch(Exception e){
           System.out.println("Error: " + e.getMessage());
        }
    }
/**
 * This method is for retrieving user entities by their surname property. The
 * value of the surname is specified as a path variable. This method calls other
 * method of another class registered as a service.
 * @param surname is an instance of a String that in itself is retrieved from
 * the @PathVariable object.
 * @return it returns the {@code matched users}
 */      
    @GetMapping("/users/surname/{surname}")
    public List<User> getUsersBySurname(@PathVariable String surname) {
        return userService.getUsersBySurname(surname);
    }
/**
 * This method is for creating a new user entity whose properties are retrieved 
 * from the RequestBody. Typically, a user has filled a form online and submitted
 * and all the properties of the user are held by the RequestBody object from
 * which the container automatically creates a new User entity object.
 * @param user is an instance of the User Entity Enterprise Java Bean class
 * that in itself is retrieved from the @RequestBody object.
 * @return it returns the {@code user} after calling the save method of the
 * UserService @Service class to persist the user in the database via JPA.
 */
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }
}