package info.vm.javamm.compiler.component.impl;

import java.util.ListIterator;
import java.util.Optional;
import info.vm.javamm.code.fragment.Operation;
import info.vm.javamm.code.fragment.SourceLine;
import info.vm.javamm.compiler.component.OperationReader;

public abstract class AbstractOperationReader<T extends Operation> implements OperationReader {

    @Override
    public boolean canRead(final SourceLine sourceLine) {
        final Optional<String> keywordOptional = getOperationKeyword();
        return keywordOptional.isPresent() && keywordOptional.get().equals(sourceLine.getFirst());
    }

    protected Optional<String> getOperationKeyword() {
        return Optional.empty();
    }

    @Override
    public final T read(final SourceLine sourceLine, final ListIterator<SourceLine> iterator) {
        validate(sourceLine);
        return get(sourceLine, iterator);
    }

    protected void validate(final SourceLine sourceLine) {
        // do nothing
    }

    protected abstract T get(SourceLine sourceLine, ListIterator<SourceLine> iterator);
}
