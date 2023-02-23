package info.vm.javamm.interpreter;

import info.vm.javamm.code.fragment.ByteCode;

public interface Interpreter {
    void interpret(ByteCode byteCode) throws JavammRuntimeError, TerminateInterpreterException;
}
