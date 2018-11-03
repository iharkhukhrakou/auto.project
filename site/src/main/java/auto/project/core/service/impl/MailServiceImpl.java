package auto.project.core.service.impl;

import auto.project.core.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Service("mailService")
@Validated
public class MailServiceImpl implements MailService {
    private final JavaMailSender javaMailSender;

    @Autowired
    public MailServiceImpl(@NotNull final JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    private void sendMail(@NotNull final MimeMessage mailMessage
    ) {
        javaMailSender.send(mailMessage);
    }


    @Override
    @Async
    public void sendMailWithActivationToken(@NotBlank @Email final String email, @NotBlank final String token) {
        try {
            final MimeMessage message = javaMailSender.createMimeMessage();

            final MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setTo(email);
            helper.setSubject("Complete registration");
            helper.setText("To activation your account, click the link below:<br />"
                    + "<a href='" + "https://localhost:8443" + "/register/thanks?token=" + "token" + "'>" +
                    "Click here to complete your registration" +
                    "</a>", true);

            sendMail(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
