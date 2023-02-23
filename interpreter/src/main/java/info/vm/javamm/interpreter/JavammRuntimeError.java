package info.vm.javamm.interpreter;

import info.vm.javamm.code.exception.JavammError;

public abstract class JavammRuntimeError extends JavammError {

    protected JavammRuntimeError(final String message) {
        super(message);
    }
}
