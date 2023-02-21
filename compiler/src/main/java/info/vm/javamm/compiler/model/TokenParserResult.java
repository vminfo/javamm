package info.vm.javamm.compiler.model;

import java.util.List;

/**
 * @author vminfo
 * @link http://vminfo.ru/javamm
 */
public class TokenParserResult {

    private final List<String> tokens;

    private final boolean multilineCommentStarted;

    public TokenParserResult(final List<String> tokens, final boolean multilineCommentStarter) {
        this.tokens = List.copyOf(tokens);
        this.multilineCommentStarted = multilineCommentStarter;
    }

    public TokenParserResult(final boolean multilineCommentStarter) {
        this(List.of(), multilineCommentStarter);
    }

    public List<String> getTokens() {
        return tokens;
    }

    public boolean isMultilineCommentStarted() {
        return multilineCommentStarted;
    }

    public boolean isNotEmpty() {
        return !tokens.isEmpty();
    }
}
