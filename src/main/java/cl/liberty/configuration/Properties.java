/**
 * 
 */
package cl.liberty.configuration;

import java.util.Objects;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author jgarrido
 */
@Component
@PropertySource(value = "file:D:\\Users\\jgarrido\\workspace-administrator\\5.3.4-apimortgageadmin\\properties\\local\\parameters\\application.properties")
//@PropertySource(value = "file:/tmp/parameters/application.properties")
@ConfigurationProperties(prefix = "default")
public class Properties {

    private static Environment env;

    private Properties() {
        // Constructor privado para ocultar el público implícito.
    }
   
    /**
     * La clase de aplicación principal llama a este método de establecimiento de entorno en el mismo paquete.
     * @param env El environment en el que se ejecuta la aplicación actual. Medio environment de Spring Framework.
     */
    static void setEnviroment(Environment env) {
        Properties.env = env;
    }

    public static String getString(String key) {
        return env.getProperty(key);
    }

    public static int getInt(String key) {
        return Integer.parseInt(Objects.requireNonNull(env.getProperty(key)));
    }

    public static long getLong(String key) {
        return Long.parseLong(Objects.requireNonNull(env.getProperty(key)));
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(Objects.requireNonNull(env.getProperty(key)));
    }
}
