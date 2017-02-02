package pex.app;
import pex.Expression;
import pex.ExpressionVisitor;
import pex.operators.*;
import pex.atomic.*;
import pex.Value;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.RuntimeException;
import pt.tecnico.po.ui.Display;
import java.util.HashMap;
import pex.Interpreter;
import pt.tecnico.po.ui.Form;
import pt.tecnico.po.ui.Input;

public class RunVisitor implements ExpressionVisitor {

    private Display _display = new Display();
    private Form _form = new Form(), _formInt = new Form(), _formStr = new Form();
    private HashMap<String,Value> _identifiers = new HashMap<String,Value>();

    private Value _valueCurrent;
    private Identifier _identifier;

    private Input<Integer> _descriptionInt = _formInt.addIntegerInput("");
    private Input<String> _descriptionStr = _formStr.addStringInput("");

    private Interpreter _interpreter;

    public RunVisitor(Interpreter interpreter) {
        _interpreter = interpreter;
    }

    public void visitUnaryExpression(UnaryExpression expression) {}
    public void visitBinaryExpression(BinaryExpression expression) {}
    public void visitWhile(While expression) {
        int _currentInt;
        try {
            expression.condition().accept(this);
            IntegerLiteral integer = (IntegerLiteral) _valueCurrent;
            while (integer.getValue() != 0) {
                expression.expression().accept(this);
                expression.condition().accept(this);
                integer = (IntegerLiteral) _valueCurrent;
            }
            _valueCurrent = new IntegerLiteral(0);
        }
        catch(RuntimeException e) {
            _display.popup("Erro nos valores da expressão: " + expression);
            throw e;
        }
    }
    public void visitSequence(Sequence expression) {
        for (Expression e: expression.getAll()) {
            e.accept(this);
        }
        if (expression.size() == 0)
            _valueCurrent = new IntegerLiteral(0);
    }
    public void visitIdentifier(Identifier expression) {
        _identifier = expression;
        if ((_valueCurrent = _identifiers.get(expression.getName())) == null)
            _valueCurrent = new IntegerLiteral(0);

    }
    public void visitIntegerLiteral(IntegerLiteral expression) {
        _valueCurrent = expression;
    }
    public void visitStringLiteral(StringLiteral expression) { _valueCurrent = expression; }
    public void visitAdd(Add expression) {
        int _currentInt;
        try {
            expression.first().accept(this);
            IntegerLiteral integer = (IntegerLiteral) _valueCurrent;
            _currentInt = integer.getValue();
            expression.second().accept(this);
            integer = (IntegerLiteral) _valueCurrent;
            _currentInt += integer.getValue();
            _valueCurrent = new IntegerLiteral(_currentInt);
        }
        catch(RuntimeException e) {
            _display.popup("Erro nos valores da expressão: " + expression);
            throw e;
        }
    }
    public void visitAnd(And expression) {
        int _currentInt;
        try {
            expression.first().accept(this);
            IntegerLiteral integer = (IntegerLiteral) _valueCurrent;
            _currentInt = integer.getValue();
            if (_currentInt == 0)
                return ;
            expression.second().accept(this);
            integer = (IntegerLiteral) _valueCurrent;
            _currentInt *= integer.getValue();
            _valueCurrent = new IntegerLiteral(_currentInt);
        }
        catch(RuntimeException e) {
            _display.popup("Erro nos valores da expressão: " + expression);
            throw e;
        }
    }
    public void visitCall(Call expression) {
        try {
            expression.argument().accept(this);
            StringLiteral string = (StringLiteral) _valueCurrent;
            visitProgram(_interpreter.getProgram(string.getValue()));
        }
        catch(RuntimeException e) {
            _display.popup("Erro nos valores da expressão: " + expression);
            throw e;
        }
    }
    public void visitDiv(Div expression) {
        int _currentInt;
        try {
            expression.first().accept(this);
            IntegerLiteral integer = (IntegerLiteral) _valueCurrent;
            _currentInt = integer.getValue();
            expression.second().accept(this);
            integer = (IntegerLiteral) _valueCurrent;
            _currentInt /= integer.getValue();
            _valueCurrent = new IntegerLiteral(_currentInt);
        }
        catch(RuntimeException e) {
            _display.popup("Erro nos valores da expressão: " + expression);
            throw e;
        }
    }
    public void visitEq(Eq expression) {
        int _currentInt;
        try {
            expression.first().accept(this);
            IntegerLiteral integer = (IntegerLiteral) _valueCurrent;
            _currentInt = integer.getValue();
            expression.second().accept(this);
            integer = (IntegerLiteral) _valueCurrent;
            if (_currentInt == integer.getValue())
                _currentInt = 1;
            else
                _currentInt = 0;
            _valueCurrent = new IntegerLiteral(_currentInt);
        }
        catch(RuntimeException e) {
            _display.popup("Erro nos valores da expressão: " + expression);
            throw e;
        }
    }
    public void visitGe(Ge expression) {
        int _currentInt;
        try {
            expression.first().accept(this);
            IntegerLiteral integer = (IntegerLiteral) _valueCurrent;
            _currentInt = integer.getValue();
            expression.second().accept(this);
            integer = (IntegerLiteral) _valueCurrent;
            if (_currentInt >= integer.getValue())
                _currentInt = 1;
            else
                _currentInt = 0;
            _valueCurrent = new IntegerLiteral(_currentInt);
        }
        catch(RuntimeException e) {
            _display.popup("Erro nos valores da expressão: " + expression);
            throw e;
        }
    }
    public void visitGt(Gt expression) {
        int _currentInt;
        try {
            expression.first().accept(this);
            IntegerLiteral integer = (IntegerLiteral) _valueCurrent;
            _currentInt = integer.getValue();
            expression.second().accept(this);
            integer = (IntegerLiteral) _valueCurrent;
            if (_currentInt > integer.getValue())
                _currentInt = 1;
            else
                _currentInt = 0;
            _valueCurrent = new IntegerLiteral(_currentInt);
        }
        catch(RuntimeException e) {
            _display.popup("Erro nos valores da expressão: " + expression);
            throw e;
        }
    }
    public void visitIf(If expression) {
        try {
            expression.first().accept(this);
            IntegerLiteral integer = (IntegerLiteral) _valueCurrent;
            if (integer.getValue() != 0)
                expression.second().accept(this);
            else
                expression.third().accept(this);
        }
        catch(RuntimeException e) {
            _display.popup("Erro nos valores da expressão: " + expression);
            throw e;
        }
    }
    public void visitLe(Le expression) {
        int _currentInt;
        try {
            expression.first().accept(this);
            IntegerLiteral integer = (IntegerLiteral) _valueCurrent;
            _currentInt = integer.getValue();
            expression.second().accept(this);
            integer = (IntegerLiteral) _valueCurrent;
            if (_currentInt <= integer.getValue())
                _currentInt = 1;
            else
                _currentInt = 0;
            _valueCurrent = new IntegerLiteral(_currentInt);
        }
        catch(RuntimeException e) {
            _display.popup("Erro nos valores da expressão: " + expression);
            throw e;
        }
    }
    public void visitLt(Lt expression) {
        int _currentInt;
        try {
            expression.first().accept(this);
            IntegerLiteral integer = (IntegerLiteral) _valueCurrent;
            _currentInt = integer.getValue();
            expression.second().accept(this);
            integer = (IntegerLiteral) _valueCurrent;
            if (_currentInt < integer.getValue())
                _currentInt = 1;
            else
                _currentInt = 0;
            _valueCurrent = new IntegerLiteral(_currentInt);
        }
        catch(RuntimeException e) {
            _display.popup("Erro nos valores da expressão: " + expression);
            throw e;
        }
    }
    public void visitMod(Mod expression) {
        int _currentInt;
        try {
            expression.first().accept(this);
            IntegerLiteral integer = (IntegerLiteral) _valueCurrent;
            _currentInt = integer.getValue();
            expression.second().accept(this);
            integer = (IntegerLiteral) _valueCurrent;
            _currentInt %= integer.getValue();
            _valueCurrent = new IntegerLiteral(_currentInt);
        }
        catch(RuntimeException e) {
            _display.popup("Erro nos valores da expressão: " + expression);
            throw e;
        }
    }
    public void visitMul(Mul expression) {
        int _currentInt;
        try {
            expression.first().accept(this);
            IntegerLiteral integer = (IntegerLiteral) _valueCurrent;
            _currentInt = integer.getValue();
            expression.second().accept(this);
            integer = (IntegerLiteral) _valueCurrent;
            _currentInt *= integer.getValue();
            _valueCurrent = new IntegerLiteral(_currentInt);
        }
        catch(RuntimeException e) {
            _display.popup("Erro nos valores da expressão: " + expression);
            throw e;
        }
    }
    public void visitNe(Ne expression) {
        int _currentInt;
        try {
            expression.first().accept(this);
            IntegerLiteral integer = (IntegerLiteral) _valueCurrent;
            _currentInt = integer.getValue();
            expression.second().accept(this);
            integer = (IntegerLiteral) _valueCurrent;
            if (_currentInt != integer.getValue())
                _currentInt = 1;
            else
                _currentInt = 0;
            _valueCurrent = new IntegerLiteral(_currentInt);
        }
        catch(RuntimeException e) {
            _display.popup("Erro nos valores da expressão: " + expression);
            throw e;
        }
    }
    public void visitNeg(Neg expression) {
        int _currentInt;
        try {
            expression.argument().accept(this);
            IntegerLiteral integer = (IntegerLiteral) _valueCurrent;
            _currentInt = integer.getValue() * (-1);
            _valueCurrent = new IntegerLiteral(_currentInt);
        }
        catch(RuntimeException e) {
            _display.popup("Erro nos valores da expressão: " + expression);
            throw e;
        }
    }
    public void visitNot(Not expression) {
        int _currentInt;
        try {
            expression.argument().accept(this);
            IntegerLiteral integer = (IntegerLiteral) _valueCurrent;
            if (integer.getValue() == 0)
                _currentInt = 1;
            else
                _currentInt = 0;
            _valueCurrent = new IntegerLiteral(_currentInt);
        }
        catch(RuntimeException e) {
            _display.popup("Erro nos valores da expressão: " + expression);
            throw e;
        }
    }
    public void visitOr(Or expression) {
        int _currentInt;
        try {
            expression.first().accept(this);
            IntegerLiteral integer = (IntegerLiteral) _valueCurrent;
            _currentInt = integer.getValue();
            if (_currentInt != 0)
                return ;
            expression.second().accept(this);
            integer = (IntegerLiteral) _valueCurrent;
            _currentInt += integer.getValue();
            _valueCurrent = new IntegerLiteral(_currentInt);
        }
        catch(RuntimeException e) {
            _display.popup("Erro nos valores da expressão: " + expression);
            throw e;
        }
    }
    public void visitPrint(Print expression) {
        String print = "";
        for (Expression e : expression.getAll()) {
            e.accept(this);
            print += _valueCurrent.getValue();
        }
        print += "\n";
        _display = new Display();
        _display.popup(print);
    }
    public void visitProgram(Program expression) {
        for (Expression e: expression.getAll()) {
            e.accept(this);
        }
        if (expression.size() == 0)
            _valueCurrent = new IntegerLiteral(0);
    }
    public void visitReadi(Readi expression) {
        try {
            _formInt.parse();
            _valueCurrent = new IntegerLiteral(_descriptionInt.value());
        }
        catch(RuntimeException e) {
            _display.popup("Erro nos valores da expressão: " + expression);
            throw e;
        }
    }
    public void visitReads(Reads expression) {
        try {
            _formStr.parse();
            _valueCurrent = new StringLiteral(_descriptionStr.value());
        }
        catch(RuntimeException e) {
            _display.popup("Erro nos valores da expressão: " + expression);
            throw e;
        }
    }
    public void visitSet(Set expression) {
        try {
            expression.first().accept(this);
            Identifier identifier = (Identifier) _identifier;
            expression.second().accept(this);
            _identifiers.put(identifier.getName(),_valueCurrent);
        }
        catch(RuntimeException e) {
            _display.popup("Erro nos valores da expressão: " + expression);
            throw e;
        }
    }
    public void visitSub(Sub expression) {
        int _currentInt;
        try {
            expression.first().accept(this);
            IntegerLiteral integer = (IntegerLiteral) _valueCurrent;
            _currentInt = integer.getValue();
            expression.second().accept(this);
            integer = (IntegerLiteral) _valueCurrent;
            _currentInt -= integer.getValue();
            _valueCurrent = new IntegerLiteral(_currentInt);
        }
        catch(RuntimeException e) {
            _display.popup("Erro nos valores da expressão: " + expression);
            throw e;
        }
    }

}
