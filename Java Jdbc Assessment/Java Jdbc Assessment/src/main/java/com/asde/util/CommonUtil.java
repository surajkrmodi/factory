package com.asde.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.asde.exception.PropertyFileNotFoundException;

public class CommonUtil {
    
    
    /** 
     * @return Properties
     * @throws PropertyFileNotFoundException
     */
    public static Properties getProperties() throws PropertyFileNotFoundException {
        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("application.properties");
        Properties props = new Properties();
        try {
            props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new PropertyFileNotFoundException("Property File NotFound, please have file: application.properties in classpath " , e); 
        }
        return props;
    }

    public static Properties getProperties(String fileName) throws PropertyFileNotFoundException {
        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(fileName+".properties");
        Properties props = new Properties();
        try {
            props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new PropertyFileNotFoundException("Property File NotFound " + fileName, e); 
        }
        return props;
    }
}
