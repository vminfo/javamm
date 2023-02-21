package info.vm.javamm.compiler.component.impl;

import info.vm.javamm.compiler.component.TokenParser;
import info.vm.javamm.compiler.model.TokenParserResult;

import java.util.List;

public class TokenParserImpl implements TokenParser {

    @Override
    public TokenParserResult parseLine(final String line,
                                       final boolean multilineCommentStarted) {
        final List<String> tokens = line.isEmpty() ? List.of() : List.of(line.trim().split(" "));
        return new TokenParserResult(tokens, false);
    }
}