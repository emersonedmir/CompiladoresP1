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
public class InVarDecl extends Declaration {

    public InVarDecl(Identifier iAST,Expression eAST,SourcePosition thePosition) {
        super(thePosition);
        I=iAST;
        E=eAST;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Identifier I;
    public Expression E;
}
