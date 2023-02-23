package info.vm.javamm.cmd;

import java.io.IOException;
import info.vm.javamm.compiler.JavammSyntaxError;
import info.vm.javamm.interpreter.JavammRuntimeError;
import info.vm.javamm.vm.VirtualMachine;
import info.vm.javamm.vm.VirtualMachineBuilder;

public class JmmVmLauncher {
    public static void main(final String[] args) throws IOException {
        final VirtualMachine virtualMachine = new VirtualMachineBuilder().build();
        try {
            virtualMachine.run(new FileSourceCode("cmd/src/main/resources/test.javamm"));
        } catch (final JavammSyntaxError | JavammRuntimeError e) {
            System.err.println(e.getMessage());
        }
    }
}
