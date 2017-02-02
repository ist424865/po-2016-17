package pex;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import pex.ParserException;
import pex.exceptions.BadExpressionException;
import pex.exceptions.BadNumberException;
import pex.exceptions.ExtraneousDataAtEndOfInputException;
import pex.exceptions.MissingClosingParenthesisException;
import pex.exceptions.EndOfInputException;
import pex.exceptions.UnknownOperationException;

import pex.Expression;
import pex.Interpreter;
import pex.Parser;
import pex.operators.Program;

public class Manager {
    /** Parser */
    private Parser _parser = new Parser();

    /** Interpreter */
    private Interpreter _interpreter = new Interpreter();

    /** Interpreter hasChanged flag */
    private boolean _hasChanged = true;

    /**
     * Intepreter related methods
     */

    /** Get Interpreter */
    public Interpreter getInterpreter() { return _interpreter; }

    /** Sets an Interpreter */
    public void setInterpreter(Interpreter interpreter) { _interpreter = interpreter; }

    /** Creates a new Interpreter */
    public void newInterpreter() { _interpreter = new Interpreter(); }

    /** Get Interpreter's name */
    public String getInterpreterName() { return _interpreter.getName(); }

    /** Set Interpreter's name */
    public void setInterpreterName(String name) { _interpreter.setFilename(name); }

    /** Get Interpreter's hasChanged */
    public boolean getHasChanged() { return _hasChanged; }

    /** Set Interpreter's hasChanged */
    public void setHasChanged(boolean hasChanged) { _hasChanged = hasChanged; }

    /** Write a file with an interpreter */
    public void saveInterpreter() throws IOException {

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(_interpreter.getName()));
        out.writeObject(_interpreter);
        out.close();
    }

    /** Load a file, convert to Interpreter type */
    public Interpreter load(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));

        Interpreter _interpreter = (Interpreter) in.readObject();
        in.close();

        return _interpreter;
    }

    /**
     * Program related methods
     */

    /** Get a program from Interpreter */
    public Program getProgram(String programName) {
        return _interpreter.getProgram(programName);
    }

    /** Adds an empty program to the current Interpreter */
    public void newProgram(String programName) { _interpreter.addProgram(programName, new Program()); }

    /** Adds a new program to the current Interpreter */
    public void addProgram(String programName, Program program) { _interpreter.addProgram(programName,program); }

    /** Loads a program from a file */
    public Program openProgram(String filename) throws ExtraneousDataAtEndOfInputException,
            EndOfInputException, MissingClosingParenthesisException, UnknownOperationException,
            BadNumberException, BadExpressionException {
        return _parser.parseProgramFile(filename);
    }

    /** Writes a file with a program */
    public void saveProgram(Program program, String filename) throws IOException {
        try {
            PrintWriter writer = new PrintWriter(filename, "UTF-8");
            writer.print(program.toString());
            writer.close();
        }
        catch (IOException e) {
            System.out.println("Erro : " + filename + " : " + e + "\n");
        }
    }

}