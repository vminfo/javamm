package info.vm.javamm.compiler.component;

import java.util.ListIterator;
import info.vm.javamm.code.fragment.Operation;
import info.vm.javamm.code.fragment.SourceLine;

public interface OperationReader {

    boolean canRead(SourceLine sourceLine);

    Operation read(SourceLine sourceLine, ListIterator<SourceLine> iterator);
}
