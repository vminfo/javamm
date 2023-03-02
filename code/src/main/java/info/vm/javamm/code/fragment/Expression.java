package info.vm.javamm.code.fragment;


import info.vm.javamm.code.component.ExpressionContext;

public interface Expression {

    default Object getValue(final ExpressionContext expressionContext) {
        return expressionContext.getValue(this);
    }
}
