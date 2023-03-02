package info.vm.javamm.code.component;

import info.vm.javamm.code.fragment.Expression;
import info.vm.javamm.code.fragment.UpdatableExpression;

public interface ExpressionContext {


    Object getValue(Expression expression);

    void setValue(UpdatableExpression updatableExpression, Object updateValue);
}
 