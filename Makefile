all:
	make compile 
	make compileTest 
	make runTest
compile:
	javac -d build -sourcepath src src/main/java/GameRunner.java
compileTest:
	javac -d build -sourcepath src src/test/java/AllTestRunner.java
run:
	java -classpath build main.java.GameRunner
runTest:
	java -classpath build test.java.AllTestRunner
clear:
	rm -rf build/*

