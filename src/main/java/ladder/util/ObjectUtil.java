package ladder.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

public class ObjectUtil {
    private static final String DEFAULT_NULL_EXCEPTION_MESSAGE = "Some parameter is null";

    private ObjectUtil() {}

    @SafeVarargs
    public static <T> void checkNull(final T... parameters) {
        checkNull(DEFAULT_NULL_EXCEPTION_MESSAGE, parameters);
    }

    public static <T> void checkNull(T parameters, final String exceptionMsg) {
        if(parameters == null) {
            throw new IllegalArgumentException(exceptionMsg);
        }
    }

    @SafeVarargs
    public static <T> void checkNull(final String exceptionMsg, final T... parameters) {
        Arrays.stream(parameters)
                .filter(Objects::isNull)
                .findAny()
                .ifPresent(parameter -> {
                    throw new IllegalArgumentException(exceptionMsg);
                });
    }
}
