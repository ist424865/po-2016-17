/*  */
package pex.operators;

import pex.Expression;
import pex.ExpressionVisitor;

/**
 * Class for describing the sum ('+') operator
 */
public class Lt extends BinaryExpression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /**
   * @param first
   * @param second
   */
  public Lt(Expression first, Expression second) {
    super(first, second);
  }

  @Override
  public String toString() {
    return "(lt " + super.toString();
  }

  @Override
  public void accept(ExpressionVisitor visitor) {
    visitor.visitLt(this);
  }
}

