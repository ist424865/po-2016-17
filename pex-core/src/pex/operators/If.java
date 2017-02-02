package pex.operators;

import pex.Expression;
import pex.ExpressionVisitor;


public class If extends Expression {
    private static final long serialVersionUID = 201608281352L;

    /** First operand. */
    Expression _first;

    /** Second operand. */
    Expression _second;

    /** Third operand. */
    Expression _third;

    /**
     * @param first
     *          first operand
     * @param second
     *          second operand
     */
    public If(Expression first, Expression second, Expression third) {
        _first = first;
        _second = second;
        _third = third;
    }

    /**
     * @return first operand
     */
    public Expression first() {
        return _first;
    }

    /**
     * @return second operand
     */
    public Expression second() {
        return _second;
    }

    /**
     * @return third operand
     */
    public Expression third() {
        return _third;
    }

    @Override
    public String toString() {
        return "(if " + _first + " " + _second + " " + _third + ")";
    }

    @Override
    public void accept(ExpressionVisitor visitor) {
        visitor.visitIf(this);
    }
}


