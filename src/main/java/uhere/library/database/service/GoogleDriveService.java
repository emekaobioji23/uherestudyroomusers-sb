/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uhere.library.database.service;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.FileList;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.core.io.ClassPathResource;
/**
 * This class is a simple Java Class registered as a service. It exposes methods
 * to file access with a google drive account.
 * @author emeka
 */
@Service
public class GoogleDriveService {
    private static final String APPLICATION_NAME = "Spring Boot Google Drive";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String CREDENTIALS_FILE_PATH = "service-account-key.json";

    private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE_READONLY);

    private final Drive drive;
    private final CloudinaryService cloudinaryService;
/**
 * This method is the constructor of the class. 
 * It creates an instance of a connection to a google drive account.
 * @param cloudinaryService is reference to a CloudinaryService class instance
 * provided by the underlying container.
 * @throws Exception to capture any kind of Exception because it is a very
 * complex connection using Google generated credentials
 * @throws GeneralSecurityException if the credentials are incorrect
 * @throws IOException if there are I/O errors
 */
    public GoogleDriveService(CloudinaryService cloudinaryService) throws Exception, GeneralSecurityException, IOException {
        System.out.println("GoogleDriveService constructor: begins");
        this.drive = initializeDrive();
        System.out.println("this.drive is "+this.drive.toString());
        //listFiles();
        this.cloudinaryService = cloudinaryService;
        System.out.println("GoogleDriveService constructor: ends");
    }
/**
 * This method is the retrieves the google credential details from the credential
 * file service-account-key.json in the resources folder of the application folder.
 * of the class. 
 * It creates an instance of a connection to a google drive account.
 * @return a HttpCredentialsAdapater instance
 * @throws IOException if there are I/O errors
 */
    private HttpCredentialsAdapter getCredentials() throws IOException {
        try (InputStream in = new ClassPathResource(CREDENTIALS_FILE_PATH).getInputStream()) {
            GoogleCredentials credentials = GoogleCredentials.fromStream(in)
                    .createScoped(SCOPES);

            return new HttpCredentialsAdapter(credentials);
        }
    }
/**
 * This method creates a connection to a google drive and returns the connection
 * as a Drive object. 
 * @return a Drive instance
 * @throws GeneralSecurityException if the credentials are incorrect
 * @throws IOException if there are I/O errors
 */
    private Drive getDriveService() throws GeneralSecurityException, IOException {
        final HttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        return new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials())
                .setApplicationName(APPLICATION_NAME)
                .build();
    }
/**
 * This method creates a connection to a google drive and returns the connection
 * as a Drive object. 
 * @return a Drive instance
 * @throws Exception if anything goes wrong
 */    
    private Drive initializeDrive() throws Exception {
        System.out.println("GoogleDriveService initializeDrive: begins");
        InputStream in = new ClassPathResource(CREDENTIALS_FILE_PATH).getInputStream();
        GoogleCredentials credentials = GoogleCredentials.fromStream(in)
                .createScoped(Collections.singletonList("https://www.googleapis.com/auth/drive"));
        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        System.out.println("GoogleDriveService initializeDrive: ends");
        return new Drive.Builder(httpTransport, JSON_FACTORY, new HttpCredentialsAdapter(credentials))
                .setApplicationName(APPLICATION_NAME)
                .build();
    }
/**
 * This method extracts a google drive file ID from a URL.
 * @param url the URL from which to extract the file ID
 * @return a the file ID as string
 */
    public String extractDriveFileId(String url) {
        if (url == null || url.isEmpty()) {
            return null;
        }

        // Match ID from common Google Drive URL patterns
        Pattern pattern = Pattern.compile("(?<=/d/|id=|folders/)([a-zA-Z0-9_-]+)");
        Matcher matcher = pattern.matcher(url);

        if (matcher.find()) {
            return matcher.group(1);
        }

        // If not a URL, assume it's a raw ID
        return url.matches("[a-zA-Z0-9_-]{10,}") ? url : null;
    }
/**
 * This method lists the content of a google drive connection. The Drive instance
 * is a private member of the GoogleDriveService class initialized by other methods.
 * @throws Exception if anything goes wrong
 */  
    public void listFiles() throws Exception {
        System.out.println("GoogleDriveService listFiles: begins");
        String pageToken = null;
        int count = 0;
        do {
            FileList result = drive.files().list()
                .setPageSize(100)
                .setFields("nextPageToken, files(id, name)")
                .setPageToken(pageToken)
                .execute();

        for (com.google.api.services.drive.model.File file : result.getFiles()) {
            System.out.printf(++count+" Found file: %s (%s)\n", file.getName(), file.getId());
        }

        pageToken = result.getNextPageToken();
    } while (pageToken != null);
        System.out.println("GoogleDriveService listFiles: ends");
    }
/**
 * This method downloads a file from a Drive instance, converts the file into
 * a HttpResponse object, and uploads the file to a Cloudinary account through
 * a CloudinaryService that exposes the methods.
 * @param fileId the google drive file ID
 * @throws IOException if there happens I/O error
 */  
    public void downloadAndUploadToCloudinary(String fileId) throws IOException {
        HttpResponse response = drive.files().get(fileId).executeMedia();
        System.out.println(response.getContent().toString());
        try{
            cloudinaryService.uploadToCloudinary(fileId, response);        
        } catch (IOException e) {
            throw new IOException("GoogleDriveService:downloadAndUploadToCloudinary "+e.getLocalizedMessage(), e);
        }
    }
}
