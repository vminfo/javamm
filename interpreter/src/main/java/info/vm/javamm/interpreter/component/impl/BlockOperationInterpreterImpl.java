package info.vm.javamm.interpreter.component.impl;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import static java.lang.String.format;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toUnmodifiableMap;
import info.vm.javamm.code.exception.ConfigException;
import info.vm.javamm.code.fragment.Operation;
import info.vm.javamm.code.fragment.operation.Block;
import info.vm.javamm.interpreter.component.BlockOperationInterpreter;
import info.vm.javamm.interpreter.component.OperationInterpreter;

public class BlockOperationInterpreterImpl implements BlockOperationInterpreter {

    private final Map<Class<? extends Operation>, OperationInterpreter> operationInterpreterMap;

    public BlockOperationInterpreterImpl(final Set<OperationInterpreter<?>> operationInterpreters) {
        this.operationInterpreterMap = buildOperationInterpreterMap(operationInterpreters);
    }

    private Map<Class<? extends Operation>, OperationInterpreter> buildOperationInterpreterMap(
        final Collection<OperationInterpreter<?>> operationInterpreters) {
        return operationInterpreters.stream()
            .collect(toUnmodifiableMap(OperationInterpreter::getOperationClass, identity(), checkDuplicates()));
    }

    //Functional
    private BinaryOperator<OperationInterpreter> checkDuplicates() {
        return (oi1, oi2) -> {
            throw new ConfigException(format(
                "Duplicate of OperationInterpreter found: operation=%s, interpreter1=%s, interpreter2=%s",
                oi1.getOperationClass().getName(), oi1, oi2));
        };
    }

    @Override
    @SuppressWarnings("unchecked")
    public void interpret(final Block block) {
        for (final Operation operation : block.getOperations()) {
            final OperationInterpreter operationInterpreter = operationInterpreterMap.get(operation.getClass());
            if (operationInterpreter != null) {
                operationInterpreter.interpret(operation);
            } else {
                throw new ConfigException("OperationInterpreter not defined for " + operation.getClass());
            }
        }
    }
}
