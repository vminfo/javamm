package info.vm.javamm.code.fragment;

import info.vm.javamm.code.component.ExpressionContext;

public interface UpdatableExpression {

    default void setValue(final ExpressionContext expressionContext, final Object updateValue) {
        expressionContext.setValue(this, updateValue);
    }
}
