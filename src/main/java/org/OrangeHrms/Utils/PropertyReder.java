package org.OrangeHrms.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyReder {
    public PropertyReder() {
    }

    public static String readKey(String key) throws FileNotFoundException {
        FileInputStream FileInput = null;
        Properties p = null;
        try {
            FileInput = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/Data.properties");
            p = new Properties();
            p.load(FileInput);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                FileInput.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return p.getProperty(key);
    }
}
