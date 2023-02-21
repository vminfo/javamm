package info.vm.javamm.compiler.component;

import java.util.List;
import info.vm.javamm.code.fragment.SourceCode;
import info.vm.javamm.code.fragment.SourceLine;

/**
 * @author vminfo
 * @link http://vminfo.ru/javamm
 */
public interface SourceLineReader {

    List<SourceLine> read(SourceCode sourceCode);

}
