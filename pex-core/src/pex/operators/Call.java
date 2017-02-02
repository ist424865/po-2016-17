package pex.operators;

import pex.Expression;
import pex.atomic.StringLiteral;
import pex.ExpressionVisitor;

public class Call extends UnaryExpression {

    /** Serial number for serialization. */
    private static final long serialVersionUID = 201608281352L;

    /**
     * @param argument
     */

    public Call(Expression argument) { super(argument); }

    @Override
    public String toString() {
        return "(call " + _argument + ")";
    }

    @Override
    public void accept(ExpressionVisitor visitor) {
        visitor.visitCall(this);
    }
}
