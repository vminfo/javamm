package info.vm.javamm.code.fragment.operation;

import static java.util.Objects.requireNonNull;
import info.vm.javamm.code.fragment.Operation;
import info.vm.javamm.code.fragment.SourceLine;

/**
 * @author vminfo
 * @link http://vminfo.ru/javamm
 */
public final class PrintlnOperation extends AbstractOperation implements Operation {


    private final String text;

    public PrintlnOperation(final SourceLine sourceLine, final String text) {
        super(sourceLine);
        this.text = requireNonNull(text);
    }

    public String getText() {
        return text;
    }
}
