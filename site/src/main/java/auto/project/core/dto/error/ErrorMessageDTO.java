package auto.project.core.dto.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorMessageDTO {
    private int status;

    private int code;

    private String message;
}
