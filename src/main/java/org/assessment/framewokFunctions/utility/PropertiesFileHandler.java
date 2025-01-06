
package org.assessment.framewokFunctions.utility;

import org.assessment.framewokFunctions.exceptionHandler.UserException;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


/**
 * Property file handler. this helps to load and get value of keys from properties file in src/main/resources/config folders
 * works wih .properties files
 * @author Alwin Joseph
 *
 */
public class PropertiesFileHandler {

    private final String BASE_PATH = System.getProperty("user.dir")+"/src/main/resources/config";
    private Properties prop;

    /**
     * Constructor intializes path and throws error if file is not found or any loading error
     * @param fileName
     * @throws UserException
     */
    public PropertiesFileHandler(String fileName) throws UserException {
        prop = new Properties();
        try {
            prop.load(new FileInputStream(BASE_PATH+File.separator+fileName));
        }catch(Exception e) {
            throw new UserException("Exception occured: "+e.getLocalizedMessage());
        }
    }

    /**
     * gets the value of key passed.
     * @param key
     * @return
     * @throws UserException
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
