/*  */
package pex.operators;

import pex.Expression;
import pex.ExpressionVisitor;

/** Class for describing unary operators. */
public abstract class UnaryExpression extends Expression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /** The argument expression. */
  Expression _argument;

  /**
   * @param argument
   */
  public UnaryExpression(Expression argument) {
    _argument = argument;
  }

  /**
   * @return the argument
   */
  public Expression argument() {
    return _argument;
  }

  @Override
  public String toString() {
    return _argument.toString() + ")";
  }

  @Override
  public void accept(ExpressionVisitor visitor) {
    visitor.visitUnaryExpression(this);
  }

}
