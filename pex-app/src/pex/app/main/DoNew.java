/** @version  */
package pex.app.main;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import pex.Manager;
import pex.app.main.DoSave;

/**
 * Open a new interpreter.
 */
  public class DoNew extends Command<Manager> {
  /** Input field. */
  Input<Boolean> _shouldSave;

  /**
   * @param receiver
   */
  public DoNew(Manager receiver) {
    super(Label.NEW, receiver);
    _shouldSave = _form.addBooleanInput(Message.saveBeforeExit());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    /*_form.parse();*/

    /**
     * If true opens DoSave function to save current Interpreter
     */

    /*if(_shouldSave.value()) {
      DoSave save = new DoSave(_receiver);
      save.execute();
    }*/
    _receiver.newInterpreter();
    _receiver.setHasChanged(true);
  }

}
