/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uhere.library.database.service;

import com.google.api.services.sheets.v4.model.ValueRange;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uhere.library.database.model.User;

/**
 * This class provides methods for spotting out differences between the rows of
 * of the spreadsheet file and the entities from the database rows. In the case
 * of modified spreadsheet rows, it has methods for updating the corresponding 
 * entities, and in the case of new rows, it creates new entities.
 * @author emeka
 */
@Service
public class UserComparisonService {
    private final UserService userService; // Inject UserService to get users from DB
    private final GoogleDriveService googleDriveService;
    private final CloudinaryService cloudinaryService;
    @Autowired 
    private final GoogleSheetsService googleSheetsService; // Inject Google Sheets API service
    private static final String SPREADSHEET_ID = "1FARXSJQXvgztzKQAIl9dIIrIXWPTrKbpuWrbzCjyRjE";
    private static final String SHEET_NAME = "Form responses 5"; // Change to your sheet name
    
/**
 * This method is the constructor of the class. 
 * It creates an instance of a UserComparisonSerivce.
 * @param userService is reference to a UserService class instance
 * provided by the underlying container.
 * @param googleSheetsService is reference to a GoogleSheetsService class instance
 * provided by the underlying container.
 * @param googleDriveService is reference to a GoogleDriveService class instance
 * provided by the underlying container.
 * @param cloudinaryService is reference to a CloudinaryService class instance
 * provided by the underlying container.
 */
    @Autowired 
    public UserComparisonService(UserService userService, 
            GoogleSheetsService googleSheetsService,
            GoogleDriveService googleDriveService, CloudinaryService cloudinaryService) {
        this.userService = userService;
        this.googleSheetsService = googleSheetsService;
        this.googleDriveService = googleDriveService;
        this.cloudinaryService = cloudinaryService;
    }
/**
 * This method updates the entity table with new entries in the google sheet.
 * it first gets the latest entity based on timestamp, and with that it selects
 * the newly added rows in the google sheet.
 * @return the new rows as a list of User entities
 * @throws GeneralSecurityException if the credentials have errors
 * @throws IOException if there are I/O errors
 * @throws ParseException
 */       
    public List<User> updateDatabseWithNewUsersInGoogleSheet() throws IOException,GeneralSecurityException, ParseException {
        System.out.println("UserComparisonService:updateDatabseWithNewUsersInGoogleSheet:begins");
        List<String> emailsInDB = userService.findAll().stream().map(User::getEmailAddress).collect(Collectors.toList());      
        // Fetch users from Google Sheets after succeeding latest user in database
        List<User> newUsers = addNewUsersFromGoogleSheetToDB(emailsInDB);
        System.out.println("UserComparisonService:updateDatabseWithNewUsersInGoogleSheet:ends");
        return newUsers;
        //userService.saveUsers(newUsers);
    }
/**
 * This method adds rows from the google sheet created after the latest User entity
 * into the entity database. It creates a connection to the google sheet, 
 * retrieves all the rows, and as long as the rows are not empty, for each row,
 * as long as the cells are not empty, it checks if the timestamp and email are 
 * in order, if so, then it converts the row to a User entity and adds it to a User list.
 * @return the new rows as a list of User entities
 * @throws GeneralSecurityException if the credentials have errors
 * @throws IOException if there are I/O errors
 * @throws ParseException
 */      
    private List<User> addNewUsersFromGoogleSheetToDB(List<String> emailsInDB) throws IOException, GeneralSecurityException, ParseException {
        System.out.println("UserComparisonService:addUsersFromGoogleSheetToDBAfterTimeStamp:begins");
        User user;
        List<User>  users = new ArrayList<>();

        // Define range (Example: "Users!A:C" for emails, names, and roles)
        String range = SHEET_NAME;

        ValueRange response = googleSheetsService.getSheetsService().spreadsheets().values().get(SPREADSHEET_ID, range).execute();

        List<List<Object>> values = response.getValues();
        if (values == null || values.isEmpty()) {
            System.out.println("No data found.");
            return users;
        }
        
        // skip the first row (usually header)
        values = values.stream().skip(1).collect(Collectors.toList());
        
        System.out.println("Before filtering by emails in DB, the spreadsheet contains "+values.size()+" users");
        values = filterByEmails(values, emailsInDB);
        System.out.println("After filtering by emails in DB, the spreadsheet contains "+values.size()+" users");
        Timestamp timestamp;
        String emailAddress, passportPhotograph, surname, firstName, otherNames, mobilePhoneNumber, dateOfBirth, religion, hostelAddress, homeAddress, department, secondarySchoolAttended, level, oLevelResults, postUmeScore, cgpaAtTheEndOfSession, howDidYouGetToKnowTheCentre, whyChooseToStudyAtUhereStudyRoom, organizationsYouBelongTo, hobbies, introducedToUhereStudyCentreBy, areUInterestedInContSpiritDoctMoralDev, interviewed, interviewer, accepted, cummPaid, dateOfPreviousDeposit, dateOfNextPayment, comment, paymentMode, probablyInNsukka;  
        for (List<Object> row : values) {
            if (!row.isEmpty() && row.size() > 1) { // Ensure row has enough data
                //row = escapeSpecialCharacters(row);
                timestamp = !row.isEmpty() ? convertStringToTimestamp(row.get(0).toString().trim()) : null; // Timestamp in column A
                emailAddress = row.size() > 1 ? row.get(1).toString().trim() : ""; // Email in column B  
                if(isValidEmailAddress(emailAddress)==true){
                    passportPhotograph = row.size() > 2 ? row.get(2).toString().trim() : ""; // GoogleDrive Passport Photograph URL in column C 
                    passportPhotograph = googleDriveService.extractDriveFileId(passportPhotograph);
                    surname = row.size() > 3 ? row.get(3).toString().trim() : ""; // Surname in column D  
                    firstName = row.size() > 4 ? row.get(4).toString().trim() : ""; // First name in column E  
                    otherNames = row.size() > 5 ? row.get(5).toString().trim() : ""; // Other names in column F  
                    mobilePhoneNumber = row.size() > 6 ? row.get(6).toString().trim() : ""; // Mobile number in column G  
                    dateOfBirth = row.size() > 7 ? row.get(7).toString().trim() : ""; // Date of birth in column H  
                    religion = row.size() > 8 ? row.get(8).toString().trim() : ""; // Religion in column I  
                    hostelAddress = row.size() > 9 ? row.get(9).toString().trim(): ""; // Hostel address in column J  
                    homeAddress = row.size() > 10 ? row.get(10).toString().trim() : ""; // Home address in column K  
                    department = row.size() > 11 ? row.get(11).toString().trim() : ""; // Department in column L  
                    secondarySchoolAttended = row.size() > 12 ? row.get(12).toString().trim() : ""; // Secondary school in column M  
                    level = row.size() > 13 ? row.get(13).toString().trim() : ""; // Level in column N  
                    oLevelResults = row.size() > 14 ? row.get(14).toString().trim() : ""; // O-Level results in column O 
                    postUmeScore = row.size() > 15 ? row.get(15).toString().trim() : ""; // Post UME score in column P  
                    cgpaAtTheEndOfSession = row.size() > 16 ? row.get(16).toString().trim() : ""; // CGPA in column Q  
                    howDidYouGetToKnowTheCentre = row.size() > 17 ? row.get(17).toString().trim() : ""; // Referral source in column R  
                    whyChooseToStudyAtUhereStudyRoom = row.size() > 18 ? row.get(18).toString().trim() : ""; // Study choice in column S  
                    organizationsYouBelongTo = row.size() > 19 ? row.get(19).toString().trim() : ""; // Organizations in column T  
                    hobbies = row.size() > 20 ? row.get(20).toString().trim() : ""; // Hobbies in column U  
                    introducedToUhereStudyCentreBy = row.size() > 21 ? row.get(21).toString().trim() : ""; // Introduced by in column V  
                    areUInterestedInContSpiritDoctMoralDev = row.size() > 22 ? row.get(22).toString().trim() : ""; // Interest in development in column W  
                    interviewed = row.size() > 23 ? row.get(23).toString().trim() : ""; // Interviewed in column X  
                    interviewer = row.size() > 24 ? row.get(24).toString().trim() : ""; // Interviewer in column Y  
                    accepted = row.size() > 25 ? row.get(25).toString().trim() : ""; // Accepted in column Z  
                    cummPaid = row.size() > 26 ? row.get(26).toString().trim() : ""; // Cumulative payment in column AA  
                    dateOfPreviousDeposit = row.size() > 27 ? row.get(27).toString().trim() : ""; // Previous deposit date in column AB  
                    dateOfNextPayment = row.size() > 28 ? row.get(28).toString().trim() : ""; // Next payment date in column AC  
                    comment = row.size() > 29 ? row.get(29).toString().trim() : ""; // Comment in column AD  
                    paymentMode = row.size() > 30 ? row.get(30).toString().trim() : ""; // Payment mode in column AE  
                    probablyInNsukka = row.size() > 31 ? row.get(31).toString().trim() : ""; // Probably in Nsukka in column AF
                    //System.out.println("about add user to users "+row);
                    user=new User(
                        timestamp,
                        emailAddress,
                        passportPhotograph,
                        surname,
                        firstName,
                        otherNames,
                        mobilePhoneNumber,
                        dateOfBirth,
                        religion,
                        hostelAddress,
                        homeAddress,
                        department,
                        secondarySchoolAttended,
                        level,
                        oLevelResults,
                        postUmeScore,
                        cgpaAtTheEndOfSession,
                        howDidYouGetToKnowTheCentre,
                        whyChooseToStudyAtUhereStudyRoom,
                        organizationsYouBelongTo,
                        hobbies,
                        introducedToUhereStudyCentreBy,
                        areUInterestedInContSpiritDoctMoralDev,
                        interviewed,
                        interviewer,
                        accepted,
                        cummPaid,
                        dateOfPreviousDeposit,
                        dateOfNextPayment,
                        comment,
                        paymentMode,
                        probablyInNsukka
                    );
                    users.add(user);
                    //System.out.println("finished adding user to users "+users.size());
                    //create user here
                }else{
                    System.out.println(emailAddress+" is invalid email address");
                }
            }
        }
        System.out.println("New users from sheet = " + users.size());
        System.out.println("UserComparisonService:addUsersFromGoogleSheetToDBAfterTimeStamp:ends");
        return users;
    }
/**
 * This method checks whether a given email string is valid.
 * @param email, the email string to validate.
 * @return true if valid else false
 */      // Method to check if the email is valid
    private boolean isValidEmailAddress(String email) {
      
        // Regular expression to match valid email formats
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    
        // Compile the regex
        Pattern p = Pattern.compile(emailRegex);
      
        // Check if email matches the pattern
        return email != null && p.matcher(email).matches();
    }
/**
 * This method converts a date in string form into a Timestamp object.
 * @param dateString is the date in string to convert into Timestamp
 * @return the Timestamp object
 * @throws ParseException
 */  
    private Timestamp convertStringToTimestamp(String dateString) throws ParseException {
        // Choose the correct date format
        SimpleDateFormat dateFormat;
        if (dateString.length() > 10) { // If the string includes time
            dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        } else { // If the string contains only the date
            dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        }

        // Parse the string to a Date object
        Date parsedDate = dateFormat.parse(dateString);

        // Convert to Timestamp
        return new Timestamp(parsedDate.getTime());
    }

/**
 * This method returns the rows of a table which has email cell containing
 * a an email in the list of emails input.
 * @param values is the table as a list of list of objects
 * @param emails is the list of emails
 * @return a subset of the table with selected rows as String
 */    
    private List<List<Object>> filterByEmails(List<List<Object>> values, List<String> emails) {
        List<String> normalizedEmails = emails.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        return values.stream()
                /*.map(row -> row.stream()
                        .map(cell -> cell != null ? cell.trim() : "")
                        .collect(Collectors.toList())
                )*/
                .filter(row -> row.size() > 1 &&
                        !normalizedEmails.contains(row.get(1).toString().trim().toLowerCase()))
                .collect(Collectors.toList());
    }

/**
 * This method escapes the special characters in the cells of a row
 * @param inputList is the row with some or all cells containing special characters
 * @return the row with all special characters escaped
 */ 
    private List<Object> escapeSpecialCharacters(List<Object> inputList) {
        return inputList.stream()
            .map(obj -> {
                String str = obj.toString();
                return str
                    .replace("\\", "\\\\")  // Escape backslashes first
                    .replace(",", "\\,")    // Escape commas
                    .replace("\n", "\\n")   // Escape newlines
                    .replace("\r", "\\r")   // Escape carriage returns
                    .replace("\t", "\\t")   // Escape tabs
                    .replace("\"", "\\\""); // Escape double quotes (optional)
            })
            .collect(Collectors.toList());
    }

/**
 * @throws IOException if there are I/O errors
 * @throws GeneralSecurityException if there are credential errors with connecting to the google sheet
 * the method reads a google sheet, and if not empty, for each row on
 * the sheet, find the corresponding entity using email and mobile, then if
 * entity is found,it updates the following properties - cummPaid, 
 * dateOfPreviousDeposit, dateOfNextPayment, paymentMode - with the values
 * in the spreadsheet.
 */
    public void updateEntities() throws IOException, GeneralSecurityException{
        System.out.println("UserComparisonService:updateEntities:Entry");
        // Define range (Example: "Users!A:C" for emails, names, and roles)
        String range = SHEET_NAME;

        ValueRange response = googleSheetsService.getSheetsService()
                .spreadsheets()
                .values()
                .get(SPREADSHEET_ID, range)
                .execute();

        List<List<Object>> values = response.getValues();
        if (values == null || values.isEmpty()) {
            System.out.println("No data found.");
        }else{
            //System.out.println("values.size()="+values.size());
            String emailAddress,mobilePhoneNumber, cummPaid, dateOfPreviousDeposit, dateOfNextPayment, paymentMode;  
            Optional<User> aUser;
            for (List<Object> row : values) {
                if (!row.isEmpty() && row.size() > 1) { // Ensure row has enough data
                    //row = escapeSpecialCharacters(row);
                    emailAddress = row.size() > 1 ? row.get(1).toString().trim() : ""; // Email in column B  
                    mobilePhoneNumber = row.size() > 6 ? row.get(6).toString().trim() : ""; // Mobile number in column G  
                    cummPaid = row.size() > 26 ? row.get(26).toString().trim() : ""; // Cumulative payment in column AA  
                    dateOfPreviousDeposit = row.size() > 27 ? row.get(27).toString().trim() : ""; // Previous deposit date in column AB  
                    dateOfNextPayment = row.size() > 28 ? row.get(28).toString().trim() : ""; // Next payment date in column AC  
                    paymentMode = row.size() > 30 ? row.get(30).toString().trim() : ""; // Payment mode in column AE
                   // System.out.println("before search emailAddress=["+emailAddress+"][mobilePhoneNumber="+mobilePhoneNumber+"]!");
                    aUser = userService.getUserByEmailAddressAndMobilePhoneNumber(emailAddress.trim(), mobilePhoneNumber.trim());
                    //aUser = userService.getUserByEmailAddress(emailAddress);
                    if(aUser.isPresent()){
                        //System.out.println("found emailAddress=["+emailAddress+"][mobilePhoneNumber="+mobilePhoneNumber+"]!");
                        aUser.get().setMobilePhoneNumber(mobilePhoneNumber);
                        aUser.get().setCummPaid(cummPaid);
                        aUser.get().setDateOfPreviousDeposit(dateOfPreviousDeposit);
                        aUser.get().setDateOfNextPayment(dateOfNextPayment);
                        aUser.get().setPaymentMode(paymentMode);
                        userService.save(aUser.get());
                    }
                }
            }
        }
        System.out.println("UserComparisonService:updateEntities:Exit");
    }
}
