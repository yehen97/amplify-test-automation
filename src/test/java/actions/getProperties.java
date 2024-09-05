package actions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class getProperties {


    public static String getProperty(String key) throws IOException {
        String propertyFilePath = "src/main/resources/properties.properties";
        FileInputStream fis = new FileInputStream(propertyFilePath);
        Properties prop = new Properties();
        prop.load(fis);
        return prop.getProperty(key);

    }
}
