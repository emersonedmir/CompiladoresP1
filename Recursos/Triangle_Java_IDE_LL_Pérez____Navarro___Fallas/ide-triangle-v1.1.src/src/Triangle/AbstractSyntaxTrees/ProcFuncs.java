package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class ProcFuncs extends Declaration {
    public ProcFuncs(Declaration pfaST, Declaration pf2aST, SourcePosition thePosition) {
        super(thePosition);
        pfAST = pfaST;
        pf2AST = pf2aST;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitProcFuncs(this, o);
    }

    public Declaration pfAST;
    public Declaration pf2AST;

}
