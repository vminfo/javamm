package info.vm.javamm.interpreter;

import java.util.Set;
import info.vm.javamm.interpreter.component.BlockOperationInterpreter;
import info.vm.javamm.interpreter.component.OperationInterpreter;
import info.vm.javamm.interpreter.component.impl.BlockOperationInterpreterImpl;
import info.vm.javamm.interpreter.component.impl.operation.InterpreterImpl;
import info.vm.javamm.interpreter.component.impl.operation.simple.PrintlnOperationInterpreter;

public class InterpreterConfigurator {

    private Set<OperationInterpreter<?>> operationInterpreters = Set.of(
        new PrintlnOperationInterpreter()
    );

    private BlockOperationInterpreter blockOperationInterpreter =
        new BlockOperationInterpreterImpl(operationInterpreters);

    private Interpreter interpreter = new InterpreterImpl(blockOperationInterpreter);

    public Interpreter getInterpreter() {
        return interpreter;
    }
}
