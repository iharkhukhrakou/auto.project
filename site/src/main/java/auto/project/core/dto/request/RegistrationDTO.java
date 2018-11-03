package auto.project.core.dto.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class RegistrationDTO {
    @NotBlank
    @Pattern(regexp = "[a-zA-Z0-9_-]{2,20}")
    private String firstname;

    @NotBlank
    private String lastname;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String passwordconfirm;

    @NotBlank
    private String country;

    private String reCaptcha;
}
