package info.vm.javamm.interpreter.component.impl.operation.simple;

import info.vm.javamm.code.fragment.operation.PrintlnOperation;
import info.vm.javamm.interpreter.component.impl.operation.AbstractOperationInterpreter;

public final class PrintlnOperationInterpreter extends AbstractOperationInterpreter<PrintlnOperation> {

    @Override
    public Class<PrintlnOperation> getOperationClass() {
        return PrintlnOperation.class;
    }

    @Override
    protected void interpretOperation(final PrintlnOperation operation) {
        System.out.println(operation.getText());
    }
}
