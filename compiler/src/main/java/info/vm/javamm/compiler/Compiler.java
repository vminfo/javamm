package info.vm.javamm.compiler;

import info.vm.javamm.code.fragment.ByteCode;
import info.vm.javamm.code.fragment.SourceCode;

/**
 * @author vminfo
 * @link http://vminfo.ru/javamm
 */
public interface Compiler {

    ByteCode compile(SourceCode... sourceCodes) throws JavammSyntaxError;

}
