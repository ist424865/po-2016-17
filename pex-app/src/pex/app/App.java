/** @version  */
package pex.app;

import static pt.tecnico.po.ui.Dialog.IO;

import pex.operators.Program;
import pex.Manager;
import pex.Parser;
import pex.Interpreter;
import pex.ParserException;
import pex.app.main.MainMenu;
import pt.tecnico.po.ui.Menu;

/**
 * This is a sample client for the expression evaluator.
 * It uses a text-based user interface.
 */
public class App {
  /**
   * @param args
   */
  public static void main(String[] args) {
    Manager _manager = new Manager();

    String datafile = System.getProperty("import"); //$NON-NLS-1$
    if (datafile != null) {
      try {
          _manager.addProgram("import",_manager.openProgram(datafile));
      } catch (ParserException e) {
          // e.printStackTrace();
          System.out.println("Erro : " + datafile + " : " + e + "\n");
      }
    }

    Menu menu = new MainMenu(_manager);
    menu.open();
    
    IO.close();
  }
}
