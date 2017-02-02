package pex;

import pex.Expression;
import java.util.TreeSet;
import pex.atomic.Identifier;
import pex.operators.*;
import pex.atomic.*;

public class AllIdentifiersVisitor implements ExpressionVisitor {

    private TreeSet<String> _identifiers = null;

    public AllIdentifiersVisitor() {
        _identifiers = new TreeSet<String>();
    }
    public void visitUnaryExpression(UnaryExpression expression) {
        expression.argument().accept(this);
    }
    public void visitBinaryExpression(BinaryExpression expression) {
        expression.first().accept(this);
        expression.second().accept(this);
    }
    public void visitWhile(While expression) {
        expression.condition().accept(this);
        expression.expression().accept(this);
    }
    public void visitSequence(Sequence expression) {
        for (Expression e: expression.getAll()) {
            e.accept(this);
        }
    }
    public void visitIdentifier(Identifier expression) {
        _identifiers.add(expression.toString());
    }
    public void visitIntegerLiteral(IntegerLiteral expression) {}
    public void visitStringLiteral(StringLiteral expression) {}
    public void visitAdd(Add expression) {
        visitBinaryExpression(expression);
    }
    public void visitAnd(And expression) {
        visitBinaryExpression(expression);
    }
    public void visitCall(Call expression) {
        visitUnaryExpression(expression);
    }
    public void visitDiv(Div expression) {
        visitBinaryExpression(expression);
    }
    public void visitEq(Eq expression) {
        visitBinaryExpression(expression);
    }
    public void visitGe(Ge expression) {
        visitBinaryExpression(expression);
    }
    public void visitGt(Gt expression) {
        visitBinaryExpression(expression);
    }
    public void visitIf(If expression) {
        expression.first().accept(this);
        expression.second().accept(this);
        expression.third().accept(this);
    }
    public void visitLe(Le expression) {
        visitBinaryExpression(expression);
    }
    public void visitLt(Lt expression) {
        visitBinaryExpression(expression);
    }
    public void visitMod(Mod expression) {
        visitBinaryExpression(expression);
    }
    public void visitMul(Mul expression) {
        visitBinaryExpression(expression);
    }
    public void visitNe(Ne expression) {
        visitBinaryExpression(expression);
    }
    public void visitNeg(Neg expression) {
        visitUnaryExpression(expression);
    }
    public void visitNot(Not expression) {
        visitUnaryExpression(expression);
    }
    public void visitOr(Or expression) {
        visitBinaryExpression(expression);
    }
    public void visitPrint(Print expression) {
        visitSequence(expression);
    }
    public void visitProgram(Program expression) {
        visitSequence(expression);
    }
    public void visitReadi(Readi expression) {}
    public void visitReads(Reads expression) {}
    public void visitSet(Set expression) {
        visitBinaryExpression(expression);
    }
    public void visitSub(Sub expression) {
        visitBinaryExpression(expression);
    }

    public String toString() {
        String allIdentifiers = "";
        for(String identifier: _identifiers)
            allIdentifiers += identifier + "\n";
        return allIdentifiers;
    }
}