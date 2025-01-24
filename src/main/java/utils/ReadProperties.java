package utils;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadProperties {

    public static String getProperty(String key) {
        java.util.Properties properties= new java.util.Properties();
        try {

            properties.load(ReadProperties.class.getResourceAsStream(("../configuration.properties")));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties.getProperty(key);

    }
}
