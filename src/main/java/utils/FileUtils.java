package utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.Properties;

public class FileUtils {

    public static InputStream getInputStreamFromFile(String fileName) throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = Optional.ofNullable(classLoader.getResourceAsStream(fileName)).orElseThrow(Exception::new);
        return inputStream;
    }

    public static void getPropertiesAndSetAsSystemProps(String fileName){
        setAsSystemProperties(getPropsFromFile(fileName));
    }

    public static Properties getPropsFromFile(String fileName){
        Properties properties = new Properties();

        try {
            properties.load(getInputStreamFromFile(fileName));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(properties);
        return properties;
    }

    public static void setAsSystemProperties(Properties props){
        props.forEach((k,v) -> System.setProperty(k.toString(),v.toString()));
    }
}
