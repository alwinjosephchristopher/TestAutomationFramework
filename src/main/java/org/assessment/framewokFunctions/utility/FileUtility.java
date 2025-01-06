package org.assessment.framewokFunctions.utility;

import org.assessment.framewokFunctions.exceptionHandler.UserException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtility {

    /**
     * helps to retrieve list of required files
     * @return
     * @throws {@link UserException
    }
     */
    public List<String> getAllFiles(String directory,String format) throws UserException {
        List<String> requiredFiles = new ArrayList<>();
        try {
            File folder = new File(directory);
            File[] listOfFiles = folder.listFiles();

            assert listOfFiles != null;
            for(File file : listOfFiles) {
                if(file.isFile() && file.getName().endsWith(format)) {
                    requiredFiles.add(file.getAbsolutePath());
                }
            }

        }catch(Exception e) {
            throw new UserException("Error occurred when fetching Json Files. "+e.getLocalizedMessage());
        }
        return requiredFiles;
    }

}
