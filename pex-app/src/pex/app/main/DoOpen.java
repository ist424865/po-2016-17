/** @version  */
package pex.app.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import pex.Manager;
import pex.Interpreter;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;


/**
 * Open existing interpreter.
 */
public class DoOpen extends Command<Manager> {

  Input<String> _filename;
  /**
   * @param receiver
   */
  public DoOpen(Manager receiver) {
    super(Label.OPEN, receiver);
    _filename = _form.addStringInput(Message.openFile());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    _form.parse();

    try {
      _receiver.setInterpreter(_receiver.load(_filename.value()));
      _receiver.setHasChanged(false);
    }
    catch(ClassNotFoundException e) {}
    catch(IOException e) {
      _display.popup(Message.fileNotFound());//_filename.value()));
    }
  }

}
