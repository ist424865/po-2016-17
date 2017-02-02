/*  */
package pex.operators;

import pex.Expression;
import pex.ExpressionVisitor;

/**
 * Class for describing the sum ('+') operator
 */
public class While extends Expression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /**
   * @param first
   * @param second
   */

  /** First operand. */
  Expression _condition;

  /** Second operand. */
  Expression _expression;

  public While(Expression first, Expression second) {
    _condition = first;
    _expression = second;
  }

  /**
   * @return condition
   */
  public Expression condition() {
    return _condition;
  }

  /**
   * @return second operand
   */
  public Expression expression() {
    return _expression;
  }

  @Override
  public String toString() {
    return "(while " + _condition + " " + _expression + ")";
  }

  @Override
  public void accept(ExpressionVisitor visitor) {
    visitor.visitWhile(this);
  }
}
