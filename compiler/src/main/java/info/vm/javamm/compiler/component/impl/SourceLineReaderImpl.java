package info.vm.javamm.compiler.component.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import info.vm.javamm.code.fragment.SourceCode;
import info.vm.javamm.code.fragment.SourceLine;
import info.vm.javamm.compiler.component.SourceLineReader;
import info.vm.javamm.compiler.component.TokenParser;
import info.vm.javamm.compiler.model.TokenParserResult;

public class SourceLineReaderImpl implements SourceLineReader {

    private final TokenParser tokenParser;

    public SourceLineReaderImpl(final TokenParser tokenParser) {
        this.tokenParser = requireNonNull(tokenParser);
    }

    @Override
    public List<SourceLine> read(final SourceCode sourceCode) {
        final List<SourceLine> list = new ArrayList<>();
        final String moduleName = sourceCode.getModuleName();
        int number = 1;
        boolean multilineCommentStarted = false;
        for (final String line : sourceCode.getLines()) {
            final TokenParserResult tokenParserResult = tokenParser.parseLine(line, multilineCommentStarted);
            if (tokenParserResult.isNotEmpty()) {
                list.add(new SourceLine(moduleName, number, tokenParserResult.getTokens()));
            }
            multilineCommentStarted = tokenParserResult.isMultilineCommentStarted();
            number++;
        }
        return Collections.unmodifiableList(list);
    }
}
