package info.vm.javamm.compiler.component.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Set;
import info.vm.javamm.code.fragment.Operation;
import info.vm.javamm.code.fragment.SourceLine;
import info.vm.javamm.code.fragment.operation.Block;
import info.vm.javamm.compiler.component.BlockOperationReader;
import info.vm.javamm.compiler.component.OperationReader;
import info.vm.javamm.compiler.component.impl.error.JavammLineSyntaxError;

public final class BlockOperationReaderImpl implements BlockOperationReader {

    private final Collection<OperationReader> operationReaders;

    public BlockOperationReaderImpl(final Set<OperationReader> operationReaders) {
        this.operationReaders = List.copyOf(operationReaders);
    }

    @Override
    public Block read(final SourceLine sourceLine, final ListIterator<SourceLine> iterator) {
        final List<Operation> operations = new ArrayList<>();
        readBlockOperations(operations, iterator);
        return new Block(operations, sourceLine);
    }

    private void readBlockOperations(final List<Operation> operations, final ListIterator<SourceLine> iterator) {
        while (iterator.hasNext()) {
            final SourceLine sourceLine = iterator.next();
            final Optional<OperationReader> optionalOperationReader = findOperationReader(sourceLine);
            if (optionalOperationReader.isPresent()) {
                operations.add(optionalOperationReader.get().read(sourceLine, iterator));
            } else {
                throw new JavammLineSyntaxError("Unsupported operation: " + sourceLine.getCommand(), sourceLine);
            }
        }
    }

    private Optional<OperationReader> findOperationReader(final SourceLine sourceLine) {
        for (final OperationReader operationReader : operationReaders) {
            if (operationReader.canRead(sourceLine)) {
                return Optional.of(operationReader);
            }
        }
        return Optional.empty();
    }
}
