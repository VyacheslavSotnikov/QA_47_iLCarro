package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Properties {
    public  static  void main(String[] args) {
        System.out.println(getProperty("login.properties", "email"));
    }

    public static String getProperty(String fileName, String key) {
        java.util.Properties properties = new java.util.Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/properties"
                + File.separator + fileName)) {
            properties.load(fileInputStream);
            return properties.getProperty(key);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
