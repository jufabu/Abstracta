package mercadolibre.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {
    private Properties properties = new Properties();

    public GetProperties() {
        InputStream inputStream = getClass().getResourceAsStream("/config.properties");
        try {
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            System.out.println("The file config.properties was not found");
        } catch (IOException e) {
            System.out.println("Can not read the properties file");
        }
    }

    public String getString(String propertyName) {
        return properties.getProperty(propertyName);
    }
}
