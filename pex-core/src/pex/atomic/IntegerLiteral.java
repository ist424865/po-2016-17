/*  */
package pex.atomic;

import pex.Value;
import pex.ExpressionVisitor;


/**
 * Class for describing syntactic tree leaves for holding integer values.
 */
public class IntegerLiteral extends Value<Integer> {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /**
   * @param value
   */
  public IntegerLiteral(int value) {
    super(value);
  }

  @Override
  public void accept(ExpressionVisitor visitor) {
    visitor.visitIntegerLiteral(this);
  }
}
