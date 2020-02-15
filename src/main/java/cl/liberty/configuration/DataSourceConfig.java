/**
 * 
 */
package cl.liberty.configuration;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

/**
 * @author jgarrido
 *
 */
@Configuration
public class DataSourceConfig {

    @Value("${encrypt.secret}")
    private String secret;

    @Value("${encrypt.key}")
    private String key;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Bean("administratormortgageservicesDataSource")
    public DataSource getDataSource() {
        DataSourceProperties properties = getDataSourceProperties();
        TextEncryptor textEncryptor = Encryptors.delux(secret, key);
        properties.setPassword(textEncryptor.decrypt(properties.getPassword()));
        return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    private DataSourceProperties getDataSourceProperties() {
        DataSourceProperties dataSourceProperties = new DataSourceProperties();
        dataSourceProperties.setUrl(url);
        dataSourceProperties.setUsername(userName);
        dataSourceProperties.setPassword(password);
        dataSourceProperties.setDriverClassName(driverClassName);
        return dataSourceProperties;
    }

}
