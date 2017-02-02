/*  */
package pex.operators;

import pex.Expression;
import pex.ExpressionVisitor;

/**
 * Class for describing the negation operator
 */
public class Not extends UnaryExpression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /**
   * @param argument
   */
  public Not(Expression argument) {
    super(argument);
  }

  @Override
  public String toString() {
    return "(not " + super.toString();
  }

  @Override
  public void accept(ExpressionVisitor visitor) {
    visitor.visitNot(this);
  }
}
