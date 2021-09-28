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
public class ForCommand extends Command{

    public ForCommand(Identifier iAST,Expression eAST, Command cAST, SourcePosition thePosition) {
        super(thePosition);
        I=iAST;
        E=eAST;
        C=cAST;
    }

    @Override
    public Object visit(Visitor v, Object o) {
       return v.visitForCommand(this, o);
    }
    
    public Identifier I;
    public Expression E;
    public Command C;
}
