package auto.project.web;

import auto.project.core.dao.AccountDAO;
import auto.project.core.jpa.dao.AccountJpaImpl;
import auto.project.core.jpa.entity.AccountEntity;
import auto.project.core.service.AccountSearchService;
import auto.project.core.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@PreAuthorize("permitAll()")
@RequestMapping(value = "/")
public class ApplicationController {
    @Autowired
    AccountSearchService accountSearchService;

    @Autowired
    AccountJpaImpl accountDAO;

    @Autowired
    MailService mailService;

    @GetMapping("/carfinder")
    public ModelAndView carFinder() {
        return new ModelAndView("carfinder");
    }

    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/test")
    @Transactional
    public String test() {
        Long id = Long.valueOf(15);

        AccountEntity account = new AccountEntity();
        account.setFirstName("First name");
        account.setLastName("Last name");
        account.setEmail("Email-1");
        account.setPassword("Password");
        account.setCountryCode("US");

        accountDAO.save(account);
        Optional<AccountEntity> accountg = accountDAO.findByEmail("Email");

        System.out.println(accountg.get().getCreated());
        //mailService.sendMailWithActivationToken("ihar.khukhrakou@gmail.com", "token");

        return "index";
    }

}
