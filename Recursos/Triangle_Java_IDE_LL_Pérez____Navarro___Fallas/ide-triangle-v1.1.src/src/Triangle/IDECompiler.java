/*
 * IDE-Triangle v1.0
 * Compiler.java 
 */

package Triangle;

import Triangle.CodeGenerator.Frame;
import java.awt.event.ActionListener;
import Triangle.SyntacticAnalyzer.SourceFile;
import Triangle.SyntacticAnalyzer.Scanner;
import Triangle.AbstractSyntaxTrees.Program;
import Triangle.SyntacticAnalyzer.Parser;
import Triangle.ContextualAnalyzer.Checker;
import Triangle.CodeGenerator.Encoder;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import jdk.nashorn.internal.parser.Token;




/** 
 * This is merely a reimplementation of the Triangle.Compiler class. We need
 * to get to the ASTs in order to draw them in the IDE without modifying the
 * original Triangle code.
 *
 * @author Luis Leopoldo Pérez <luiperpe@ns.isi.ulatina.ac.cr>
 */
public class IDECompiler {

    // <editor-fold defaultstate="collapsed" desc=" Methods ">
    /**
     * Creates a new instance of IDECompiler.
     *
     */
    public String fullName="";
    public IDECompiler() {
    }
    
    /**
     * Particularly the same compileProgram method from the Triangle.Compiler
     * class.
     * @param sourceName Path to the source file.
     * @return True if compilation was succesful.
     */
    public boolean compileProgram(String sourceName) throws IOException {
        System.out.println("********** " +
                           "Triangle Compiler (IDE-Triangle 1.0)" +
                           " **********");
        
        System.out.println("Syntactic Analysis ...");
        fullName=sourceName;
        SourceFile source = new SourceFile(sourceName);
        Scanner scanner = new Scanner(source);
        scanner.html ="";
        report = new IDEReporter();
        Parser parser = new Parser(scanner, report);
        boolean success = false;
        
        rootAST = parser.parseProgram();
        
        
        
        
        if (report.numErrors == 0) {
            //System.out.println("Contextual Analysis ...");
            //Checker checker = new Checker(report);
            //checker.check(rootAST);
            if (report.numErrors == 0) {
                //System.out.println("Code Generation ...");
                //Encoder encoder = new Encoder(report);
                //encoder.encodeRun(rootAST, false);
                
                if (report.numErrors == 0) {
                    //encoder.saveObjectProgram(sourceName.replace(".tri", ".tam"));
                    success = true;
                }
            }
        }

        if (success){
            scanner.html +="</p>";
            
            String[] palabras = sourceName.split("\\.");
            
        
            String ruta = palabras[0] + ".html";
            String contenido = scanner.html;
            File file = new File(ruta);
            if (!file.exists()) {
                    file.createNewFile();
                }
            FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(contenido);
                bw.close();
            System.out.println("Compilation was successful.");
        }
            
        else{
            
            //código agregado para generar el html en caso de error sintactico
            SourceFile nsource = new SourceFile(sourceName);
            Scanner nscanner = new Scanner(source);
            if(nscanner.scanAll()){
                nscanner.html +="</p>";
            
            String[] palabras = sourceName.split("\\.");
            
        
            String ruta = palabras[0] + ".html";
            String contenido = nscanner.html;
            File file = new File(ruta);
            if (!file.exists()) {
                    file.createNewFile();
                }
            FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(contenido);
                bw.close();
            }
            
            System.out.println("Compilation was unsuccessful.");
        }
        
        
        return(success);
    }
      
   
    /**
     * Returns the line number where the first error is.
     * @return Line number.
     */
    public int getErrorPosition() {
        return(report.getFirstErrorPosition());
    }
        
    /**
     * Returns the root Abstract Syntax Tree.
     * @return Program AST (root).
     */
    public Program getAST() {
        return(rootAST);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Attributes ">
    private Program rootAST;        // The Root Abstract Syntax Tree.    
    private IDEReporter report;     // Our ErrorReporter class.
    // </editor-fold>
}
