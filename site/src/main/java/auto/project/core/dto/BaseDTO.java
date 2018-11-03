package auto.project.core.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@Getter
@EqualsAndHashCode(of = "id", doNotUseGetters = true)
public abstract class BaseDTO implements Serializable {
    private final String id;

    BaseDTO(final Builder builder) {
        this.id = builder.bId;
    }

    @SuppressWarnings("unchecked")
    public abstract static class Builder<T extends Builder> {

        private String bId;

        protected Builder() {
        }

        public T withId(final String id) {
            this.bId = id;
            return (T) this;
        }
    }
}
