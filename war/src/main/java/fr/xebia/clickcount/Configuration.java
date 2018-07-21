package fr.xebia.clickcount;

import javax.inject.Singleton;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Singleton
public class Configuration {

    public final String redisHost;
    public final int redisPort;
    public final int redisConnectionTimeout;  //milliseconds

    public Configuration() {

        redisConnectionTimeout = 2000;

        String redisHostProp = "redis";
        int redisPortProp = 1234;

        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream(System.getProperty("catalina.home") + "/properties/redis.properties");
            prop.load(input);

            redisHostProp = prop.getProperty("server.redis.host");
            redisPortProp = Integer.parseInt(prop.getProperty("server.redis.port"));

        } catch (final IOException ex) {
            ex.printStackTrace();
        } finally {

            redisHost = redisHostProp;
            redisPort = redisPortProp;

            if (input != null) {
                try {
                    input.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
