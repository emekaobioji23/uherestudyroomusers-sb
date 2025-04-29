package uhere.library.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * This class serves as the entry point of a SpringBootApplication.
 * @author emeka
 */
@SpringBootApplication
public class LibraryDatabaseApplication {
/**
 * This is the default constructor
 */   
    public LibraryDatabaseApplication(){
        
    }
/**
 * It has only the main method which collects command line list of 
 * argument provided by the generics @SpringBootApplicationargs. It setups and
 * runs LibraryDatabaseApplication as a SpringBootApplication.
 * @param args an array of command line comma separated argument provided by
 * Spring Framework.
 */
    public static void main(String[] args) {
            SpringApplication.run(LibraryDatabaseApplication.class, args);
    }

}
