package info.vm.javamm.compiler.component.impl;

import java.util.List;
import static java.util.Objects.requireNonNull;
import info.vm.javamm.code.fragment.ByteCode;
import info.vm.javamm.code.fragment.SourceCode;
import info.vm.javamm.code.fragment.SourceLine;
import info.vm.javamm.code.fragment.operation.Block;
import info.vm.javamm.compiler.Compiler;
import info.vm.javamm.compiler.JavammSyntaxError;
import info.vm.javamm.compiler.component.BlockOperationReader;
import info.vm.javamm.compiler.component.SourceLineReader;

public class CompilerImpl implements Compiler {

    private final SourceLineReader sourceLineReader;

    private final BlockOperationReader blockOperationReader;

    public CompilerImpl(final SourceLineReader sourceLineReader,
                        final BlockOperationReader blockOperationReader) {
        this.sourceLineReader = requireNonNull(sourceLineReader);
        this.blockOperationReader = requireNonNull(blockOperationReader);
    }

    @Override
    public ByteCode compile(final SourceCode... sourceCodes) throws JavammSyntaxError {
        final List<SourceLine> sourceLines = sourceLineReader.read(sourceCodes[0]);
        final Block block = blockOperationReader.read(SourceLine.EMPTY_SOURCE_LINE, sourceLines.listIterator());
        return () -> block;
    }
}
