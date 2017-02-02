package pex.operators;

import pex.Expression;
import pex.ExpressionVisitor;

public class Readi extends Expression {
    private static final long serialVersionUID = 201608281352L;

    @Override
    public String toString() {
        return "(readi)";
    }

    @Override
    public void accept(ExpressionVisitor visitor) {
        visitor.visitReadi(this);
    }
}
