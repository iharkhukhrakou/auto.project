package auto.project.core.exception;

import java.net.HttpURLConnection;

public class ResourceNotFoundException extends ResourceException {
    public ResourceNotFoundException(final String message, final Throwable cause) {
        super(HttpURLConnection.HTTP_NOT_FOUND, message, cause);
    }

    public ResourceNotFoundException(final String message) {
        super(HttpURLConnection.HTTP_NOT_FOUND, message);
    }
}
