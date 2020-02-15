/**
 * 
 */
package cl.liberty.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

/**
 * Spring needs to know which packages to scan for annotated components in order
 * to add them to the IoC container. The @ComponentScan annotation is used with
 * the @Configuration annotation to tell Spring the packages to scan for
 * annotated components.
 * <p>
 * Add @PropertySources to support Java 8 and better way to include multiple properties files.
 * You can use ignoreResourceNotFound to ignore the not found properties file.
 *
 * If Spring find the secondary PropertySource file, override all local properties values.
 *
 * @author jgarrido
 */
@SpringBootApplication
@ComponentScan("cl.liberty")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    public void setProperties(Environment env) {
        Properties.setEnviroment(env);
    }

}
