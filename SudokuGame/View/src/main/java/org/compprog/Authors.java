package org.compprog;

import java.util.ListResourceBundle;

public class Authors extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {"1. ", "Bartlomiej Runowski"},
                {"2. ", "Wojciech Wozniak"}
        };
    }
}
