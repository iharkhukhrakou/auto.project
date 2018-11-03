package auto.project.web.controller.rest.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ErrorValidation {
    @JsonProperty("field_errors")
    private List<ErrorField> fieldErrors = new ArrayList();

    public void addFieldError(final String path, final String message) {
        final ErrorField error = new ErrorField(path, message);
        fieldErrors.add(error);
    }
}
