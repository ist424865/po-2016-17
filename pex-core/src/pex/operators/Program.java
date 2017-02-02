/*  */
package pex.operators;

import pex.Expression;
import pex.atomic.Identifier;
import pex.ExpressionVisitor;
import pex.AllIdentifiersVisitor;
import pex.UninitializedIdentifiersVisitor;

/**
 * Class for describing programs.
 */
public class Program extends Sequence {

    /** Serial number for serialization. */
    private static final long serialVersionUID = 201608281352L;

    /**
     * @see pex.operators.Sequence for more information
     */

    /**
     * Default constructor
     */
    public Program() { super(); }

    /**
     * @return string with all indentifiers in program
     */

    public String getAllIdentifiers() {
        AllIdentifiersVisitor visitor = new AllIdentifiersVisitor();
        accept(visitor);
        return visitor.toString();
    }

    /**
     * @return string with all uninitialized indentifiers in program
     */

    public String getUninitializedIdentifiers() {
        UninitializedIdentifiersVisitor visitor = new UninitializedIdentifiersVisitor();
        accept(visitor);
        return visitor.toString();
    }

    /**
     * @return string
     */
    @Override
    public String toString() {
        String program = "";

        for (Expression expression: _expressions) {
            program += expression.toString() + "\n";
        }
        return program;
    }

    @Override
    public void accept(ExpressionVisitor visitor) {
        visitor.visitProgram(this);
    }
}
