# SER502-ProjectSpring2018

## Compiler Design Project for SER 502


### Deliverable's:

##### System on which your compiler and runtime are built
- Linux system and MacOS
 
##### Tools used

- ANtlr, Gradle, Intellij as IDE


##### Directions/instructions to install 
##### Directions/instructions to build and run your language (compiler/runtime).

We are using [gradle](https://gradle.org/), as far the best build system for the JVM automation  for 
installing, building  Infinity (compiler/runtime).

Downloading the sources for Infinity:

```
 $ git clone https://github.com/Raghav1794/SER502-ProjectSpring2018.git
 $ cd SER502-ProjectSpring2018
```

Project Structure:

**Place the Infinity code to run in **data** folder of project:**
```

  ├── build.gradle
  ├── contribution.txt
  ├── **data**
  │   ├── factorial.inf
  │   ├── fibonacci.inf
  │   ├── gcd.inf
  │   ├── Ifcheck.inf
  │   ├── intermediate
  │   │   └── gcd.inf.byte
  │   ├── pattern.inf
  │   ├── pattern.inf.byte
  │   ├── scanAndPrintCheck.inf
  │   └── swapTwoNumbers
  ├── gradlew
  ├── gradlew.bat
  ├── parseTree
  ├── parseTree.pt
  ├── README.md
  └── src
      └── main
          └── java
              ├── compiler
              │   ├── infinityBaseListener.java
              │   ├── infinityBaseVisitor.java
              │   ├── infinity.g4
              │   ├── infinityLexer.java
              │   ├── infinityLexer.tokens
              │   ├── infinityListener.java
              │   ├── infinityParser.java
              │   ├── infinityRunner.java
              │   ├── infinity.tokens
              │   └── infinityVisitor.java
              └── runtime
                  ├── Arithmetic
                  │   ├── Add.java
                  │   ├── Arithmetic.java
                  │   ├── Divide.java
                  │   ├── Modulus.java
                  │   ├── Multiply.java
                  │   └── Subtract.java
                  ├── conditional
                  │   ├── Conditional.java
                  │   ├── EqualTo.java
                  │   ├── Greater.java
                  │   ├── GreaterThanEqual.java
                  │   ├── Lesser.java
                  │   ├── LesserThanEqual.java
                  │   └── NotEqualsTo.java
                  ├── constants
                  │   └── Constants.java
                  ├── ds
                  │   ├── Stack.java
                  │   └── SymbolTable.java
                  ├── Loader.java
                  ├── Logical
                  │   ├── And.java
                  │   ├── Logical.java
                  │   ├── Not.java
                  │   └── Or.java
                  ├── runtime
                  │   └── Runtime.java
                  └── utility
                      ├── In.java
                      └── StdIn.java
  

```


Building and Running of a sample program:

**Linux based systems:**

```
$ ./gradlew  build run -Pfile=<filename>
```

for example:
```
$ ./gradlew build run -Pfile=factorial.inf
```

or with you want to provide absolute path instead of placing code in data folder, please
use the following script

```
$ ./gradlew  build executeWithAbsolutePath -Pfile=<filenameCompletePath>
```


**Windows based system**

Similar to Linux but no ./ infront of gradlew

```
 > cd SER502-ProjectSpring2018
 > gradlew build run -Pfile=factorial.inf

```

If you get an error of:
Tools.jar is not found:  issue discusses [Here](http://stackoverflow.com/questions/5730815/unable-to-locate-tools-jar)

The issue can be fixed by referring to following [link](https://www.mkyong.com/java/how-to-set-java_home-on-windows-10/). Essentially we are making sure you have JAVA_HOME environment variable to be set




##### ONE LINE of bash script that builds the compiler and ONE LINE that runs the runtime.

Assumption: the code is expected to be in data folder of the project

To generate only a intermediate code representation, you can use the following gradle task:
```
 $ ./gradlew build executeCompiler -PInfFileName=<InfinityFileName>
```

For example:

```
$ ./gradlew build executeCompiler -PInfFileName=pattern.inf

```

To run the bytecode using Infinity run time use the following gradle task:

```
$ ./gradlew build executeRuntime -PInfFileName=<ByteCodeOfInifnity>
```

for example:

```
./gradlew build executeRuntime -PInfFileName=pattern.inf.byte
```

