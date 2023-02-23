package info.vm.javamm.code.fragment.operation;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import info.vm.javamm.code.fragment.SourceLine;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AbstractOperationUnitTest {

    @Test
    void toString_should_delegate_the_call_to_the_SourceLine_toString() {
        final SourceLine sourceLine = new SourceLine("module1", 1, List.of("var", "a", "=", "2"));
        assertEquals(sourceLine.toString(), new AbstractOperation(sourceLine) {
        }.toString());
    }
}