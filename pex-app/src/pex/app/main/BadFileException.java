package pex.app.main;

import pt.tecnico.po.ui.DialogException;

@SuppressWarnings("nls")
public class BadFileException extends DialogException {

    /** Serial number for serialization. */
    private static final long serialVersionUID = 201608241029L;

    /** Original leaf expression. */
    String _filename;

    /**
     * @param description
     */
    public BadFileException(String filename) {
        _filename = filename;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return _filename;
    }

    /** @see pt.tecnico.po.ui.DialogException#getMessage() */
    @Override
    public String getMessage() {
        return "Ficheiro inválido: " + _filename;
    }

}