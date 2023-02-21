package info.vm.javamm.code.exception;

import static java.util.Objects.requireNonNull;

/**
 * @author vminfo
 * @link http://vminfo.ru/javamm
 */
public abstract class JavammError extends RuntimeException {

    protected JavammError(final String message) {
        super(requireNonNull(message), null, false, false);
    }

}
