package auto.project.web.controller.rest;

import auto.project.core.dto.request.RegistrationDTO;
import auto.project.core.service.AccountSearchService;
import auto.project.core.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/account")
public class AccountRestController {
    private final AccountService accountService;
    private final AccountSearchService accountSearchService;

    @Autowired
    public AccountRestController(
            final AccountService accountService,
            final AccountSearchService accountSearchService
    ) {
        this.accountService = accountService;
        this.accountSearchService = accountSearchService;
    }

    @PostMapping(value = "/registration", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> registration(
            @Valid @RequestBody final RegistrationDTO registrationDTO,
            final UriComponentsBuilder uriComponentsBuilder
    ) {
        System.out.println("registration");
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriComponentsBuilder.path("/account/registration/successfully").build().toUri());

        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/check/email", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public boolean checkEmail(@RequestParam final String email) {
        System.out.println("checkEmail");
        return true;
    }
}
