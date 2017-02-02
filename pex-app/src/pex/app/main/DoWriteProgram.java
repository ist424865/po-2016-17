/** @version  */
package pex.app.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import pex.Manager;
import pex.operators.Program;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

/**
 * Write (save) program to file.
 */
public class DoWriteProgram extends Command<Manager> {
  /** Input field. */
  Input<String> _programName;
  /** Input field. */
  Input<String> _filename;

  /**
   * @param receiver
   */
  public DoWriteProgram(Manager receiver) {
    super(Label.WRITE_PROGRAM, receiver);
    _programName = _form.addStringInput(Message.requestProgramId());
    _filename = _form.addStringInput(Message.programFileName());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    _form.parse();

    Program program = _receiver.getProgram(_programName.value());
    if (program != null) {
      try {
        _receiver.saveProgram(program,_filename.value());
      }
      catch (IOException e) {
        System.out.println("Erro : " + _filename.value() + " : " + e + "\n");
      }
    }
    else
      _display.popup(Message.noSuchProgram(_programName.value()));
  }

}
