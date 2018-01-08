# Compiler for a Java-like programming language, MicroJava #

## What is it about? ##

MicroJava is pseudo-language with syntax similar to Java's. This project is an implementation of a compiler for MicroJava.

The compiler provides translating syntactically and semantically correct MicroJava programs into MicroJava bytecode to be executed on the MicroJava virtual machine. The compiler has four basic functionalities:
* Lexis Analysis
* Syntax Analysis
* Semantical Analysis
* Bytecode Generating

### Lexis Analyzer ###
Lexis Analyzer is checking language constructs and taking tokens from the source code. Those tokens are then used in further steps.

### Syntax Analyzer ###
Syntax Analyzer is checking if the tokens taken in the first step are forming the correct grammar sentences.

### Semantics Analyzer ###
Semantics Analyzer is an extended Syntax Analyzer. Attributes and actions are added to the basic grammar. (Attribute Grammar)

### Bytecode Generator ###
Bytecode Generator is generating the bytecode for the VM.

## How is it implemented? ##
The project is implemented in Java, using modules Cup and JFlex.

* Providing a valid parser configuration in the file: mjparser.cup.
* Providing a valid parser configuration in the file: mjlexer.flex.
* Modifying the files: MJParser.java, Yylex.java, sym.java.
* Testing with correct programs and with programs with errors.
