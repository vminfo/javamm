package info.vm.javamm.compiler.component;

import info.vm.javamm.compiler.model.TokenParserResult;

/**
 * @author vminfo
 * @link http://vminfo.ru/javamm
 */
public interface TokenParser {

    TokenParserResult parseLine(String line, boolean multilineCommentStarted);
}
