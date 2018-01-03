package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java_cup.runtime.Symbol;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import rs.ac.bg.etf.pp1.util.Log4JUtils;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;

public class MJParserTest {

	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}
	
	public static void main(String[] args) throws Exception {
		
		Logger log = Logger.getLogger(MJParserTest.class);
		
		Reader br = null;
		try {
			if (args.length < 2) {
				log.error("Not enough arguments supplied! Usage: MJParser <source-file> <obj-file> ");
				return;
			}
			File sourceCode = new File(args[0]);
			if (!sourceCode.exists()) {
				log.error("Source file [" + sourceCode.getAbsolutePath() + "] not found!");
				return;
			}
			
			log.info("==================SINTAKSNA ANALIZA====================");
			
			log.info("Compiling source file: " + sourceCode.getAbsolutePath());
			
			br = new BufferedReader(new FileReader(sourceCode));
			Yylex lexer = new Yylex(br);
			
			MJParser p = new MJParser(lexer);
	        Symbol s = p.parse();  //pocetak parsiranja
	        
	        log.info("Print calls = " + p.printCallCount);
	        //log.info("Classes: " + p.classCount);
	        log.info("Methods: " + p.methodCount);
	        log.info("Global variables: " + p.globVarCount);
	        log.info("Global constants: " + p.globConstCount);
	        log.info("Global arrays: " + p.globArrayCount);
	        log.info("Local variables in main: " + p.locVarCountMain);
	        log.info("Function calls in main: " + p.funcCallCountMain);
	        log.info("Statement blocks: " + p.statBlockCount);
	        log.info("Form pars declarations: " + p.formParsCounter);
	        log.info("Broj gresaka: " + p.errorCount);
	        
	        Tab.find("").equals("");
	        Tab.dump();
	        
	        if (!p.errorDetected) {
	        	File objFile = new File(args[1]);
	        	log.info("Generating bytecode file: " + objFile.getAbsolutePath());
	        	if (objFile.exists())
	        		objFile.delete();
	        	Code.write(new FileOutputStream(objFile));
	        	
	        	log.info("Parsiranje uspesno zavrseno!");
	        }
	        else {
	        	log.error("Parsiranje NIJE uspesno zavrseno!");
	        }
	        
		} 
		finally {
			if (br != null) try { br.close(); } catch (IOException e1) { log.error(e1.getMessage(), e1); }
		}

	}
	
	
}
