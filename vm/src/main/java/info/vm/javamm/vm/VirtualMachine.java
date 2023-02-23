package info.vm.javamm.vm;

import info.vm.javamm.code.fragment.SourceCode;
import info.vm.javamm.compiler.JavammSyntaxError;
import info.vm.javamm.interpreter.JavammRuntimeError;
import info.vm.javamm.interpreter.TerminateInterpreterException;

public interface VirtualMachine {
    void run(SourceCode... sourceCodes) throws JavammSyntaxError, JavammRuntimeError, TerminateInterpreterException;
}
