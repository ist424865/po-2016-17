/** @version  */
package pex.app.evaluator;

import pex.Interpreter;
import pex.operators.Program;

/**
 * Show program (present code).
 */
public class DoShowProgram extends ProgramCommand {

  /**
   * @param interpreter
   * @param receiver
   */
  public DoShowProgram(Interpreter interpreter, Program receiver) {
    super(Label.SHOW_PROGRAM, interpreter, receiver);
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    _display.popup(_receiver.toString());
  }

}
