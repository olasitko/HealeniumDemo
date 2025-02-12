package helpers;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ApplicationConfig {
    static Config conf = ConfigFactory.load();

    public static String getProperty(String propertyKey) {
        return conf.getString(propertyKey);
    }

    public static Integer getIntProperty(String propertyKey) {
        return conf.getInt(propertyKey);
    }
}