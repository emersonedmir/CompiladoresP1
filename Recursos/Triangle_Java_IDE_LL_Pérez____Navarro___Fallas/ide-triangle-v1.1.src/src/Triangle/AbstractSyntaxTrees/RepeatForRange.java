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
public class RepeatForRange extends Command{

    public RepeatForRange(RangeVarDecl dAST,Expression eAST,Command cAST, SourcePosition thePosition) {
        super(thePosition);
        D=dAST;
        E=eAST;
        C=cAST;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public RangeVarDecl D;
    public Expression E;
    public Command C;
    
}
