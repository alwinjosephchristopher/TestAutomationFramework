package org.assessment.framewokFunctions.exceptionHandler;

public class UserException extends Exception{
    /**
     * UserException created to handle custom messages for test failures or assertion failures
     * @param e exception string
     */
    public UserException(String e) {
        super(e);
    }

}
