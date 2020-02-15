package cl.liberty.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.util.Properties;

/**
 * Encuentre la versión de implementación de Maven utilizando el archivo pom.properties.
 *
 * @author jgarrido
 */
@Component
public class SemverResolver {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    private static String version;
    private static final String GROUP_ID = "cl.liberty.underwriting";
    private static final String ARTIFACT_ID = "administrator-mortgage-service";

    @PostConstruct
    public void resolveVersion() {
        logger.info("{}", "Resolving Maven implementation version value for SpringConfig class..." + SemverResolver.getVersion());
        String mavenVersion = null;
        String path = String.format("/META-INF/maven/%s/%s/pom.properties", GROUP_ID, ARTIFACT_ID);
        try {
            InputStream stream = Application.class.getResourceAsStream(path);
            // load from maven properties
            Properties properties = new Properties();
            if (stream != null) {
                properties.load(stream);
                mavenVersion = properties.getProperty("version", "");
            }
        } catch (Exception e) {
            logger.error("An error has occurred while resolving Maven implementation version value", e);
        }

        if (mavenVersion == null) {
            mavenVersion = "";
            logger.warn("Could not resolve the Maven implementation version for '{}' so use a blank", path);
        }
        // then use the set method
        SemverResolver.setVersion(mavenVersion);
        // print application version
        logger.info("Running application version: {}", SemverResolver.getVersion());
    }

    /**
     * @return the value of Maven implementation version specified in the pom.properties file.
     */
    public static String getVersion() {
        return SemverResolver.version;
    }

    private static void setVersion(String version) {
        SemverResolver.version = version;
    }
}
