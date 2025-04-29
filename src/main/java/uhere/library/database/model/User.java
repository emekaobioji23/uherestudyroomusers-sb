/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uhere.library.database.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * This class is an Entity Enterprise JavaBean (EJB) managed by JPA. It models a typical Uhere Study Centre Library user.
 * @author emeka
 */
@Entity
@Table(catalog = "uherelibrary", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id")})
public class User implements Serializable {

/**
 * The serialization version string for the User entity persistence.
 */
    private static final long serialVersionUID = 1L;
/**
 * The User id.
*/
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
/**
 * The User creation time.
*/
    @Column(name = "timestamp", columnDefinition = "DATETIME")
    private Timestamp timestamp;
/**
 * The email address
*/
    @Column(name = "emailaddress")
    private String emailAddress;
/**
 * The User passport photograph.
*/
    @Column(name = "passportphotograph")
    private String passportPhotograph;
/**
 * The User surname.
*/
    @Column(name = "surname")
    private String surname;
/**
 * The User first name.
*/
    @Column(name = "firstname")
    private String firstName;
/**
 * The User other names.
*/
    @Column(name = "othernames")
    private String otherNames;
/**
 * The User mobile phone number.
*/
    @Column(name = "mobilephonenumber")
    private String mobilePhoneNumber;
/**
 * The User date of birth.
*/
    @Column(name = "dateofbirth")
    private String dateOfBirth;
/**
 * The User religion.
*/
    @Column(name = "religion")
    private String religion;
/**
 * The User hostel address.
*/
    @Column(name = "hosteladdress")
    private String hostelAddress;
/**
 * The User home address.
*/
    @Column(name = "homeaddress")
    private String homeAddress;
/**
 * The User department.
*/
    @Column(name = "department")
    private String department;
/**
 * The User secondary school attended.
*/
    @Column(name = "secondaryschoolattended")
    private String secondarySchoolAttended;
/**
 * The User course level.
*/
    @Column(name = "level")
    private String level;
/**
 * The User O level results.
*/
    @Column(name = "olevelresults")
    private String oLevelResults;
/**
 * The User post UME scores.
*/
    @Column(name = "postumescore")
    private String postUmeScore;
/**
 * The User CGPA at the end of the session.
*/
    @Column(name = "cgpaattheendofsession")
    private String cgpaAtTheEndOfSession;
/**
 * The User how did you get to know the center.
*/
    @Column(name = "howdidyougettoknowthecentre",length = 2048)
    private String howDidYouGetToKnowTheCentre;
/**
 * The User why choose to study at Uhere.
*/
    @Column(name = "whychoosetostudyatuhere",length = 2048)
    private String whyChooseToStudyAtUhereStudyRoom;
/**
 * The organizations belonged to by user.
*/    
    @Column(name = "organizationsyoubelongto",length = 2048)
    private String organizationsYouBelongTo;
/**
 * The User's hobbies.
*/
    @Column(name = "hobbies",length = 2048)
    private String hobbies;
/**
 * The name of the person who introduced User to library.
*/
    @Column(name = "introducedtouhereby")
    private String introducedToUhereStudyCentreBy;
/**
 * The User's interest in continuous spiritual, doctrinal and moral development.
*/
    @Column(name = "areuinterestedincontform")
    private String areUInterestedInContSpiritDoctMoralDev;
/**
 * The User interviewed status.
*/
    @Column(name = "interviewed")
    private String interviewed;
/**
 * The User interviewer's name.
*/
    @Column(name = "interviewer")
    private String interviewer;
/**
 * The User acceptance status.
*/
    @Column(name = "accepted")
    private String accepted;
/**
 * The User cumulative paid.
*/
    @Column(name = "cummpaid")
    private String cummPaid;
/**
 * The User date of previous deposit.
*/
    @Column(name = "dateofpreviousdeposit")
    private String dateOfPreviousDeposit;
/**
 * The User date of next payment
*/
    @Column(name = "dateofnextpayment")
    private String dateOfNextPayment;
/**
 * The User comment on payment.
*/
    @Column(name = "comment")
    private String comment;
/**
 * The User payment mode.
*/
    @Column(name = "paymentmode")
    private String paymentMode;
/**
 * The User is still at Nsukka.
*/
    @Column(name = "probablyinnsukka")
    private String probablyInNsukka;
/**
 * This method is the constructor of the class. 
 * It creates an instance of a User Enterprise Entity Java Beans.
 */
    public User() {
    }
/**
 * This method is the constructor of the class. 
 * It creates an instance of a User Enterprise Entity Java Beans.
 * @param id is the unique identification number for the User entity
 */
    public User(Integer id) {
        this.id = id;
    }
/**
 * This method is the constructor of the class. 
 * It creates an instance of a User Enterprise Entity Java Beans.
 * @param timestamp is the time of creation of the User entity
 * @param emailAddress is the email address of User entity
 * @param passportPhotograph is the photograph of the User entity
 * @param surname is the surname of the User entity
 * @param firstName is the first name of the User entity
 * @param otherNames is the other names of the User entity
 * @param mobilePhoneNumber is the mobile phone number of the User entity
 * @param dateOfBirth is the date of birth of the User entity
 * @param religion is the religion of the User entity
 * @param hostelAddress is the hostel address of the User entity
 * @param homeAddress is the homeAddress of the User entity
 * @param department is the department of the User entity
 * @param secondarySchoolAttended is the secondary school attended of the User entity
 * @param level is the course level of the User entity
 * @param oLevelResults is the O Level results of the User entity
 * @param postUmeScore is the post UME score of the User entity
 * @param cgpaAtTheEndOfSession is the CGPA at the end of the session of the User entity
 * @param howDidYouGetToKnowTheCentre is the how did you get to know the center of the User entity
 * @param whyChooseToStudyAtUhereStudyRoom is the why choose to study at Uhere study room of the User entity
 * @param organizationsYouBelongTo are the organizations the User entity belongs to
 * @param hobbies are the hobbies of the User entity
 * @param introducedToUhereStudyCentreBy is how the User entity was introduced to Uhere
 * @param areUInterestedInContSpiritDoctMoralDev is the User entity's interest in continous spiritual, doctrinal and moral development
 * @param interviewed is whether the User entity has been interviewed
 * @param interviewer is the interviewer of the User entity
 * @param accepted is whether the User entity has been accepted
 * @param cummPaid is the cumulative amount paid by User entity
 * @param dateOfPreviousDeposit is the date the User entity paid the last amount
 * @param dateOfNextPayment is the date the User entity is expected to pay again
 * @param comment are the interviewer's comments for the User entity
 * @param paymentMode is the payment mode of User entity
 * @param probablyInNsukka indicates if the User entity is still at Nsukka
 */
    public User(Timestamp timestamp, String emailAddress, 
            String passportPhotograph, String surname, String firstName, 
            String otherNames, String mobilePhoneNumber, String dateOfBirth, 
            String religion, String hostelAddress, String homeAddress, 
            String department, String secondarySchoolAttended, String level, 
            String oLevelResults, String postUmeScore, String cgpaAtTheEndOfSession, 
            String howDidYouGetToKnowTheCentre, String whyChooseToStudyAtUhereStudyRoom, 
            String organizationsYouBelongTo, String hobbies, String introducedToUhereStudyCentreBy, 
            String areUInterestedInContSpiritDoctMoralDev, String interviewed, 
            String interviewer, String accepted, String cummPaid, String dateOfPreviousDeposit, 
            String dateOfNextPayment, String comment, String paymentMode, String probablyInNsukka) {
        this.timestamp = timestamp;
        this.emailAddress = emailAddress;
        this.passportPhotograph = passportPhotograph;
        this.surname = surname;
        this.firstName = firstName;
        this.otherNames = otherNames;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.religion = religion;
        this.hostelAddress = hostelAddress;
        this.homeAddress = homeAddress;
        this.department = department;
        this.secondarySchoolAttended = secondarySchoolAttended;
        this.level = level;
        this.oLevelResults = oLevelResults;
        this.postUmeScore = postUmeScore;
        this.cgpaAtTheEndOfSession = cgpaAtTheEndOfSession;
        this.howDidYouGetToKnowTheCentre = howDidYouGetToKnowTheCentre;
        this.whyChooseToStudyAtUhereStudyRoom = whyChooseToStudyAtUhereStudyRoom;
        this.organizationsYouBelongTo = organizationsYouBelongTo;
        this.hobbies = hobbies;
        this.introducedToUhereStudyCentreBy = introducedToUhereStudyCentreBy;
        this.areUInterestedInContSpiritDoctMoralDev = areUInterestedInContSpiritDoctMoralDev;
        this.interviewed = interviewed;
        this.interviewer = interviewer;
        this.accepted = accepted;
        this.cummPaid = cummPaid;
        this.dateOfPreviousDeposit = dateOfPreviousDeposit;
        this.dateOfNextPayment = dateOfNextPayment;
        this.comment = comment;
        this.paymentMode = paymentMode;
        this.probablyInNsukka = probablyInNsukka;
    }
/**
 * This method returns the entity's unique identification number id
 * @return the id as Integer
 */    
    public Integer getId() {
        return id;
    }
/**
 * This method sets the entity's unique identification number id
 * @param id is the unique identification number for the User entity
 */ 
    public void setId(Integer id) {
        this.id = id;
    }
/**
 * This method returns the entity's timestamp property
 * @return the timestamp as string
 */
    public Timestamp getTimestamp() {
        if(timestamp != null){
            //System.out.println("User Entity getTimestamp "+id+" = "+timestamp.toInstant().toString());
       }
        return timestamp;
    }
/**
 * This method sets the entity's creation timestamp
 * @param timestamp is the creation timestamp for the User entity
 */ 
    public void setTimestamp(Timestamp timestamp) {
        if(timestamp != null){
            //System.out.println("User Entity setTimestamp "+id+" = "+timestamp.toInstant().toString());
            this.timestamp = timestamp;
        }
        
    }
/**
 * This method returns the entity's email address property
 * @return the email address as string
 */
    public String getEmailAddress() {
        return emailAddress;
    }
/**
 * This method sets the entity's emailAddress
 * @param emailAddress is the email address of the User entity
 */ 
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
/**
 * This method returns the entity's passport photograph property
 * @return the passport photograph as string
 */
    public String getPassportPhotograph() {
        return passportPhotograph;
    }
/**
 * This method sets the entity's passportPhotograph
 * @param passportPhotograph is the passport photograph of the User entity
 */ 
    public void setPassportPhotograph(String passportPhotograph) {
        this.passportPhotograph = passportPhotograph;
    }
/**
 * This method returns the entity's surname property
 * @return the surname as string
 */
    public String getSurname() {
        return surname;
    }
/**
 * This method sets the entity's surname
 * @param surname is the surname of the User entity
 */ 
    public void setSurname(String surname) {
        this.surname = surname;
    }
/**
 * This method returns the entity's first name property
 * @return the first name as string
 */
    public String getFirstName() {
        return firstName;
    }
/**
 * This method sets the entity's firstName
 * @param firstName is the firstName of the User entity
 */ 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
/**
 * This method returns the entity's get other names property
  * @return the other names as string
 */
    public String getOtherNames() {
        return otherNames;
    }
/**
 * This method sets the entity's otherNames
 * @param otherNames is the otherNames of the User entity
 */ 
    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }
/**
 * This method returns the entity's mobile phone number property
 * @return the mobile phone number as string
 */
    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }
/**
 * This method sets the entity's mobile phone number
 * @param mobilePhoneNumber is the mobile phone number of the User entity
 */ 
    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }
/**
 * This method returns the entity's date of birth property
 * @return the date of birth as string
 */
    public String getDateOfBirth() {
        return dateOfBirth;
    }
/**
 * This method sets the entity's date of birth
 * @param dateOfBirth is the date of birth of the User entity
 */ 
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
/**
 * This method returns the entity's religion property
 * @return the religion as string
 */
    public String getReligion() {
        return religion;
    }
/**
 * This method sets the entity's religion
 * @param religion is the religion of the User entity
 */
    public void setReligion(String religion) {
        this.religion = religion;
    }
/**
 * This method returns the entity's hostel address property
 * @return the hostel address as string
 */
    public String getHostelAddress() {
        return hostelAddress;
    }
/**
 * This method sets the entity's hostel address
 * @param hostelAddress is the hostel address of the User entity
 */
    public void setHostelAddress(String hostelAddress) {
        this.hostelAddress = hostelAddress;
    }
/**
 * This method returns the entity's home address property
 * @return the home address as string
 */
    public String getHomeAddress() {
        return homeAddress;
    }
/**
 * This method sets the entity's home address
 * @param homeAddress is the home address of the User entity
 */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
/**
 * This method returns the entity's academic department property
 * @return the academic department as string
 */
    public String getDepartment() {
        return department;
    }
/**
 * This method sets the entity's department
 * @param department is the department of the User entity
 */
    public void setDepartment(String department) {
        this.department = department;
    }
/**
 * This method returns the entity's secondary school attended name property
 * @return the secondary school name as string
 */
    public String getSecondarySchoolAttended() {
        return secondarySchoolAttended;
    }
/**
 * This method sets the entity's secondary school attended
 * @param secondarySchoolAttended is the secondary school attended of the User entity
 */
    public void setSecondarySchoolAttended(String secondarySchoolAttended) {
        this.secondarySchoolAttended = secondarySchoolAttended;
    }
/**
 * This method returns the entity's level property
 * @return the level as string
 */
    public String getLevel() {
        return level;
    }
/**
 * This method sets the entity's level
 * @param level is the current university course level of the User entity
 */
    public void setLevel(String level) {
        this.level = level;
    }
/**
 * This method returns the entity's O level results property
 * @return the o level results as string
 */
    public String getOLevelResults() {
        return oLevelResults;
    }
/**
 * This method sets the entity's O level results
 * @param oLevelResults is the current O level results of the User entity
 */
    public void setOLevelResults(String oLevelResults) {
        this.oLevelResults = oLevelResults;
    }
/**
 * This method returns the entity's post UME score property
 * @return the post UME score as string
 */
    public String getPostUmeScore() {
        return postUmeScore;
    }
/**
 * This method sets the entity's post UME score
 * @param postUmeScore is the current postUmeScore of the User entity
 */
    public void setPostUmeScore(String postUmeScore) {
        this.postUmeScore = postUmeScore;
    }
/**
 * This method returns the entity's CGPA at the end of the session property
 * @return the CGPA at the end of the session as string
 */
    public String getCgpaAtTheEndOfSession() {
        return cgpaAtTheEndOfSession;
    }
/**
 * This method sets the entity's CGPA at the end of session
 * @param cgpaAtTheEndOfSession is the CGPA at the end of session of the User entity
 */
    public void setCgpaAtTheEndOfSession(String cgpaAtTheEndOfSession) {
        this.cgpaAtTheEndOfSession = cgpaAtTheEndOfSession;
    }
/**
 * This method returns the entity's how did you know the center property
 * @return the how did you know the center at the end of the session as string
 */
    public String getHowDidYouGetToKnowTheCentre() {
        return howDidYouGetToKnowTheCentre;
    }
/**
 * This method sets the entity's how did you get to know the center
 * @param howDidYouGetToKnowTheCentre is the how the entity got to know the center
 */
    public void setHowDidYouGetToKnowTheCentre(String howDidYouGetToKnowTheCentre) {
        this.howDidYouGetToKnowTheCentre = howDidYouGetToKnowTheCentre;
    }
/**
 * This method returns the entity's why choose to study at Uhere study room property
 * @return the why choose to study at Uhere study room at the end of the session as string
 */
    public String getWhyChooseToStudyAtUhereStudyRoom() {
        return whyChooseToStudyAtUhereStudyRoom;
    }
/**
 * This method sets the entity's why choose to study at uhere study room
 * @param whyChooseToStudyAtUhereStudyRoom is the why choose to study uhere study room
 */
    public void setWhyChooseToStudyAtUhereStudyRoom(String whyChooseToStudyAtUhereStudyRoom) {
        this.whyChooseToStudyAtUhereStudyRoom = whyChooseToStudyAtUhereStudyRoom;
    }
/**
 * This method returns the entity's organization you belong to property
 * @return the organization you belong to as string
 */
    public String getOrganizationsYouBelongTo() {
        return organizationsYouBelongTo;
    }
/**
 * This method sets the entity's organizations you belong to
 * @param organizationsYouBelongTo is the organizations the entity belongs to.
 */
    public void setOrganizationsYouBelongTo(String organizationsYouBelongTo) {
        this.organizationsYouBelongTo = organizationsYouBelongTo;
    }
/**
 * This method returns the entity's hobbies property
 * @return the hobbies as string
 */
    public String getHobbies() {
        return hobbies;
    }
/**
 * This method sets the entity's hobbies
 * @param hobbies are the string comma separated hobbies of the User entity
 */
    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }
/**
 * This method returns the entity's introduced to uhere study center by property
 * @return the introduced to uhere study center by as string
 */
    public String getIntroducedToUhereStudyCentreBy() {
        return introducedToUhereStudyCentreBy;
    }
/**
 * This method sets the entity's how did you get to know the center
 * @param introducedToUhereStudyCentreBy is the person who introduced entity to world.
 */
    public void setIntroducedToUhereStudyCentreBy(String introducedToUhereStudyCentreBy) {
        this.introducedToUhereStudyCentreBy = introducedToUhereStudyCentreBy;
    }
/**
 * This method returns the entity's are you interested in continuous spiritual doctrinal moral development property
 * @return the are you interested in continuous spiritual doctrinal moral development as string
 */
    public String getAreUInterestedInContSpiritDoctMoralDev() {
        return areUInterestedInContSpiritDoctMoralDev;
    }
/**
 * This method sets the entity's are you interested in continuous spiritual, doctrinal and moral 
 * @param areUInterestedInContSpiritDoctMoralDev is the how the entity got to know the center
 */
    public void setAreUInterestedInContSpiritDoctMoralDev(String areUInterestedInContSpiritDoctMoralDev) {
        this.areUInterestedInContSpiritDoctMoralDev = areUInterestedInContSpiritDoctMoralDev;
    }
/**
 * This method returns the entity's interviewed status property
 * @return the interviewed status as string
 */
    public String getInterviewed() {
        return interviewed;
    }
/**
 * This method sets the entity's interviewed status
 * @param interviewed is the entity's interviewed status.
 */
    public void setInterviewed(String interviewed) {
        this.interviewed = interviewed;
    }
/**
 * This method returns the entity's interviewer property
 * @return the interviewer as string
 */
    public String getInterviewer() {
        return interviewer;
    }
/**
 * This method sets the entity's interviewer
 * @param interviewer is the person who interviewed the entity
 */
    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }
/**
 * This method returns the entity's accepted property
 * @return the accepted as string
 */
    public String getAccepted() {
        return accepted;
    }
/**
 * This method sets the entity's accepted
 * @param accepted is the accepted status of the User entity
 */
    public void setAccepted(String accepted) {
        this.accepted = accepted;
    }
/**
 * This method returns the entity's cumulative paid property
 * @return the cumulative paid as string
 */
    public String getCummPaid() {
        return cummPaid;
    }
/**
 * This method sets the entity's cumulative payment
 * @param cummPaid is total payment made by User entity till date.
 */
    public void setCummPaid(String cummPaid) {
        this.cummPaid = cummPaid;
    }
/**
 * This method returns the entity's date of previous deposit paid property
 * @return the date of previous deposit paid as string
 */
    public String getDateOfPreviousDeposit() {
        return dateOfPreviousDeposit;
    }
/**
 * This method sets the entity's previous payment date
 * @param dateOfPreviousDeposit is the previous payment date
 */
    public void setDateOfPreviousDeposit(String dateOfPreviousDeposit) {
        this.dateOfPreviousDeposit = dateOfPreviousDeposit;
    }
/**
 * This method returns the entity's date of next payment property
 * @return the date of next payment as string
 */
    public String getDateOfNextPayment() {
        return dateOfNextPayment;
    }
/**
 * This method sets the entity's dateOfNextPayment
 * @param dateOfNextPayment is the date of next payment
 */
    public void setDateOfNextPayment(String dateOfNextPayment) {
        this.dateOfNextPayment = dateOfNextPayment;
    }
/**
 * This method returns the comment property
 * @return the comment as string
 */
    public String getComment() {
        return comment;
    }
/**
 * This method sets the entity's comment regarding payment
 * @param comment is the comment
 */
    public void setComment(String comment) {
        this.comment = comment;
    }
/**
 * This method returns the payment mode property
 * @return the payment mode as string
 */
    public String getPaymentMode() {
        return paymentMode;
    }
/**
 * This method sets the entity's payment mode
 * @param paymentMode is the paymodeMode
 */
    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }
/**
 * This method returns the probably in Nsukka property
 * @return the probably in Nsukka as string
 */
    public String getProbablyInNsukka() {
        return probablyInNsukka;
    }
/**
 * This method sets the entity's probably in Nsukka
 * @param probablyInNsukka is the probably in Nsukka
 */
    public void setProbablyInNsukka(String probablyInNsukka) {
        this.probablyInNsukka = probablyInNsukka;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uhere.library.database.User[ id=" + id + " ]";
    }
    
}
