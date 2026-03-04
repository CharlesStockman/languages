# Introduction

Notes and Exerceies to understand Kotlin better.

## Branches
|Branch Name|Description|Created|
|-----------|-----------|-------|
|tour-notes-and-exercises | Branch with Notes and Exercises | No |
|tour-notes-and-completed-exercises | Branch with notes and completed exercises | No

## Run A Kotlin Program
```
kotlinc <name of source file>.kt -include-runtime -d <name of source file>.jar
```
The extension of a kotlin source file is "kt"

## Execute 
The extension is "jar"

The jar file was created by kotlinc

```
java -jar <jar file> 
```

## Example of compiling and running a program

```
cd languages/kotlin/
kotlinc helloWorld.kt -include-runtime -d helloWorld.jar
java -jar helloWorld.jar
```
