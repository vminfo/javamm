package info.vm.javamm.interpreter.component.impl.operation;

import info.vm.javamm.code.fragment.Operation;
import info.vm.javamm.interpreter.TerminateInterpreterException;
import info.vm.javamm.interpreter.component.OperationInterpreter;

public abstract class AbstractOperationInterpreter<T extends Operation> implements OperationInterpreter<T> {

    @Override
    public final void interpret(final T operation) {
        checkForTerminate();
        interpretOperation(operation);
    }

    protected final void checkForTerminate() {
        if (Thread.interrupted()) {
            throw new TerminateInterpreterException();
        }
    }

    protected abstract void interpretOperation(T operation);
}
