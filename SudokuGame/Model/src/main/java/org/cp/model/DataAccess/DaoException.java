package org.cp.model.DataAccess;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class DaoException extends Exception{



    private static final ResourceBundle messages;
    public static final String NULL_NAME = "null.name";
    public static final String WRITE_ERROR = "write.error";
    public static final String READ_ERROR = "read.error";

    static {
        Locale locale = Locale.getDefault(Locale.Category.DISPLAY);
        messages = ResourceBundle.getBundle("daoException.Dao", locale);
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getLocalizedMessage() {
        String message;
        try{
            message = messages.getString(getMessage());
        } catch (MissingResourceException mre) {
            message = "No resource for" + getMessage();
        }
        return message;
    }
}
