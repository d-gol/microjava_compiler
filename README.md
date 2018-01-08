# Compiler for a Java-like programming language, MicroJava #

## What is it about? ##

MicroJava is pseudolanguage with syntax similar to Java's. This project is an implementation of a compiler for MicroJava.

The compiler provides translating syntacticly and semantically correct MicroJava programs into MicroJava bytecode to be executed on the MicroJava virtual machine. The compiler has four basic functionalities:
* Lexis Analysis
* Syntax Analysis
* Semantical Analysis
* Bytecode Generating

### Lexis Analyzer ###
Lexis Analyzer is checking language constructs and taking tokens from the source code. Those tokens are then used in further steps.

### Syntax Analyzer ###
Syntax Analyzer is checking if the tokens taken in the first step are forming the correct grammar sentences.

### Semantical Analyzer ###
Semantical Analyzer is an extended Syntax Analyzer. Atributes and actions are added to the basic grammar. (Atribute Grammar)

### Bytecode Generator ###
Bytecode Generator is generating the bytecode for the VM.

## How is it implemented? ##
The project is implemented in Java, using modules Cup and JFlex.
