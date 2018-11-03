package auto.project.core.exception;

public class ResourceException extends RuntimeException {
    private final int errorCode;

    public ResourceException(final int errorCode, final String msg, final Throwable cause) {
        super(msg, cause);
        this.errorCode = errorCode;
    }

    public ResourceException(final int errorCode, final String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
