package pex;
import pex.Expression;
import pex.operators.*;
import pex.atomic.*;

public interface ExpressionVisitor {
    public void visitUnaryExpression(UnaryExpression expression);
    public void visitBinaryExpression(BinaryExpression expression);
    public void visitWhile(While expression);
    public void visitSequence(Sequence expression);
    public void visitIdentifier(Identifier expression);
    public void visitIntegerLiteral(IntegerLiteral expression);
    public void visitStringLiteral(StringLiteral expression);
    public void visitAdd(Add expression);
    public void visitAnd(And expression);
    public void visitCall(Call expression);
    public void visitDiv(Div expression);
    public void visitEq(Eq expression);
    public void visitGe(Ge expression);
    public void visitGt(Gt expression);
    public void visitIf(If expression);
    public void visitLe(Le expression);
    public void visitLt(Lt expression);
    public void visitMod(Mod expression);
    public void visitMul(Mul expression);
    public void visitNe(Ne expression);
    public void visitNeg(Neg expression);
    public void visitNot(Not expression);
    public void visitOr(Or expression);
    public void visitPrint(Print expression);
    public void visitProgram(Program expression);
    public void visitReadi(Readi expression);
    public void visitReads(Reads expression);
    public void visitSet(Set expression);
    public void visitSub(Sub expression);
}