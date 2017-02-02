/** @version  */
package pex.app.main;

import pex.Manager;
import pex.ParserException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import pex.app.main.BadFileException;

/**
 * Read existing program.
 */
public class DoReadProgram extends Command<Manager> {
  /**
   * Input field.
   */
  Input<String> _filename;

  /**
   * @param receiver
   */
  public DoReadProgram(Manager receiver) {
    super(Label.READ_PROGRAM, receiver);
    _filename = _form.addStringInput(Message.programFileName());
  }

  /**
   * @see pt.tecnico.po.ui.Command#execute()
   */
  @Override
  public final void execute() throws BadFileException {
    _form.parse();

    try {
      _receiver.addProgram(_filename.value(), _receiver.openProgram(_filename.value()));
      _receiver.setHasChanged(true);
    } catch (ParserException e) {
      throw new BadFileException(_filename.value());
    }
  }

}