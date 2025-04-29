/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uhere.library.database.service;

/**
 *
 * @author emeka
 */
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.google.api.client.http.HttpResponse;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * This class is a simple Java Class registered as a service. It exposes methods
 * to enable image file upload and access to and from the java Cloudinary API.
 * @author emeka
 */
@Service
public class CloudinaryService {
    
    private final Cloudinary cloudinary;
/**
 * This method is the constructor of the class. 
 * It creates an instance of a Cloudinary object which is basically a connection
 * to a Cloudinary account.It connects to a particular Cloudinary account. The
 * connection details are hard coded.
 */
    public CloudinaryService() {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dpkkvko9m",
            "api_key", "656561112356731",
            "api_secret", "B7eoaWmp9ix9CKwbT4Kqzk_Q6hI"
        ));
    }
/**
 * This method is for checking if a given google drive image file ID exists on
 * a Cloudinary account.
 * @param googleDriveFileID is an instance of a String that represents the file.
 * @return it returns the {@code true if found or false}
 */   
    public boolean doesPublicIDExist(String googleDriveFileID) {
        try {
            Map result = cloudinary.api().resource(googleDriveFileID, ObjectUtils.emptyMap());
            return result != null;
        } catch (Exception e) {
            return false; // URL does not exist
        }
    }
/**
 * This method is for uploading an file read read directly from google drive 
 * into a HttpResponse object to Cloudinary and rename it.
 * @param fileId is a string instance of the file ID
 * @param response is a HttpResponse instance.
 * @throws IOException if the fileId is null
 */ 
    public void uploadToCloudinary(String fileId, HttpResponse response) throws IOException {
        try (InputStream inputStream = response.getContent()/*;
            ByteArrayOutputStream buffer = new ByteArrayOutputStream()*/) {
            /*byte[] temp = new byte[8192];
            int bytesRead;
            while ((bytesRead = inputStream.read(temp)) != -1) {
                buffer.write(temp, 0, bytesRead);
            }

            byte[] fileBytes = buffer.toByteArray();

            cloudinary.uploader().upload(
                fileBytes,
                ObjectUtils.asMap(
                    "public_id", fileId,
                    "resource_type", "auto"
                )
            );*/
            cloudinary.uploader().uploadLarge(
                inputStream,
                ObjectUtils.asMap(
                    "public_id", fileId,
                    "resource_type", "auto"
                )
            );

        } catch (IOException e) {
            throw new IOException("CloudinaryService:uploadToCloudinary: "+e.getLocalizedMessage(), e);
        }
    }
/**
 * This method is returns the secure URL from Cloudinary if given the file ID
 * @param googleDriveFileID is an instance of a String that represents the file.
 * @return it returns the {@code secure url of the file from cloudinary as string}
 */    public String getSecureURL(String googleDriveFileID) {
        try {
            String secureUrl = cloudinary.url().secure(true) // ensure HTTPS
                    .generate(googleDriveFileID);
            return secureUrl;
        } catch (Exception e) {
            System.err.println("CloudinaryService:getSecureURL "+e.getMessage());
            throw e;
        }
    }
}
