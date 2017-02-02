/*  */
package pex.atomic;

import pex.Expression;
import pex.Value;
import pex.ExpressionVisitor;

/**
 * Class for describing syntactic tree leaves for holding identifier values.
 */
public class Identifier extends Expression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /** Identifier name. */
  private String _name;

  /** Value **/
  private Value _value;

  /**
   * @param name
   */
  public Identifier(String name) {
    _name = name;
  }

  /**
   * @return the name
   */
  public String getName() {
    return _name;
  }

  /**
   * @return the value
   */
  public Value getValue() {
      return _value;
  }
  public String toString() {
    return _name;
  }

  @Override
  public void accept(ExpressionVisitor visitor) {
    visitor.visitIdentifier(this);
  }
}
