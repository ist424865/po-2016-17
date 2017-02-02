/*  */
package pex.operators;

import pex.Expression;
import pex.ExpressionVisitor;

/**
 * Class for describing the sum ('+') operator
 */
public class Mod extends BinaryExpression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /**
   * @param first
   * @param second
   */
  public Mod(Expression first, Expression second) {
    super(first, second);
  }

  @Override
  public String toString() {
    return "(mod " + super.toString();
  }

  @Override
  public void accept(ExpressionVisitor visitor) {
    visitor.visitMod(this);
  }
}

