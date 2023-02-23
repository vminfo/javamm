package info.vm.javamm.interpreter.component.impl.operation;

import static java.lang.Thread.currentThread;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import info.vm.javamm.code.fragment.Operation;
import info.vm.javamm.interpreter.TerminateInterpreterException;
import org.junit.jupiter.api.BeforeEach;
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
class AbstractOperationInterpreterUnitTest {

    @Mock
    private Operation operation;

    private AbstractOperationInterpreter<Operation> operationInterpreter;

    @BeforeEach
    void beforeEach() {
        operationInterpreter = spy(new AbstractOperationInterpreter<>() {
            @Override
            protected void interpretOperation(final Operation operation) {

            }

            @Override
            public Class<Operation> getOperationClass() {
                return null;
            }
        });
    }

    @Test
    @Order(1)
    void Should_invoke_interpretOperation_after_checkForTerminate() {
        assertDoesNotThrow(() -> operationInterpreter.interpret(operation));
        verify(operationInterpreter).interpretOperation(operation);
    }

    @Test
    @Order(2)
    void Should_throw_TerminateInterpreterException_if_current_thread_is_interrupted() {
        currentThread().interrupt();

        assertThrows(TerminateInterpreterException.class, () -> operationInterpreter.interpret(operation));
        assertFalse(currentThread().isInterrupted());
        verify(operationInterpreter, never()).interpretOperation(operation);
    }
}