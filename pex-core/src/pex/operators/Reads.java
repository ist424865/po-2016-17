package pex.operators;

import pex.Expression;
import pex.ExpressionVisitor;

public class Reads extends Expression {
    private static final long serialVersionUID = 201608281352L;

    @Override
    public String toString() {
        return "(reads)";
    }

    @Override
    public void accept(ExpressionVisitor visitor) {
        visitor.visitReads(this);
    }
}
