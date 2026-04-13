# Introduction
## Notes and Exerceies to understand Kotlin better.

### Run A Kotlin Program
kotlinc <name of source file>.kt -include-runtime -d <name of source file>.jar

#### Source Files
The extension of a kotlin source file is "kt"

#### Executable Files 
The extension of an executable file is "jar"

```
# Example of compiling and running a program
cd languages/kotlin/
kotlinc helloWorld.kt -include-runtime -d helloWorld.jar
java -jar helloWorld.jar
```
