package info.vm.javamm.compiler;

import java.util.Set;
import info.vm.javamm.compiler.component.BlockOperationReader;
import info.vm.javamm.compiler.component.OperationReader;
import info.vm.javamm.compiler.component.SourceLineReader;
import info.vm.javamm.compiler.component.TokenParser;
import info.vm.javamm.compiler.component.impl.BlockOperationReaderImpl;
import info.vm.javamm.compiler.component.impl.CompilerImpl;
import info.vm.javamm.compiler.component.impl.SourceLineReaderImpl;
import info.vm.javamm.compiler.component.impl.TokenParserImpl;
import info.vm.javamm.compiler.component.impl.operation.PrintlnOperationReader;

public class CompilerConfigurator {
    private TokenParser tokenParser = new TokenParserImpl();

    private SourceLineReader sourceLineReader = new SourceLineReaderImpl(tokenParser);

    private Set<OperationReader> operationReaders = Set.of(
        new PrintlnOperationReader()
    );

    private BlockOperationReader blockOperationReader = new BlockOperationReaderImpl(operationReaders);

    private Compiler compiler = new CompilerImpl(sourceLineReader, blockOperationReader);

    public Compiler getCompiler() {
        return compiler;
    }
}
