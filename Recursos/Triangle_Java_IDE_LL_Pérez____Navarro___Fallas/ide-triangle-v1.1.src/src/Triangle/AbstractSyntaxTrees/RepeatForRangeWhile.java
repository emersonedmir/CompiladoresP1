/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author TOES
 */
public class RepeatForRangeWhile extends Command{

    public RepeatForRangeWhile(RangeVarDecl dAST,Expression e1AST,Command cAST,Expression e2AST,SourcePosition thePosition) {
        super(thePosition);
        D=dAST;
        E1=e1AST;
        C=cAST;
        E2=e2AST;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitRepeatForRangeWhile(this, o);
    }
    public RangeVarDecl D;
    public Expression E1;
    public Command C;
    public Expression E2;
}


