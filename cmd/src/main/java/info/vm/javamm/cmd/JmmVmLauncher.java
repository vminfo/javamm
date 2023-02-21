package info.vm.javamm.cmd;

import java.util.List;
import info.vm.javamm.code.fragment.ByteCode;
import info.vm.javamm.code.fragment.SourceCode;
import info.vm.javamm.compiler.Compiler;
import info.vm.javamm.compiler.CompilerConfigurator;

public class JmmVmLauncher {
    public static void main(final String[] args) {
        final Compiler compiler = new CompilerConfigurator().getCompiler();
        final ByteCode byteCode = compiler.compile(new SourceCode() {
            @Override
            public String getModuleName() {
                return "test";
            }

            @Override
            public List<String> getLines() {
                return List.of(
                    "println ( HelloWorld )",
                    "",
                    "println ( HelloJava )",
                    "println ( VovaFCSM )"
                );
            }
        });
        System.out.println(byteCode.getCode());
    }
}
