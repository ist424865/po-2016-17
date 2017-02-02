/*  */
package pex.atomic;

import pex.Value;
import pex.ExpressionVisitor;


/**
 * Class for describing syntactic tree leaves for holding string values.
 */
public class StringLiteral extends Value<String> {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /**
   * @param value
   */
  public StringLiteral(String value) {
    super(value);
  }

  public String toString() {
    return "\"" + super.toString() + "\"";
  }

  @Override
  public void accept(ExpressionVisitor visitor) {
    visitor.visitStringLiteral(this);
  }
}
