/*
 * IDE-Triangle v1.0
 * TreeVisitor.java
 */

package Core.Visitors;
import Triangle.AbstractSyntaxTrees.AST;
import Triangle.AbstractSyntaxTrees.AnyTypeDenoter;
import Triangle.AbstractSyntaxTrees.ArrayExpression;
import Triangle.AbstractSyntaxTrees.ArrayTypeDenoter;
import Triangle.AbstractSyntaxTrees.AssignCommand;
import Triangle.AbstractSyntaxTrees.BinaryExpression;
import Triangle.AbstractSyntaxTrees.BinaryOperatorDeclaration;
import Triangle.AbstractSyntaxTrees.BoolTypeDenoter;
import Triangle.AbstractSyntaxTrees.CallCommand;
import Triangle.AbstractSyntaxTrees.CallExpression;
import Triangle.AbstractSyntaxTrees.CharTypeDenoter;
import Triangle.AbstractSyntaxTrees.CharacterExpression;
import Triangle.AbstractSyntaxTrees.CharacterLiteral;
import Triangle.AbstractSyntaxTrees.ConstActualParameter;
import Triangle.AbstractSyntaxTrees.ConstDeclaration;
import Triangle.AbstractSyntaxTrees.ConstFormalParameter;
import Triangle.AbstractSyntaxTrees.DoCommand;
import Triangle.AbstractSyntaxTrees.DotVname;
import Triangle.AbstractSyntaxTrees.EmptyActualParameterSequence;
import Triangle.AbstractSyntaxTrees.EmptyCommand;
import Triangle.AbstractSyntaxTrees.EmptyExpression;
import Triangle.AbstractSyntaxTrees.EmptyFormalParameterSequence;
import Triangle.AbstractSyntaxTrees.ErrorTypeDenoter;

import Triangle.AbstractSyntaxTrees.FuncActualParameter;
import Triangle.AbstractSyntaxTrees.FuncDeclaration;
import Triangle.AbstractSyntaxTrees.FuncFormalParameter;
import Triangle.AbstractSyntaxTrees.Identifier;
import Triangle.AbstractSyntaxTrees.IfCommand;
import Triangle.AbstractSyntaxTrees.IfExpression;
import Triangle.AbstractSyntaxTrees.InVarDecl;
import Triangle.AbstractSyntaxTrees.IntTypeDenoter;
import Triangle.AbstractSyntaxTrees.IntegerExpression;
import Triangle.AbstractSyntaxTrees.IntegerLiteral;
import Triangle.AbstractSyntaxTrees.LetCommand;
import Triangle.AbstractSyntaxTrees.LetExpression;
import Triangle.AbstractSyntaxTrees.LocalDeclaration;
import Triangle.AbstractSyntaxTrees.MultipleActualParameterSequence;
import Triangle.AbstractSyntaxTrees.MultipleArrayAggregate;
import Triangle.AbstractSyntaxTrees.MultipleFieldTypeDenoter;
import Triangle.AbstractSyntaxTrees.MultipleFormalParameterSequence;
import Triangle.AbstractSyntaxTrees.MultipleRecordAggregate;
import Triangle.AbstractSyntaxTrees.Operator;
import Triangle.AbstractSyntaxTrees.ProcActualParameter;
import Triangle.AbstractSyntaxTrees.ProcDeclaration;
import Triangle.AbstractSyntaxTrees.ProcFormalParameter;
import Triangle.AbstractSyntaxTrees.ProcFuncs;
import Triangle.AbstractSyntaxTrees.Program;
import Triangle.AbstractSyntaxTrees.RangeVarDecl;
import Triangle.AbstractSyntaxTrees.RecordExpression;
import Triangle.AbstractSyntaxTrees.RecordTypeDenoter;
import Triangle.AbstractSyntaxTrees.RecursiveDeclaration;
import Triangle.AbstractSyntaxTrees.RepeatForRange;
import Triangle.AbstractSyntaxTrees.RepeatForRangeUntil;
import Triangle.AbstractSyntaxTrees.RepeatForRangeWhile;
import Triangle.AbstractSyntaxTrees.RepeatIn;
import Triangle.AbstractSyntaxTrees.SequentialCommand;
import Triangle.AbstractSyntaxTrees.SequentialDeclaration;
import Triangle.AbstractSyntaxTrees.SimpleTypeDenoter;
import Triangle.AbstractSyntaxTrees.SimpleVname;
import Triangle.AbstractSyntaxTrees.SingleActualParameterSequence;
import Triangle.AbstractSyntaxTrees.SingleArrayAggregate;
import Triangle.AbstractSyntaxTrees.SingleFieldTypeDenoter;
import Triangle.AbstractSyntaxTrees.SingleFormalParameterSequence;
import Triangle.AbstractSyntaxTrees.SingleRecordAggregate;
import Triangle.AbstractSyntaxTrees.SubscriptVname;
import Triangle.AbstractSyntaxTrees.TypeDeclaration;
import Triangle.AbstractSyntaxTrees.UnaryExpression;
import Triangle.AbstractSyntaxTrees.UnaryOperatorDeclaration;
import Triangle.AbstractSyntaxTrees.UntilCommand;
import Triangle.AbstractSyntaxTrees.VarActualParameter;
import Triangle.AbstractSyntaxTrees.VarDeclaration;
import Triangle.AbstractSyntaxTrees.VarExpression;
import Triangle.AbstractSyntaxTrees.VarFormalParameter;
import Triangle.AbstractSyntaxTrees.Visitor;
import Triangle.AbstractSyntaxTrees.VnameExpression;
import Triangle.AbstractSyntaxTrees.WhileCommand;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Implements the Triangle Visitor interface, which is used to
 * visit an entire AST. 
 *
 * Generates DefaultMutableTreeNodes, used to draw a JTree.
 *
 * @author Luis Leopoldo Pérez <luiperpe@ns.isi.ulatina.ac.cr>
 */
public class TreeVisitor implements Visitor {
      
    /**
     * Creates a new instance of TreeVisitor.
     */
    public TreeVisitor() {
    }
    public String XML="";
    // <editor-fold defaultstate="collapsed" desc=" Commands ">    
    // Commands  
    public Object visitAssignCommand(AssignCommand ast, Object o) {
        return(createBinary("AssignCommand", ast.V, ast.E));
    }
    
    public Object visitCallCommand(CallCommand ast, Object o) {
        return(createBinary("CallCommand", ast.I, ast.APS));
    }
    
    public Object visitEmptyCommand(EmptyCommand ast, Object o) {
        XML+="<EmptyCommand value = \"skip\">";
        return(createNullary("EmptyCommand"));
    }
    
    public Object visitIfCommand(IfCommand ast, Object obj) {

        return(createTernary("IfCommand", ast.E, ast.C1, ast.C2));
        
    }
    
    public Object visitLetCommand(LetCommand ast, Object obj) {
        return(createBinary("LetCommand", ast.D, ast.C));
    }
    
    public Object visitSequentialCommand(SequentialCommand ast, Object obj) {
        return(createBinary("SequentialCommand", ast.C1, ast.C2));
    }
    
    public Object visitWhileCommand(WhileCommand ast, Object obj) {
        return(createBinary("WhileCommand", ast.E, ast.C));
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Expressions ">
    // Expressions
    public Object visitArrayExpression(ArrayExpression ast, Object obj) {
        return(createUnary("ArrayExpression", ast.AA));
    }
    
    public Object visitBinaryExpression(BinaryExpression ast, Object obj) {
        return(createTernary("BinaryExpression", ast.E1, ast.O, ast.E2));
    }
    
    public Object visitCallExpression(CallExpression ast, Object obj) {
        return(createBinary("CallExpression", ast.I, ast.APS));
    }
    
    public Object visitCharacterExpression(CharacterExpression ast, Object obj) {
        return(createUnary("CharacterExpression", ast.CL));
    }
    
    public Object visitEmptyExpression(EmptyExpression ast, Object obj) {
        XML+="<EmptyExpression value = \"skip\">";
        return(createNullary("EmptyExpression"));
    }
    
    public Object visitIfExpression(IfExpression ast, Object obj) {
        return(createTernary("IfExpression", ast.E1, ast.E2, ast.E3));
    }
    
    public Object visitIntegerExpression(IntegerExpression ast, Object obj) {
        return(createUnary("IntegerExpression", ast.IL));
    }
    
    public Object visitLetExpression(LetExpression ast, Object obj) {
        return(createBinary("LetExpression", ast.D, ast.E));
    }
    
    public Object visitRecordExpression(RecordExpression ast, Object obj) {
        return(createUnary("RecordExpression", ast.RA));
    }
    
    public Object visitUnaryExpression(UnaryExpression ast, Object obj) {
        return(createBinary("UnaryExpression", ast.O, ast.E));
    }
    
    public Object visitVnameExpression(VnameExpression ast, Object obj) {
        return(createUnary("VnameExpression", ast.V));
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Declarations ">
    // Declarations
    public Object visitBinaryOperatorDeclaration(BinaryOperatorDeclaration ast, Object obj) {
        return(createQuaternary("BinaryOperatorDeclaration", ast.O, ast.ARG1, ast.ARG2, ast.RES));
    }
    
    public Object visitConstDeclaration(ConstDeclaration ast, Object obj) {
        return(createBinary("ConstantDeclaration", ast.I, ast.E));
    }
    
    public Object visitFuncDeclaration(FuncDeclaration ast, Object obj) {
        return(createQuaternary("FunctionDeclaration", ast.I, ast.FPS, ast.T, ast.E));
    }
    
    public Object visitProcDeclaration(ProcDeclaration ast, Object obj) {
        return(createTernary("ProcedureDeclaration", ast.I, ast.FPS, ast.C));        
    }
    
    public Object visitSequentialDeclaration(SequentialDeclaration ast, Object obj) {
        return(createBinary("SequentialDeclaration", ast.D1, ast.D2));
    }
    
    public Object visitTypeDeclaration(TypeDeclaration ast, Object obj) {
        return(createBinary("TypeDeclaration", ast.I, ast.T));
    }
    
    public Object visitUnaryOperatorDeclaration(UnaryOperatorDeclaration ast, Object obj) {
        return(createTernary("UnaryOperatorDeclaration", ast.O, ast.ARG, ast.RES));
    }
    
    public Object visitVarDeclaration(VarDeclaration ast, Object obj) {
        return(createBinary("VariableDeclaration", ast.I, ast.T));
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Aggregates ">
    // Array Aggregates
    public Object visitMultipleArrayAggregate(MultipleArrayAggregate ast, Object obj) {
        return(createBinary("MultipleArrayAggregate", ast.E, ast.AA));
    }
    
    public Object visitSingleArrayAggregate(SingleArrayAggregate ast, Object obj) {
        return(createUnary("SingleArrayAggregate", ast.E));
    }
    
    // Record Aggregates
    public Object visitMultipleRecordAggregate(MultipleRecordAggregate ast, Object obj) {
        return(createTernary("MultipleRecordAggregate", ast.I, ast.E, ast.RA));
    }
    
    public Object visitSingleRecordAggregate(SingleRecordAggregate ast, Object obj) {
        return(createBinary("SingleRecordAggregate", ast.I, ast.E));
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Parameters ">
    // Formal Parameters   
    public Object visitConstFormalParameter(ConstFormalParameter ast, Object obj) {
        return(createBinary("ConstantFormalParameter", ast.I, ast.T));
    }
    
    public Object visitFuncFormalParameter(FuncFormalParameter ast, Object obj) {
        return(createTernary("FunctionFormalParameter", ast.I, ast.FPS, ast.T));
    }
    
    public Object visitProcFormalParameter(ProcFormalParameter ast, Object obj) {
        return(createBinary("ProcedureFormalParameter", ast.I, ast.FPS));
    }
    
    public Object visitVarFormalParameter(VarFormalParameter ast, Object obj) {
        return(createBinary("VariableFormalParameter", ast.I, ast.T));
    }
    
    public Object visitEmptyFormalParameterSequence(EmptyFormalParameterSequence ast, Object obj) {
        XML+="<EmptyFormalParameterSequence value = \"skip\">";
        return(createNullary("EmptyFormalParameterSequence"));
    }
    
    public Object visitMultipleFormalParameterSequence(MultipleFormalParameterSequence ast, Object obj) {
        return(createBinary("MultipleFormalParameterSequence", ast.FP, ast.FPS));
    }
    
    public Object visitSingleFormalParameterSequence(SingleFormalParameterSequence ast, Object obj) {
        return(createUnary("SingleFormalParameterSequence", ast.FP));
    }
    
    // Actual Parameters
    public Object visitConstActualParameter(ConstActualParameter ast, Object obj) {
        return(createUnary("ConstantActualParameter", ast.E));
    }
    
    public Object visitFuncActualParameter(FuncActualParameter ast, Object obj) {
        return(createUnary("FunctionActualParameter", ast.I));
    }
    
    public Object visitProcActualParameter(ProcActualParameter ast, Object obj) {
        return(createUnary("ProcedureActualParameter", ast.I));
    }
    
    public Object visitVarActualParameter(VarActualParameter ast, Object obj) {
        return(createUnary("VariableActualParameter", ast.V));
    }
    
    public Object visitEmptyActualParameterSequence(EmptyActualParameterSequence ast, Object obj) {
        XML+="<EmptyActualParameterSequence value = \"skip\"/>";
        return(createNullary("EmptyActualParameterSequence"));
    }
    
    public Object visitMultipleActualParameterSequence(MultipleActualParameterSequence ast, Object obj) {
        return(createBinary("MultipleActualParameterSequence", ast.AP, ast.APS));
    }
    
    public Object visitSingleActualParameterSequence(SingleActualParameterSequence ast, Object obj) {
        return(createUnary("SingleActualParameterSequence", ast.AP));
    }
    // </editor-fold>
        
    // <editor-fold defaultstate="collapsed" desc=" Type Denoters ">
    // Type Denoters
    public Object visitAnyTypeDenoter(AnyTypeDenoter ast, Object obj) {
        return(createNullary("any"));
    }
    
    public Object visitArrayTypeDenoter(ArrayTypeDenoter ast, Object obj) {
        return(createBinary("ArrayTypeDenoter", ast.IL, ast.T));
    }
    
    public Object visitBoolTypeDenoter(BoolTypeDenoter ast, Object obj) {
        return(createNullary("bool"));
    }
    
    public Object visitCharTypeDenoter(CharTypeDenoter ast, Object obj) {
        return(createNullary("char"));
    }
    
    public Object visitErrorTypeDenoter(ErrorTypeDenoter ast, Object obj) {
        return(createNullary("error"));
    }
    
    public Object visitSimpleTypeDenoter(SimpleTypeDenoter ast, Object obj) {
        return(createUnary("SimpleTypeDenoter", ast.I));
    }
    
    public Object visitIntTypeDenoter(IntTypeDenoter ast, Object obj) {
        return(createNullary("int"));
    }
    
    public Object visitRecordTypeDenoter(RecordTypeDenoter ast, Object obj) {
        return(createUnary("RecordTypeDenoter", ast.FT));
    }
    
    public Object visitMultipleFieldTypeDenoter(MultipleFieldTypeDenoter ast, Object obj) {
        return(createTernary("MultipleFieldTypeDenoter", ast.I, ast.T, ast.FT));
    }
    
    public Object visitSingleFieldTypeDenoter(SingleFieldTypeDenoter ast, Object obj) {
        return(createBinary("SingleFieldTypeDenoter", ast.I, ast.T));
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Literals, Identifiers and Operators ">
    // Literals, Identifiers and Operators
    public Object visitCharacterLiteral(CharacterLiteral ast, Object obj) {
        XML+="<CharLiteral value = \""+ ast.spelling +"\"/>";
        return(createNullary(ast.spelling));
    }
    
    public Object visitIdentifier(Identifier ast, Object obj) {
        XML+="<Identifier value = \""+ ast.spelling +"\"/>";
        return(createNullary(ast.spelling));
    }
    
    public Object visitIntegerLiteral(IntegerLiteral ast, Object obj) {
        XML+="<IntegerLiteral value = \""+ ast.spelling +"\"/>";
        return(createNullary(ast.spelling));
    }
    
    public Object visitOperator(Operator ast, Object obj) {
        XML+="<Operator value = \""+ ast.spelling +"\"/>";
        return(createNullary(ast.spelling));
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Values or Variable Names ">
    // Values or Variable Names
    public Object visitDotVname(DotVname ast, Object obj) {
        return(createBinary("DotVname", ast.I, ast.V));
    }
    
    public Object visitSimpleVname(SimpleVname ast, Object obj) {
        return(createUnaryIdentifier("SimpleVname", ast.I));
    }
    
    public Object visitSubscriptVname(SubscriptVname ast, Object obj) {
        return(createBinary("SubscriptVname", ast.V, ast.E));
    }
    
    public Object visitProgram(Program ast, Object obj) {
        this.XML="";
        return(createUnary("Program", ast.C));
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Tree Creation Methods ">
    
    /**
     * Creates a nullary tree node (doesn't have any children).
     * @param caption The tree's caption (text to be shown when the tree is drawn).
     * @return The tree node.
     */
    public DefaultMutableTreeNode createNullary(String caption) {
        DefaultMutableTreeNode t = new DefaultMutableTreeNode(caption);
        
        return(t);
    }
    
    /**
     * Creates an unary tree node.
     * @param caption The tree's caption (text to be shown when the tree is drawn).
     * @param child1 The first children node.
     * @return The tree node.
     */
    public DefaultMutableTreeNode createUnary(String caption, AST child1) {
        XML+="<"+caption+">";
        DefaultMutableTreeNode t = new DefaultMutableTreeNode(caption);
        t.add((DefaultMutableTreeNode)child1.visit(this, null));
        XML+="</"+caption+">";
        return(t);
    }
    public DefaultMutableTreeNode createUnaryIdentifier(String caption, Identifier child1) {
         //XML+="<"+caption+" values= \""+ child1.spelling +"\"/>";
        DefaultMutableTreeNode t = new DefaultMutableTreeNode(caption);
        t.add((DefaultMutableTreeNode)child1.visit(this, null));
        
        return(t);
    }
    
    /**
     * Creates a binary tree node.
     * @param caption The tree's caption (text to be shown when the tree is drawn).
     * @param child1 The first children node.
     * @param child2 The second children node.
     * @return The tree node.
     */
    public DefaultMutableTreeNode createBinary(String caption, AST child1, AST child2) {
        XML+="<"+caption+">";
        DefaultMutableTreeNode t = new DefaultMutableTreeNode(caption);
        t.add((DefaultMutableTreeNode)child1.visit(this, null));
        t.add((DefaultMutableTreeNode)child2.visit(this, null));
        XML+="</"+caption+">";
        return(t);
    }
    
    /**
     * Creates a ternary tree node.
     * @param caption The tree's caption (text to be shown when the tree is drawn).
     * @param child1 The first children node.
     * @param child2 The second children node.
     * @param child3 The third children node.
     * @return The tree node.
     */
    public DefaultMutableTreeNode createTernary(String caption, AST child1, AST child2, AST child3) {
        XML+="<"+caption+">";
        DefaultMutableTreeNode t = new DefaultMutableTreeNode(caption);
        t.add((DefaultMutableTreeNode)child1.visit(this, null));
        t.add((DefaultMutableTreeNode)child2.visit(this, null));
        t.add((DefaultMutableTreeNode)child3.visit(this, null));
        XML+="</"+caption+">";
        return(t);        
    }
    
    /**
     * Creates a quaternary tree node.
     * @param caption The tree's caption (text to be shown when the tree is drawn).
     * @param child1 The first children node.
     * @param child2 The second children node.
     * @param child3 The third children node.
     * @param child4 The fourth children node.
     * @return The tree node.
     */
    public DefaultMutableTreeNode createQuaternary(String caption, AST child1, AST child2, AST child3, AST child4) {
        XML+="</"+caption+">";
        DefaultMutableTreeNode t = new DefaultMutableTreeNode(caption);
        t.add((DefaultMutableTreeNode)child1.visit(this, null));
        t.add((DefaultMutableTreeNode)child2.visit(this, null));
        t.add((DefaultMutableTreeNode)child3.visit(this, null));
        t.add((DefaultMutableTreeNode)child4.visit(this, null));
        XML+="</"+caption+">";
        return(t);             
    }
    // </editor-fold>



    @Override
    public Object visitDoCommand(DoCommand ast, Object o) {
        return(createBinary("DoCommand", ast.E, ast.C));
    }

  

    @Override
    public Object visitProcFuncs(ProcFuncs ast, Object o) {
        return(createBinary("Proc-Funcs", ast.pfAST, ast.pf2AST));
    }

    @Override
    public Object visitRecursiveDeclaration(RecursiveDeclaration ast, Object o) {
        return (this.createUnary("RecursiveDeclaration", ast.D));
    }

    @Override
    public Object visitUntilCommand(UntilCommand ast, Object o) {
        return(createBinary("UntilCommand", ast.E, ast.C));
    }

    @Override
    public Object visitRangeVarDecl(RangeVarDecl ast, Object o) {
        return(createBinary("RangeVarDeclCommand", ast.I, ast.E));
    }

    @Override
    public Object visitRepeatForRange(RepeatForRange ast, Object o) {
        return (this.createTernary("RepeatForRange", ast.C, ast.D, ast.E));
    }

    @Override
    public Object visitRepeatForRangeWhile(RepeatForRangeWhile ast, Object o) {
        return (this.createQuaternary("RepeatForRangeWhile", ast.D, ast.E1, ast.C, ast.E2));
    }

    @Override
    public Object visitRepeatForRangeUntil(RepeatForRangeUntil ast, Object o) {
        return (this.createQuaternary("RepeatForRangeUntil", ast.D, ast.E1, ast.C, ast.E2));
    }

    @Override
    public Object visitInVarDecl(InVarDecl ast, Object o) {
        return(createBinary("InVarDeclarationCommand", ast.E, ast.I));
    }

    @Override
    public Object visitRepeatIn(RepeatIn ast, Object o) {
        return(createBinary("RepeatInCommand", ast.IVD, ast.C));
    }

    @Override
    public Object visitLocalDeclaration(LocalDeclaration ast, Object o) {
        return(createBinary("LocalDeclarationCommand", ast.D1, ast.D2));
    }

    @Override
    public Object visitVarExpression(VarExpression ast, Object o) {
        return(createBinary("UntilCommand", ast.E, ast.I));
    }

    

 
}
