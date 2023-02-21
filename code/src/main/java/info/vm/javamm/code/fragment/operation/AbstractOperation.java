package info.vm.javamm.code.fragment.operation;

import static java.util.Objects.requireNonNull;
import info.vm.javamm.code.fragment.Operation;
import info.vm.javamm.code.fragment.SourceLine;

/**
 * @author vminfo
 * @link http://vminfo.ru/javamm
 */

public abstract class AbstractOperation implements Operation {

    private final SourceLine sourceLine;

    public AbstractOperation(final SourceLine sourceLine) {
        this.sourceLine = requireNonNull(sourceLine);
    }

    @Override
    public final SourceLine getSourceLine() {
        return sourceLine;
    }

    @Override
    public String toString() {
        return sourceLine.toString();
    }
}
