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
public class repeatDoUntil extends Command{

    public repeatDoUntil(Command cAST, Expression eAST, SourcePosition thePosition) {
        super(thePosition);
        C = cAST;
        E = eAST;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitRepeatDoUntil(this, o);
    }
    
    public Command C;
    public Expression E; 
}
