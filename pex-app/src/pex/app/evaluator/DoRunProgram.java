/** @version  */
package pex.app.evaluator;

import pex.Interpreter;
import pex.operators.Program;
import pex.app.BadExpressionException;
import pex.app.RunVisitor;
import java.lang.RuntimeException;

/**
 * Run program.
 */
public class DoRunProgram extends ProgramCommand {
  
  /**
   * @param interpreter 
   * @param receiver
   */
  public DoRunProgram(Interpreter interpreter, Program receiver) {
    super(Label.RUN_PROGRAM, interpreter, receiver);
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws BadExpressionException {
      RunVisitor visitor = new RunVisitor(_interpreter);
      try {
          _receiver.accept(visitor);
      }
      catch (RuntimeException e) {
          /** Interrompe a execução do programa */
      }
  }
  
}
