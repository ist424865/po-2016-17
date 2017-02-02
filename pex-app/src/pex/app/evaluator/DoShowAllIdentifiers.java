/** @version  */
package pex.app.evaluator;

import pex.Interpreter;
import pex.operators.Program;

/**
 * Show all program identifiers.
 */
public class DoShowAllIdentifiers extends ProgramCommand {

  /**
   * @param interpreter
   * @param receiver
   */
  public DoShowAllIdentifiers(Interpreter interpreter, Program receiver) {
    super(Label.SHOW_ALL_IDENTIFIERS, interpreter, receiver);
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    _display.popup(_receiver.getAllIdentifiers());
  }
}
