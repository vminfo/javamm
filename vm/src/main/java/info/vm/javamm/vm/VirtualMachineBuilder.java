package info.vm.javamm.vm;

import static java.util.Objects.requireNonNull;
import info.vm.javamm.code.fragment.ByteCode;
import info.vm.javamm.code.fragment.SourceCode;
import info.vm.javamm.compiler.Compiler;
import info.vm.javamm.compiler.CompilerConfigurator;
import info.vm.javamm.compiler.JavammSyntaxError;
import info.vm.javamm.interpreter.Interpreter;
import info.vm.javamm.interpreter.InterpreterConfigurator;
import info.vm.javamm.interpreter.JavammRuntimeError;
import info.vm.javamm.interpreter.TerminateInterpreterException;

public class VirtualMachineBuilder {

    protected CompilerConfigurator buildCompilerConfigurator() {
        return new CompilerConfigurator();
    }

    protected InterpreterConfigurator buildInterpreterConfigurator() {
        return new InterpreterConfigurator();
    }

    public final VirtualMachine build() {
        return new VirtualMachineImpl(
            buildCompilerConfigurator().getCompiler(),
            buildInterpreterConfigurator().getInterpreter());
    }

    private static final class VirtualMachineImpl implements VirtualMachine {

        private final Compiler compiler;

        private final Interpreter interpreter;

        private VirtualMachineImpl(final Compiler compiler, final Interpreter interpreter) {
            this.compiler = requireNonNull(compiler);
            this.interpreter = requireNonNull(interpreter);
        }

        @Override
        public void run(final SourceCode... sourceCodes)
            throws JavammSyntaxError, JavammRuntimeError, TerminateInterpreterException {
            final ByteCode byteCode = compiler.compile(sourceCodes);
            interpreter.interpret(byteCode);
        }
    }
}
