/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uhere.library.database.service;
 
import java.io.IOException;
import org.springframework.stereotype.Service;
import java.util.List;
import uhere.library.database.model.User;
/**
 * This class is a simple Java Class registered as a service. It exposes methods
 * to enable processing of User entities
 * @author emeka
 */
@Service
public class UserProcessingService {

    private final UserService userService;
    private final CloudinaryService cloudinaryService;
    private final GoogleDriveService googleDriveService;
/**
 * This method is the constructor of the class. 
 * It creates an instance of a UserProcessingService.
 * @param userService is reference to a UserService class instance
 * provided by the underlying container.
 * @param cloudinaryService is reference to a CloudinaryService class instance
 * provided by the underlying container.
 * @param googleDriveService is reference to a GoogleDriveService class instance
 * provided by the underlying container.
 */
    public UserProcessingService(UserService userService, CloudinaryService cloudinaryService, 
            GoogleDriveService googleDriveService) {
        this.userService = userService;
        this.cloudinaryService = cloudinaryService;
        this.googleDriveService = googleDriveService;
    }
/**
 * the method iterates through a list of User entities. For each entity, it 
 * checks if the photograph exists in the Cloudinary, and If it does not, it uploads it.
 * @param users is the list of User entities to check.
 */
    public void processUsersPassportPhotographs(List<User> users) {
        for (User user : users) {
            String googleDriveFileID = googleDriveService.extractDriveFileId(user.getPassportPhotograph());

            // Check if the file already exists in Cloudinary
            if (!cloudinaryService.doesPublicIDExist(googleDriveFileID)) {
                //String fileId = googleDriveService.extractDriveFileId(googleDriveFileID);
                
                if (googleDriveFileID != null) {
                    try {
                        googleDriveService.downloadAndUploadToCloudinary(googleDriveFileID);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } else {
                System.out.println("File already exists in Cloudinary: " + googleDriveFileID);
            }
        }
    }
/**
 * the method iterates through a list of User entities. For each entity, it 
 * extracts the corresponding google file id. It then replaces the entity's 
 * photograph URL with the google file id. 
 * @param users is the list of User entities to check.
 */    
    public void updateImageUrlWithCloudinarys(List<User> users) {
        System.out.println("UserProcessingService:updateImageUrlWithCloudinarys:begin");
        for (User user : users) {
            String googleDriveFileID = googleDriveService.extractDriveFileId(user.getPassportPhotograph());

            // Check if the file already exists in Cloudinary
            //if (cloudinaryService.doesPublicIDExist(googleDriveFileID)) {
                user.setPassportPhotograph(googleDriveFileID);
                userService.save(user);
                //https://res.cloudinary.com/dpkkvko9m/image/upload/googleDriveFileID
                //https://drive.google.com/open?id=googleDriveFileID
                //System.out.println(googleDriveFileID+" "+cloudinaryService.getSecureURL(googleDriveFileID));
            //} else {
                //System.out.println("File does not exists in Cloudinary: " + googleDriveFileID);
            //}
        }
    }
}
