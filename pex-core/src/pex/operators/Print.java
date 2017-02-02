package pex.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pex.ExpressionVisitor;

import pex.Expression;

public class Print extends Sequence {

    /** Serial number for serialization. */
    private static final long serialVersionUID = 201608281352L;

    /**
     * Default constructor (empty sequence).
     */
    public Print() {
        super();
    }

    /**
     * Constructor for single-expression print.
     *
     * @param expression
     */
    public Print(Expression expression) {
        super(expression);
    }

    /**
     * Constructor for appending expressions to print.
     *
     * @param previous
     * @param expression
     */
    public Print(Print previous, Expression expression) {
        super(previous,expression);
    }

    /**
     * @param expressions
     */
    public Print(List<Expression> expressions) {
        super(expressions);
    }

    /**
     * @return string
     */
    @Override
    public String toString() {
        String print = "(print";

        for (Expression expression: _expressions) {
            print += " " + expression;
        }
        print += ")";
        return print;
    }

    @Override
    public void accept(ExpressionVisitor visitor) {
        visitor.visitPrint(this);
    }
}