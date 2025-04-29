/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uhere.library.database.service;

/**
 *
 * @author emeka
 */
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import org.springframework.core.io.ClassPathResource;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import org.springframework.stereotype.Service;
/**
 * This class is a simple Java Class registered as a service. It exposes methods
 * to access a google sheet file.
 * @author emeka
 */
@Service
public class GoogleSheetsService {
    private static final String APPLICATION_NAME = "Google Sheets API Java";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
/**
 * This is the default constructor
 */   
    public GoogleSheetsService(){
        
    }
/**
 * This method creates a connection to a google sheet and returns the connection
 * as a Sheets object. 
 * @return a Sheets instance
 * @throws GeneralSecurityException if the credentials have errors
 * @throws IOException if there are I/O errors
 */   
    public Sheets getSheetsService() throws GeneralSecurityException, IOException {
        // Load service account JSON from classpath
        InputStream credentialsStream = new ClassPathResource("service-account-key.json").getInputStream();

        GoogleCredentials credentials = GoogleCredentials.fromStream(credentialsStream)
                .createScoped(Collections.singleton(SheetsScopes.SPREADSHEETS_READONLY));

        return new Sheets.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JSON_FACTORY,
                new HttpCredentialsAdapter(credentials))
                .setApplicationName(APPLICATION_NAME)
                .build();
    }
}
