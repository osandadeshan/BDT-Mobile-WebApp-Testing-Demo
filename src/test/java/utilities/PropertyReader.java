package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Osanda on 4/30/2017.
 */

public abstract class PropertyReader {

    public static String readingFromPropertyFile(String property) throws IOException {
        File file = new File("resources\\app.properties");
        FileInputStream fileInput = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(fileInput);
        String PROPERTY_VALUE = String.valueOf(properties.getProperty(property));
        return PROPERTY_VALUE;
    }

}
