package auto.project.core.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Validated
public interface MailService {
    @Async
    void sendMailWithActivationToken(
            @NotBlank @Email final String email,
            @NotBlank final String token
    );
}
