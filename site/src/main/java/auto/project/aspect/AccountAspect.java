package auto.project.aspect;

import auto.project.core.dto.request.RegistrationDTO;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountAspect {
    @Pointcut("execution(* auto.project.web.controller.rest.AccountRestController.registration(..)) && args(registrationDTO)")
    protected void sendRegistrationMemo(RegistrationDTO registrationDTO) {
    }

    @After("sendRegistrationMemo(registrationDTO)")
    public void actionAfterRegistration(RegistrationDTO registrationDTO) {

    }
}
