/** @version  */
package pex.app.main;

import java.io.IOException;

import pex.Manager;
import pex.Interpreter;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

/**
 * Save to file under current name (if unnamed, query for name).
 */
public class DoSave extends Command<Manager> {
  /** Input field. */
  Input<String> _filename;
  
  /**
   * @param receiver
   */
  public DoSave(Manager receiver) {
    super(Label.SAVE, receiver);
    _filename = _form.addStringInput(Message.newSaveAs());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {

    if (_receiver.getHasChanged()) {
      /** Asks for filename if Interpreter is not associated with one */
      if (_receiver.getInterpreterName() == "") {
        _form.parse();
        _receiver.setInterpreterName(_filename.value());
      }
      _receiver.setHasChanged(false);

      try {
        _receiver.saveInterpreter();
      }
      catch (IOException e) {
        System.out.println("Erro : " + _receiver.getInterpreterName() + " : " + e + "\n");
      }
    }
  }

}
