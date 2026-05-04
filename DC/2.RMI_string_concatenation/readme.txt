Step 1: Delete old class files
del *.class
Step 2: Compile for Java 8
javac --release 8 *.java

This tells JDK 25:

"Compile code compatible with Java 8."

Step 3: Run server
java Server
Step 4: Open second CMD

Run client:

java Client