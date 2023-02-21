package info.vm.javamm.compiler;

import info.vm.javamm.code.exception.JavammError;

/**
 * @author vminfo
 * @link http://vminfo.ru/javamm
 */
public class JavammSyntaxError extends JavammError {

    protected JavammSyntaxError(final String message) {
        super(message);
    }
}
