package info.vm.javamm.interpreter.component.impl.operation;

import static java.util.Objects.requireNonNull;
import info.vm.javamm.code.fragment.ByteCode;
import info.vm.javamm.interpreter.Interpreter;
import info.vm.javamm.interpreter.JavammRuntimeError;
import info.vm.javamm.interpreter.TerminateInterpreterException;
import info.vm.javamm.interpreter.component.BlockOperationInterpreter;

public class InterpreterImpl implements Interpreter {

    private final BlockOperationInterpreter blockOperationInterpreter;

    public InterpreterImpl(final BlockOperationInterpreter blockOperationInterpreter) {
        this.blockOperationInterpreter = requireNonNull(blockOperationInterpreter);
    }

    @Override
    public void interpret(final ByteCode byteCode) throws JavammRuntimeError, TerminateInterpreterException {
        blockOperationInterpreter.interpret(byteCode.getCode());
    }
}
