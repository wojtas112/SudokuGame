package org.compprog;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class ViewException extends IOException {

    private static final ResourceBundle messages;
    public static final String SWITCH_EASY_ERROR = "switch.easy";
    public static final String SWITCH_MEDIUM_ERROR = "switch.medium";
    public static final String SWITCH_HARD_ERROR = "switch.hard";
    public static final String SWITCH_PL_ERROR = "switch.pl";
    public static final String SWITCH_EN_ERROR = "switch.en";
    static {
        Locale locale = Locale.getDefault(Locale.Category.DISPLAY);
        messages = ResourceBundle.getBundle("org.compprog.ViewException", locale);
    }

    public ViewException(String message) {
        super(message);
    }

    public ViewException(String message, Throwable cause) {
        super(message, cause);
    }

}
