/** @version  */
package pex.app.evaluator;

import pex.Interpreter;
import pex.app.BadExpressionException;
import pex.app.BadPositionException;
import pex.operators.Program;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import pex.Parser;
import pex.ParserException;

/**
 * Replace expression in program.
 */
public class DoReplaceExpression extends ProgramCommand {
  /** Input field. */
  Input<Integer> _position;

  /** Input field. */
  Input<String> _description;

  /**
   * @param interpreter
   * @param receiver
   */
  public DoReplaceExpression(Interpreter interpreter, Program receiver) {
    super(Label.REPLACE_EXPRESSION, interpreter, receiver);
    _position = _form.addIntegerInput(Message.requestPosition());
    _description = _form.addStringInput(Message.requestExpression());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    _form.parse();

    int position = _position.value();

    try {
      if (position < 0 || position >= _receiver.size())
        throw new BadPositionException(position);
      _receiver.set(position,_interpreter.parse(_description.value()));
    }
    catch (ParserException e) {
      throw new BadExpressionException(_description.value());
    }
  }
}
