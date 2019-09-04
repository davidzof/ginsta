package org.instagram;

import java.io.*;
import java.util.Properties;

public class PropertyManager {
    Properties read() {
        Properties prop = new Properties();

        try (InputStream input = new FileInputStream("ginsta.properties")) {

            // load a properties file
            prop.load(input);
        } catch (IOException io) {
            io.printStackTrace();
        }
        return prop;
    }

    void write(Properties prop) {
        try (OutputStream output = new FileOutputStream("ginsta.properties")) {
            // save properties to project root folder
            prop.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
