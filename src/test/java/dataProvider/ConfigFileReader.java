package dataProvider;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    private final String propertyFilePath= "C:\\Users\\u729097\\IdeaProjects\\demo\\configs\\Configuration.properties";


    public String getApplicationUrl() throws IOException {
        properties = new Properties();
        FileInputStream ip = new FileInputStream(propertyFilePath);
        properties.load(ip);
        String Url = properties.getProperty("url");
        return Url;

    }
}
