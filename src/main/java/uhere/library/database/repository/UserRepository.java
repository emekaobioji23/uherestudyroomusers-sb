/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uhere.library.database.repository;

/**
 *
 * @author emeka
 */
import uhere.library.database.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findBySurname(String surname);// Custom query methods (optional)
    boolean existsByEmailAddress(String emailAddress); // Custom method to check if email exists
    User findFirstByOrderByTimestampDesc(); // Fetches the latest user
    Optional<User> findByEmailAddressAndMobilePhoneNumber(String emailAddress, String mobilePhoneNumber);
    Optional<User> findByEmailAddress(String emailAddress);
    List<User> findBySurnameIgnoreCaseOrFirstNameIgnoreCaseOrOtherNamesIgnoreCase(String firstName, String surname, String otherNames);
}
