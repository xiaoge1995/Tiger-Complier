JFLAGS=-g


Parse/Main.class: Parse/*.java Parse/Grm.java Parse/Yylex.java
	javac ${JFLAGS} Parse/*.java

Parse/Grm.java: Parse/Grm.cup
	cd Parse; java java_cup.Main -parser Grm -expect 3 -dump_grammar -dump_states <Grm.cup >Grm.out 2>Grm.err

Parse/Yylex.java: Parse/Tiger.lex
	cd Parse; java JFlex.Main Tiger.lex;

ErrorMsg/ErrorMsg.class:  ErrorMsg/*.java
	javac ${JFLAGS} ErrorMsg/*.java


