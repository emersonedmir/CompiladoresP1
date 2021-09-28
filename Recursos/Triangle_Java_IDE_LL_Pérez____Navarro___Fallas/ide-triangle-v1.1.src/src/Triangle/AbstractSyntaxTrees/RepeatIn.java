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
public class RepeatIn extends Command {

    public RepeatIn(InVarDecl ivdAST,Command cAST,SourcePosition thePosition) {
        super(thePosition);
        IVD= ivdAST;
        C= cAST;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public InVarDecl IVD;
    public Command C;
}
