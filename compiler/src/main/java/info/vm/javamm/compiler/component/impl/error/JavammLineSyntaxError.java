package info.vm.javamm.compiler.component.impl.error;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import info.vm.javamm.code.fragment.SourceLine;
import info.vm.javamm.compiler.JavammSyntaxError;

public final class JavammLineSyntaxError extends JavammSyntaxError {

    public JavammLineSyntaxError(final String message,
                                 final SourceLine sourceLine) {
        super(format("Syntax error in '%s' [Line: %s]: %s",
            sourceLine.getModuleName(), sourceLine.getNumber(), requireNonNull(message)));
    }
}
