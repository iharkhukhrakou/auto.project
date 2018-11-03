package auto.project.configuration.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailContext {
    @Autowired
    private Environment environment;

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setJavaMailProperties(getMailProrerties());
        mailSender.setUsername(environment.getRequiredProperty("mail.username"));
        mailSender.setPassword(environment.getRequiredProperty("mail.password"));
        return mailSender;
    }

    private Properties getMailProrerties() {
        Properties mailProperties = new Properties();
        mailProperties.put("mail.transport.protocol", environment.getRequiredProperty("mail.protocol"));
        mailProperties.put("mail.smtp.host", environment.getRequiredProperty("mail.smtp.host"));
        mailProperties.put("mail.smtp.port", environment.getRequiredProperty("mail.smtp.port"));
        mailProperties.put("mail.smtp.auth", environment.getRequiredProperty("mail.smtp.auth"));
        mailProperties.put("mail.smtp.starttls.enable", environment.getRequiredProperty("mail.smtp.starttls.enable"));
        //mailProperties.put("mail.smtp.starttls.required", environment.getRequiredProperty("mail.smtp.starttls.required"));
        //mailProperties.put("mail.smtp.socketFactory.port", environment.getRequiredProperty("mail.smtp.socketFactory.port"));
        //mailProperties.put("mail.smtp.socketFactory.class", environment.getRequiredProperty("mail.smtp.socketFactory.class"));
        mailProperties.put("mail.smtp.debug", environment.getRequiredProperty("mail.smtp.debug"));
        return mailProperties;
    }
}
