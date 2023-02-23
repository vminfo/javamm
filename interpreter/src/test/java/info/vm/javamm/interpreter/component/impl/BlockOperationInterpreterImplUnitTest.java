package info.vm.javamm.interpreter.component.impl;

import java.util.List;
import java.util.Set;
import static info.vm.javamm.code.fragment.SourceLine.EMPTY_SOURCE_LINE;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import info.vm.javamm.code.exception.ConfigException;
import info.vm.javamm.code.fragment.Operation;
import info.vm.javamm.code.fragment.SourceLine;
import info.vm.javamm.code.fragment.operation.Block;
import info.vm.javamm.interpreter.component.BlockOperationInterpreter;
import info.vm.javamm.interpreter.component.OperationInterpreter;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BlockOperationInterpreterImplUnitTest {
    @Mock
    private OperationInterpreter<TestOperation> operationInterpreter1;

    @Mock
    private OperationInterpreter<TestOperation> operationInterpreter2;

    @Test
    @Order(1)
    void Constructor_should_throw_ConfigException_if_a_duplicate_of_operation_interpreter_is_found() {
        when(operationInterpreter1.getOperationClass()).thenReturn(TestOperation.class);
        when(operationInterpreter2.getOperationClass()).thenReturn(TestOperation.class);
        when(operationInterpreter1.toString()).thenReturn("operationInterpreter");
        when(operationInterpreter2.toString()).thenReturn("operationInterpreter");

        final ConfigException exception = assertThrows(ConfigException.class, () ->
            new BlockOperationInterpreterImpl(Set.of(operationInterpreter1, operationInterpreter2)));
        assertEquals("Duplicate of OperationInterpreter found: " +
            "operation=info.vm.javamm.interpreter.component.impl.BlockOperationInterpreterImplUnitTest" +
            "$TestOperation, " +
            "interpreter1=operationInterpreter, " +
            "interpreter2=operationInterpreter", exception.getMessage());
    }

    @Test
    @Order(2)
    void interpret_should_delegate_the_call_to_appropriate_operation_interpreter() {
        final TestOperation testOperation = new TestOperation();
        when(operationInterpreter1.getOperationClass()).thenReturn(TestOperation.class);
        final BlockOperationInterpreter interpreter = new BlockOperationInterpreterImpl(Set.of(operationInterpreter1));
        final Block block = new Block(List.of(testOperation), EMPTY_SOURCE_LINE);

        assertDoesNotThrow(() -> interpreter.interpret(block));
        verify(operationInterpreter1).interpret(testOperation);
    }

    @Test
    @Order(3)
    void interpret_should_throw_ConfigException_if_operation_is_not_supported() {
        final BlockOperationInterpreter interpreter = new BlockOperationInterpreterImpl(Set.of());
        final Block block = new Block(List.of(new TestOperation()), EMPTY_SOURCE_LINE);

        final ConfigException exception = assertThrows(ConfigException.class, () -> interpreter.interpret(block));
        assertEquals("OperationInterpreter not defined for class " +
                "info.vm.javamm.interpreter.component.impl.BlockOperationInterpreterImplUnitTest$TestOperation",
            exception.getMessage());
    }

    /**
     * @author devonline
     * @link http://devonline.academy/javamm
     */
    private static final class TestOperation implements Operation {

        @Override
        public SourceLine getSourceLine() {
            return EMPTY_SOURCE_LINE;
        }
    }
}