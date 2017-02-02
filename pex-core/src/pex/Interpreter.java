package pex;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import pex.operators.Program;
import pex.Parser;
import pex.Expression;
import pex.ParserException;


public class Interpreter implements Serializable {

    /** Serial number for serialization. */
    private static final long serialVersionUID = 201608281352L;

    /** Parser */
    private Parser _parser = new Parser();

    /** Interpreter filename */
    private String _filename;

    /** HashMap with programs */
    private HashMap<String, Program> _programs = new HashMap<String, Program>();

    /** Constructor */
    public Interpreter() {
        _filename = "";
    }

    /** Get Interpreter filename */
    public String getName() { return _filename; }

    /** Set filename of interpreter */
    public void setFilename(String filename) { _filename = filename; }

    /** Get a program from Interpreter, return null if does not exist */
    public Program getProgram(String programName) {
        return _programs.get(programName);
    }

    /** Add a program to Interpreter */
    public void addProgram(String programName, Program program) { _programs.put(programName,program); }

    /** Parse something */
    public Expression parse(String description) throws ParserException {
        return _parser.parse(description);
    }
}