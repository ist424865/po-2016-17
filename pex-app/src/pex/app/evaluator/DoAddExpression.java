/** @version  */
package pex.app.evaluator;

import pex.app.BadExpressionException;
import pex.app.BadPositionException;
import pex.operators.Program;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import pex.Interpreter;
import pex.operators.Program;
import pex.Parser;
import pex.ParserException;

/**
 * Add expression.
 */
public class DoAddExpression extends ProgramCommand {
  /** Input field. */
  Input<Integer> _position;

  /** Input field. */
  Input<String> _description;

  /**
   * @param interpreter
   * @param receiver
   */
  public DoAddExpression(Interpreter interpreter, Program receiver) {
    super(Label.ADD_EXPRESSION, interpreter, receiver);
    _position = _form.addIntegerInput(Message.requestPosition());
    _description = _form.addStringInput(Message.requestExpression());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    _form.parse();

    int position = _position.value();

    try {
      if (position < 0 || position > _receiver.size())
        throw new BadPositionException(position);
      _receiver.add(position,_interpreter.parse(_description.value()));
    }
    catch (ParserException e) {
      throw new BadExpressionException(_description.value());
    }
  }
}
