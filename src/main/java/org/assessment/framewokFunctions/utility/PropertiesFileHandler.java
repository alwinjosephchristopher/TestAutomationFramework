
package org.assessment.framewokFunctions.utility;

import org.assessment.framewokFunctions.exceptionHandler.UserException;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;


/**
 * Property file handler. this helps to load and get value of keys from properties file in src/main/resources/config folders
 * works wih .properties files
 * @author Alwin Joseph
 *
 */
public class PropertiesFileHandler {

    private final Properties prop;

    /**
     * Constructor initializes path and throws error if file is not found or any loading error
     * @param fileName filename
     */
    public PropertiesFileHandler(String fileName) throws UserException {
        prop = new Properties();
        try {
            String BASE_PATH = System.getProperty("user.dir") + "/src/main/resources/config";
            prop.load(Files.newInputStream(Paths.get(BASE_PATH + File.separator + fileName)));
        }catch(Exception e) {
            throw new UserException("Exception occured: "+e.getLocalizedMessage());
        }
    }

    /**
     * gets the value of key passed.
     * @param key for which value ought to be found
     * @return value of key
     */
    public String getValue(String key) throws UserException {
        String value;
        try {
            value = prop.getProperty(key);
        }catch(Exception e){
            throw new UserException("Exception Occured when fetching the value for key '"+key+"': "+e.getLocalizedMessage());
        }
        return value;
    }
}
