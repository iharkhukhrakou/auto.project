package auto.project.core.exception;

import java.net.HttpURLConnection;

public class ResourceConflictException extends ResourceException {
    public ResourceConflictException(final String message, final Throwable cause) {
        super(HttpURLConnection.HTTP_CONFLICT, message, cause);
    }

    public ResourceConflictException(final String message) {
        super(HttpURLConnection.HTTP_CONFLICT, message);
    }
}
