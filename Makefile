all:
	make compile 
	make run
compile:
	javac -d build -sourcepath src src/main/java/GameRunner.java
run:
	java -classpath build main.java.GameRunner
clear:
	rm -rf build/*

