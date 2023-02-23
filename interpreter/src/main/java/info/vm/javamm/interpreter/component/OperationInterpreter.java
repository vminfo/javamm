package info.vm.javamm.interpreter.component;

import info.vm.javamm.code.fragment.Operation;

public interface OperationInterpreter<T extends Operation> {

    Class<T> getOperationClass();

    void interpret(T operation);
}
