package info.vm.javamm.code.fragment.operation;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import info.vm.javamm.code.fragment.Operation;
import info.vm.javamm.code.fragment.SourceLine;


/**
 * @author vminfo
 * @link http://vminfo.ru/javamm
 */
public class Block extends AbstractOperation implements Operation {

    private final List<Operation> operations;

    public Block(final List<Operation> operations, final SourceLine sourceLine) {
        super(sourceLine);
        this.operations = operations;
    }

    public Block(final Operation operation, final SourceLine sourceLine) {
        this(List.of(operation), sourceLine);
    }

    public List<Operation> getOperations() {
        return operations;
    }

    @Override
    public String toString() {
        return operations.stream().map(Objects::toString).collect(Collectors.joining(System.lineSeparator()));
    }
}
