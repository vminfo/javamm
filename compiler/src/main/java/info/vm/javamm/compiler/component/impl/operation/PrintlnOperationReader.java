package info.vm.javamm.compiler.component.impl.operation;

import java.util.ListIterator;
import java.util.Optional;
import info.vm.javamm.code.fragment.SourceLine;
import info.vm.javamm.code.fragment.operation.PrintlnOperation;
import info.vm.javamm.compiler.component.OperationReader;
import info.vm.javamm.compiler.component.impl.AbstractOperationReader;
import info.vm.javamm.compiler.component.impl.error.JavammLineSyntaxError;

public class PrintlnOperationReader extends AbstractOperationReader<PrintlnOperation> implements OperationReader {

    @Override
    protected Optional<String> getOperationKeyword() {
        return Optional.of("println");
    }

    @Override
    protected void validate(final SourceLine sourceLine) {
        if (!")".equals(sourceLine.getLast())) {
            throw new JavammLineSyntaxError("Expected ) at the end of line", sourceLine);
        }
        if (!"(".equals(sourceLine.getToken(1))) {
            throw new JavammLineSyntaxError("Expected ( after 'println'", sourceLine);
        }
    }

    @Override
    // println (1)(
    protected PrintlnOperation get(final SourceLine sourceLine, final ListIterator<SourceLine> iterator) {
        final String text = sourceLine.getToken(2);
        return new PrintlnOperation(sourceLine, text);
    }
}
