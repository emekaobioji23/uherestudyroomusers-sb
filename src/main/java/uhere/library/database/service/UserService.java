/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uhere.library.database.service;

/**
 *
 * @author emeka
 */
import jakarta.transaction.Transactional;
import uhere.library.database.repository.UserRepository;
import uhere.library.database.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    /*@Autowired*/
    private final UserRepository userRepository;
    @Autowired  // This is optional in newer Spring versions but good practice
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }
    @Transactional
    public List<User> getUsersBySurname(String surname) {
        return userRepository.findBySurname(surname);
    }
    public User save(User user) {
        return userRepository.save(user);
    }
    public User createUser(User user) {
        if (userRepository.existsByEmailAddress(user.getEmailAddress())) {
            throw new RuntimeException("User with this email already exists!");
        }
        return userRepository.save(user);
    }
    public User getLatestUser() {
        return userRepository.findFirstByOrderByTimestampDesc();
    }
    @Transactional // Ensures batch insert is handled correctly
    public void saveUsers(List<User> users) {
        userRepository.saveAll(users);
    }
    @Transactional
    public Optional<User> getUserByEmailAddressAndMobilePhoneNumber(String emailAddress,String mobilePhoneNumber) {
        return userRepository.findByEmailAddressAndMobilePhoneNumber(emailAddress, mobilePhoneNumber);
    }
    @Transactional
    public Optional<User> getUserByEmailAddress(String emailAddress) {
        return userRepository.findByEmailAddress(emailAddress);
    }
    @Transactional
    public List<User> getBySurnameIgnoreCaseOrFirstnameIgnoreCaseOrOthernamesIgnoreCase(String firstName, String surname, String otherNames) {
        List<User> users = userRepository.findBySurnameIgnoreCaseOrFirstNameIgnoreCaseOrOtherNamesIgnoreCase(firstName, surname, otherNames);
        return users;
    }
}