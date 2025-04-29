/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package uhere.library.database.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author emeka
 */
public class UserTest {
    
    public UserTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getId method, of class User.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        User instance = new User();
        Integer expResult = null;
        System.out.println("instance="+instance);
        Integer result = instance.getId();
        System.out.println("result="+result+" expResult="+expResult);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        ////fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class User.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = null;
        User instance = new User();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getTimestamp method, of class User.
     */
    @Test
    public void testGetTimestamp() {
        System.out.println("getTimestamp");
        User instance = new User();
        String expResult = null;
        Timestamp result = instance.getTimestamp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setTimestamp method, of class User.
     */
    @Test
    public void testSetTimestamp() {
        System.out.println("setTimestamp");
        Timestamp timestamp = null;
        User instance = new User();
        instance.setTimestamp(timestamp);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getEmailAddress method, of class User.
     */
    @Test
    public void testGetEmailAddress() {
        System.out.println("getEmailAddress");
        User instance = new User();
        String expResult = null;
        String result = instance.getEmailAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setEmailAddress method, of class User.
     */
    @Test
    public void testSetEmailAddress() {
        System.out.println("setEmailAddress");
        String emailAddress = null;
        User instance = new User();
        instance.setEmailAddress(emailAddress);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPassportPhotograph method, of class User.
     */
    @Test
    public void testGetPassportPhotograph() {
        System.out.println("getPassportPhotograph");
        User instance = new User();
        String expResult = null;
        String result = instance.getPassportPhotograph();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPassportPhotograph method, of class User.
     */
    @Test
    public void testSetPassportPhotograph() {
        System.out.println("setPassportPhotograph");
        String passportPhotograph = null;
        User instance = new User();
        instance.setPassportPhotograph(passportPhotograph);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getSurname method, of class User.
     */
    @Test
    public void testGetSurname() {
        System.out.println("getSurname");
        User instance = new User();
        String expResult = null;
        String result = instance.getSurname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setSurname method, of class User.
     */
    @Test
    public void testSetSurname() {
        System.out.println("setSurname");
        String surname = null;
        User instance = new User();
        instance.setSurname(surname);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstName method, of class User.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        User instance = new User();
        String expResult = null;
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFirstName method, of class User.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = null;
        User instance = new User();
        instance.setFirstName(firstName);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getOtherNames method, of class User.
     */
    @Test
    public void testGetOtherNames() {
        System.out.println("getOtherNames");
        User instance = new User();
        String expResult = null;
        String result = instance.getOtherNames();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setOtherNames method, of class User.
     */
    @Test
    public void testSetOtherNames() {
        System.out.println("setOtherNames");
        String otherNames = null;
        User instance = new User();
        instance.setOtherNames(otherNames);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getMobilePhoneNumber method, of class User.
     */
    @Test
    public void testGetMobilePhoneNumber() {
        System.out.println("getMobilePhoneNumber");
        User instance = new User();
        String expResult = null;
        String result = instance.getMobilePhoneNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setMobilePhoneNumber method, of class User.
     */
    @Test
    public void testSetMobilePhoneNumber() {
        System.out.println("setMobilePhoneNumber");
        String mobilePhoneNumber = null;
        User instance = new User();
        instance.setMobilePhoneNumber(mobilePhoneNumber);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDateOfBirth method, of class User.
     */
    @Test
    public void testGetDateOfBirth() {
        System.out.println("getDateOfBirth");
        User instance = new User();
        String expResult = null;
        String result = instance.getDateOfBirth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDateOfBirth method, of class User.
     */
    @Test
    public void testSetDateOfBirth() {
        System.out.println("setDateOfBirth");
        String dateOfBirth = null;
        User instance = new User();
        instance.setDateOfBirth(dateOfBirth);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getReligion method, of class User.
     */
    @Test
    public void testGetReligion() {
        System.out.println("getReligion");
        User instance = new User();
        String expResult = null;
        String result = instance.getReligion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setReligion method, of class User.
     */
    @Test
    public void testSetReligion() {
        System.out.println("setReligion");
        String religion = null;
        User instance = new User();
        instance.setReligion(religion);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getHostelAddress method, of class User.
     */
    @Test
    public void testGetHostelAddress() {
        System.out.println("getHostelAddress");
        User instance = new User();
        String expResult = null;
        String result = instance.getHostelAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setHostelAddress method, of class User.
     */
    @Test
    public void testSetHostelAddress() {
        System.out.println("setHostelAddress");
        String hostelAddress = null;
        User instance = new User();
        instance.setHostelAddress(hostelAddress);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getHomeAddress method, of class User.
     */
    @Test
    public void testGetHomeAddress() {
        System.out.println("getHomeAddress");
        User instance = new User();
        String expResult = null;
        String result = instance.getHomeAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setHomeAddress method, of class User.
     */
    @Test
    public void testSetHomeAddress() {
        System.out.println("setHomeAddress");
        String homeAddress = null;
        User instance = new User();
        instance.setHomeAddress(homeAddress);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDepartment method, of class User.
     */
    @Test
    public void testGetDepartment() {
        System.out.println("getDepartment");
        User instance = new User();
        String expResult = null;
        String result = instance.getDepartment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDepartment method, of class User.
     */
    @Test
    public void testSetDepartment() {
        System.out.println("setDepartment");
        String department = null;
        User instance = new User();
        instance.setDepartment(department);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getSecondarySchoolAttended method, of class User.
     */
    @Test
    public void testGetSecondarySchoolAttended() {
        System.out.println("getSecondarySchoolAttended");
        User instance = new User();
        String expResult = null;
        String result = instance.getSecondarySchoolAttended();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setSecondarySchoolAttended method, of class User.
     */
    @Test
    public void testSetSecondarySchoolAttended() {
        System.out.println("setSecondarySchoolAttended");
        String secondarySchoolAttended = null;
        User instance = new User();
        instance.setSecondarySchoolAttended(secondarySchoolAttended);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getLevel method, of class User.
     */
    @Test
    public void testGetLevel() {
        System.out.println("getLevel");
        User instance = new User();
        String expResult = null;
        String result = instance.getLevel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setLevel method, of class User.
     */
    @Test
    public void testSetLevel() {
        System.out.println("setLevel");
        String level = null;
        User instance = new User();
        instance.setLevel(level);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getOLevelResults method, of class User.
     */
    @Test
    public void testGetOLevelResults() {
        System.out.println("getOLevelResults");
        User instance = new User();
        String expResult = null;
        String result = instance.getOLevelResults();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setOLevelResults method, of class User.
     */
    @Test
    public void testSetOLevelResults() {
        System.out.println("setOLevelResults");
        String oLevelResults = null;
        User instance = new User();
        instance.setOLevelResults(oLevelResults);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPostUmeScore method, of class User.
     */
    @Test
    public void testGetPostUmeScore() {
        System.out.println("getPostUmeScore");
        User instance = new User();
        String expResult = null;
        String result = instance.getPostUmeScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPostUmeScore method, of class User.
     */
    @Test
    public void testSetPostUmeScore() {
        System.out.println("setPostUmeScore");
        String postUmeScore = null;
        User instance = new User();
        instance.setPostUmeScore(postUmeScore);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCgpaAtTheEndOfSession method, of class User.
     */
    @Test
    public void testGetCgpaAtTheEndOfSession() {
        System.out.println("getCgpaAtTheEndOfSession");
        User instance = new User();
        String expResult = null;
        String result = instance.getCgpaAtTheEndOfSession();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCgpaAtTheEndOfSession method, of class User.
     */
    @Test
    public void testSetCgpaAtTheEndOfSession() {
        System.out.println("setCgpaAtTheEndOfSession");
        String cgpaAtTheEndOfSession = null;
        User instance = new User();
        instance.setCgpaAtTheEndOfSession(cgpaAtTheEndOfSession);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getHowDidYouGetToKnowTheCentre method, of class User.
     */
    @Test
    public void testGetHowDidYouGetToKnowTheCentre() {
        System.out.println("getHowDidYouGetToKnowTheCentre");
        User instance = new User();
        String expResult = null;
        String result = instance.getHowDidYouGetToKnowTheCentre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setHowDidYouGetToKnowTheCentre method, of class User.
     */
    @Test
    public void testSetHowDidYouGetToKnowTheCentre() {
        System.out.println("setHowDidYouGetToKnowTheCentre");
        String howDidYouGetToKnowTheCentre = null;
        User instance = new User();
        instance.setHowDidYouGetToKnowTheCentre(howDidYouGetToKnowTheCentre);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getWhyChooseToStudyAtUhereStudyRoom method, of class User.
     */
    @Test
    public void testGetWhyChooseToStudyAtUhereStudyRoom() {
        System.out.println("getWhyChooseToStudyAtUhereStudyRoom");
        User instance = new User();
        String expResult = null;
        String result = instance.getWhyChooseToStudyAtUhereStudyRoom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setWhyChooseToStudyAtUhereStudyRoom method, of class User.
     */
    @Test
    public void testSetWhyChooseToStudyAtUhereStudyRoom() {
        System.out.println("setWhyChooseToStudyAtUhereStudyRoom");
        String whyChooseToStudyAtUhereStudyRoom = null;
        User instance = new User();
        instance.setWhyChooseToStudyAtUhereStudyRoom(whyChooseToStudyAtUhereStudyRoom);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getOrganizationsYouBelongTo method, of class User.
     */
    @Test
    public void testGetOrganizationsYouBelongTo() {
        System.out.println("getOrganizationsYouBelongTo");
        User instance = new User();
        String expResult = null;
        String result = instance.getOrganizationsYouBelongTo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setOrganizationsYouBelongTo method, of class User.
     */
    @Test
    public void testSetOrganizationsYouBelongTo() {
        System.out.println("setOrganizationsYouBelongTo");
        String organizationsYouBelongTo = null;
        User instance = new User();
        instance.setOrganizationsYouBelongTo(organizationsYouBelongTo);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getHobbies method, of class User.
     */
    @Test
    public void testGetHobbies() {
        System.out.println("getHobbies");
        User instance = new User();
        String expResult = null;
        String result = instance.getHobbies();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setHobbies method, of class User.
     */
    @Test
    public void testSetHobbies() {
        System.out.println("setHobbies");
        String hobbies = null;
        User instance = new User();
        instance.setHobbies(hobbies);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getIntroducedToUhereStudyCentreBy method, of class User.
     */
    @Test
    public void testGetIntroducedToUhereStudyCentreBy() {
        System.out.println("getIntroducedToUhereStudyCentreBy");
        User instance = new User();
        String expResult = null;
        String result = instance.getIntroducedToUhereStudyCentreBy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIntroducedToUhereStudyCentreBy method, of class User.
     */
    @Test
    public void testSetIntroducedToUhereStudyCentreBy() {
        System.out.println("setIntroducedToUhereStudyCentreBy");
        String introducedToUhereStudyCentreBy = null;
        User instance = new User();
        instance.setIntroducedToUhereStudyCentreBy(introducedToUhereStudyCentreBy);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAreUInterestedInContSpiritDoctMoralDev method, of class User.
     */
    @Test
    public void testGetAreUInterestedInContSpiritDoctMoralDev() {
        System.out.println("getAreUInterestedInContSpiritDoctMoralDev");
        User instance = new User();
        String expResult = null;
        String result = instance.getAreUInterestedInContSpiritDoctMoralDev();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setAreUInterestedInContSpiritDoctMoralDev method, of class User.
     */
    @Test
    public void testSetAreUInterestedInContSpiritDoctMoralDev() {
        System.out.println("setAreUInterestedInContSpiritDoctMoralDev");
        String areUInterestedInContSpiritDoctMoralDev = null;
        User instance = new User();
        instance.setAreUInterestedInContSpiritDoctMoralDev(areUInterestedInContSpiritDoctMoralDev);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getInterviewed method, of class User.
     */
    @Test
    public void testGetInterviewed() {
        System.out.println("getInterviewed");
        User instance = new User();
        String expResult = null;
        String result = instance.getInterviewed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setInterviewed method, of class User.
     */
    @Test
    public void testSetInterviewed() {
        System.out.println("setInterviewed");
        String interviewed = null;
        User instance = new User();
        instance.setInterviewed(interviewed);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getInterviewer method, of class User.
     */
    @Test
    public void testGetInterviewer() {
        System.out.println("getInterviewer");
        User instance = new User();
        String expResult = null;
        String result = instance.getInterviewer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setInterviewer method, of class User.
     */
    @Test
    public void testSetInterviewer() {
        System.out.println("setInterviewer");
        String interviewer = null;
        User instance = new User();
        instance.setInterviewer(interviewer);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAccepted method, of class User.
     */
    @Test
    public void testGetAccepted() {
        System.out.println("getAccepted");
        User instance = new User();
        String expResult = null;
        String result = instance.getAccepted();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setAccepted method, of class User.
     */
    @Test
    public void testSetAccepted() {
        System.out.println("setAccepted");
        String accepted = null;
        User instance = new User();
        instance.setAccepted(accepted);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCummPaid method, of class User.
     */
    @Test
    public void testGetCummPaid() {
        System.out.println("getCummPaid");
        User instance = new User();
        String expResult = null;
        String result = instance.getCummPaid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCummPaid method, of class User.
     */
    @Test
    public void testSetCummPaid() {
        System.out.println("setCummPaid");
        String cummPaid = null;
        User instance = new User();
        instance.setCummPaid(cummPaid);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDateOfPreviousDeposit method, of class User.
     */
    @Test
    public void testGetDateOfPreviousDeposit() {
        System.out.println("getDateOfPreviousDeposit");
        User instance = new User();
        String expResult = null;
        String result = instance.getDateOfPreviousDeposit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDateOfPreviousDeposit method, of class User.
     */
    @Test
    public void testSetDateOfPreviousDeposit() {
        System.out.println("setDateOfPreviousDeposit");
        String dateOfPreviousDeposit = null;
        User instance = new User();
        instance.setDateOfPreviousDeposit(dateOfPreviousDeposit);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDateOfNextPayment method, of class User.
     */
    @Test
    public void testGetDateOfNextPayment() {
        System.out.println("getDateOfNextPayment");
        User instance = new User();
        String expResult = null;
        String result = instance.getDateOfNextPayment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDateOfNextPayment method, of class User.
     */
    @Test
    public void testSetDateOfNextPayment() {
        System.out.println("setDateOfNextPayment");
        String dateOfNextPayment = null;
        User instance = new User();
        instance.setDateOfNextPayment(dateOfNextPayment);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getComment method, of class User.
     */
    @Test
    public void testGetComment() {
        System.out.println("getComment");
        User instance = new User();
        String expResult = null;
        String result = instance.getComment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setComment method, of class User.
     */
    @Test
    public void testSetComment() {
        System.out.println("setComment");
        String comment = null;
        User instance = new User();
        instance.setComment(comment);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPaymentMode method, of class User.
     */
    @Test
    public void testGetPaymentMode() {
        System.out.println("getPaymentMode");
        User instance = new User();
        String expResult = null;
        String result = instance.getPaymentMode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPaymentMode method, of class User.
     */
    @Test
    public void testSetPaymentMode() {
        System.out.println("setPaymentMode");
        String paymentMode = null;
        User instance = new User();
        instance.setPaymentMode(paymentMode);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getProbablyInNsukka method, of class User.
     */
    @Test
    public void testGetProbablyInNsukka() {
        System.out.println("getProbablyInNsukka");
        User instance = new User();
        String expResult = null;
        String result = instance.getProbablyInNsukka();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setProbablyInNsukka method, of class User.
     */
    @Test
    public void testSetProbablyInNsukka() {
        System.out.println("setProbablyInNsukka");
        String probablyInNsukka = null;
        User instance = new User();
        instance.setProbablyInNsukka(probablyInNsukka);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class User.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        User instance = new User();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        User instance = new User();
        String expResult = "uhere.library.database.User[ id=null ]";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
