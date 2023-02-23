package info.vm.javamm.interpreter;

public final class TerminateInterpreterException extends RuntimeException {

    public TerminateInterpreterException() {
        super(null, null, true, false);
    }
}
