package auto.project.core.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Account extends BaseDTO {
    private final String firstname;
    private final String lastname;
    private final String email;

    private Account(final Builder builder) {
        super(builder);
        this.firstname = builder.bFirstname;
        this.lastname = builder.bLastname;
        this.email = builder.bEmail;
    }


    public static class Builder extends BaseDTO.Builder<Builder> {

        private final String bFirstname;
        private final String bLastname;
        private final String bEmail;

        @JsonCreator
        public Builder(
                @JsonProperty("firstname")
                final String firstname,
                @JsonProperty("lastname")
                final String lastname,
                @JsonProperty("email")
                final String email
        ) {
            this.bFirstname = firstname;
            this.bLastname = lastname;
            this.bEmail = email;
        }

        public Account build() {
            return new Account (this);
        }
    }

}
