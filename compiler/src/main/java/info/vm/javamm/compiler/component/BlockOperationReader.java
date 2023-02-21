package info.vm.javamm.compiler.component;

import java.util.ListIterator;
import info.vm.javamm.code.fragment.SourceLine;
import info.vm.javamm.code.fragment.operation.Block;

public interface BlockOperationReader {

    Block read(SourceLine sourceLine, ListIterator<SourceLine> iterator);
}
