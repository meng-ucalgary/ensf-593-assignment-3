# a3-loops-strings
Working with loops for computation and strings.

This assignment has two mandatory parts:
- [1. Calculating Square Root](#1-calculating-square-root)
- [2. Secret Word](#2-secret-word)

and four optional parts (not graded):
- [Newton GUI](#optional-newton-gui)
- [Prime Number GUI](#optional-prime-number-gui)
- [Pig Latin](#optional-pig-latin)
- [Verifying Math](#optional-verifying-math)

# 1. Calculating Square Root
**Problem Statement**

Newton's method for calculating the square root of `N` starts by making a (non zero) guess at the square root. It then uses the original guess to calculate a new guess, according to the following formula:

```java
guess = (( N / guess) + guess) / 2 ;
```

No matter how wild the original guess is, if we repeat this calculation the algorithm will eventually find the square root of `N`.

Design a Java program that let's the user input a number N, a maximum error that determines the difference between two consecutive Newton computations, and the user's initial guess. Then calculate the square root using Newton's method and report both the square root and the number of guesses required to calculate it.

**Object Decomposition and Class Design**

What objects will your solution use? Follow the design from last assignment: An `App` class, let's call it `NewtonApp` uses a `KeyboardReader` (already given) for input/output and a computational object to implement Newton's method.  Let's call the computational object `NewtonTester`. For `NewtonApp` and `NewtonTester`, draw their UML class diagrams showing class name, instance variables, and public and private methods. Show relationships between classes, including `KeyboardReader` (without instance variables and methods).

One public method that your `NewtonTester` class should have is the `sqrt()` method. This is the method that the command line UI will call to calculate the square root of `N`.

Don't forget that your `NewtonTester` object must not only be able to calculate the square root of a number that it is given, it must also remember how many iterations it took to calculate the square root. It must also "know" what the tolerance is and what the initial guess is in order to perform its calculation. 

**Method design**

For this project your UI class and methods can be modeled after the command line UIs you designed in the previous lab. The constructor method should instantiate the UI components. The `run()` method should implement the dialog: input the values that the user typed and pass them to the `NewtonTester` object to perform the calculation.

For the `NewtonTester` you'll need methods to set and get the values of certain instance variables -- e.g., the number of iterations used -- as well as the method to calculate the square root.

**Algorithm design**

To design the dialog, start by writing an example on paper.

The algorithm for the `NewtonTester` object's `sqrt()` method, start by write out pseudocode description. Remember, in addition to calculating the square root, the square root method should also keep track of how many iterations were required. 

**Implementation **

Use the stepwise refinement approach as you develop your code, compiling and testing short segments of your code at each stage. Commit working portions to your git repository with meaningful messages.

 Here are some appropriate steps:

- Create the command line UI, with constructor. Compile and Test.
- Implement the dialog in the command line UI's `run()` method, initially just echoing the user's input. Compile and Test.
- Create the `NewtonTester` object and test passing a value between the UI and its `sqrt()` method. The `sqrt()` method can just return the value it is passed for this stage. Compile and Test.
- Develop and test the square root algorithm.

**Reporting**

In a markdown file `Newton.md` add the UML class diagram you drew as an embedded image. Include a screenshot demonstrating successful execution and outputs for at least 3 numbers. Explain why you chose these numbers for your test.  

# 2. Secret Word
**Problem Statement**

Write a class that manages the String processing for an GUI that lets the user make repeated guesses at the letters contained in a secret word. The secret word is shown in masked form. For example, if the secret word is `hello`, it would be displayed as `*****`. Each time the user makes a guess, the GUI reports whether the guess is correct or not and displays the updated version of the secret word. For example, if on the first guess the user guesses `'e'`, the secret word would be displayed as `*e***`.

**GUI Specifications**

ELements and layouts of the GUI are implemented in `src/SecretWordGUI.java`.

**Design Specifications**

You need two Java classes for this project.

`SecretWordGUI` provides the graphical user interface. To save time and help focus on designing and implementing the `SecretWord` class, you are given the GUI interface. The GUI's `actionPerformed()` method uses methods of the `SecretWord` class.

The class, `src/SecretWord.java`, will be responsible for managing the secret word. You must design and implement the following elements for the `SecretWord` class:

  * A private String variable named `secretWord` initialized to a word of your choice. This string will contain the secret word against which the user's guesses will be compared.
  * A private String variable named `displayedWord`. This is the string that will be displayed in the GUI interface.
  * A public method named `getDisplayedWord()` will return the `displayedWord`. For example, if the game just started and the secret word is `"hello"`, this method would return `"*****"`.
  * A public method named `getSecretWord()` returns the `secretWord`.
  * The `replaceChars()` method takes two parameters, a String and a char. It replaces every character in the string with the char and returns the result. For example, `replaceChars("hello", '*')` will return `"*****"`.
  * The `SecretWord()` constructor should assign a string literal to the `secretWord` variable, and it should invoke the `replaceChars()` method to replace all the letters in secretWord with asterisks and assign the result to `displayedWord`.
  * The `replaceChars(String s1, String s2, char ch)` method replaces in `s2` every occurrence of `ch` in `s1`. For example, `replaceChars("hello", "*e***", 'l')` would return `"*ell*"`.
  * The `makeGuess(char ch)` method tests whether its char parameter is contained in `secretWord`. If so it updates the `displayedWord`, revealing the position(s) of the guessed letter, and returns true; otherwise it returns false. For example, if the secret word is `"hello"`, `makeGuess('e')` would return true and would update the displayed word to `"*e***"`.

**Implementation: Step-wise refinement**
1. Draw a UML diagram for the `SecretWordGUI` and `SecretWord` classes.
2. A good first step for this problem is to create a stub version of the `SecretWord` class. The stub version must contain stub definitions of all of the `SecretWord` methods that are called from `SecretWordGUI`.
3. Study the algorithm used in the `SecretWordGUI`. Initially the GUI displays the masked secret word in its text area. Each time the user types a return in the input text field, the GUI inputs the user's guess and calls the `SecretWord.makeGuess()` method. The GUI then displays an appropriate message and the updated secret word.
4. Implement and test the `replaceChars(String, char)` method.
5. Implement and test the `makeGuess()` method.
6. Implement and test the `replaceChars(String, String, char)` method. This method is the most challenging part. Before starting to work on this method, you should develop the algorithm on paper.

**Reporting**

In a markdown file `SecretWord.md` add the UML class diagram you drew as an embedded image. Include a screenshot demonstrating successful execution and outputs of a guessing interaction. 

# Optional: Newton GUI
Instead of a command line interface, design a graphical user interface to use the `NewtonTester` class in problem 1.

In addition to the GUI, make the following changes:
- Validating input, number and initial guess need to be positive.
- Add the *gold standard* value of `Math.sqrt()` for comparison.

Rename your class to `NewtonTester2`.

# Optional: Prime Number GUI
Write a Java GUI that prompts the user for a positive integer and then displays all of the prime numbers less than or equal to the user's integer.

How many classes do you need? What are their designs?

# Optional: Pig Latin
Write a Java GUI that translates an English sentence or expression into Pig Latin https://en.wikipedia.org/wiki/Pig_Latin. The rules of Pig Latin are:

* If the word begins with a consonant -- such as `"string"` `"Latin"` -- divide the word at the first vowel, swapping the front and back halves and append `"ay"` to the word -- `"ingstray,"` `"atinLay."`.
* If the word begins with a vowel -- such as `"am,"` `"are,"` `"i"` -- append `"yay"` to the word -- `"amyay,"` `"areyay,"`, `"iyay."`.
* If the word has no vowels (other than `'y'`) -- such as `"my,"` `"thy"` -- append `"yay"` to it -- `"myyay,"` `"thyyay."`

# Optional: Verifying Math
Starting at minute 57 in this video https://www.youtube.com/watch?v=QvuQH4_05LI Grant Sanderson of 3blue1brown shows how he uses Python to verify if his solution to a probability problem is correct.

Using `Math.random()` and loops can you verify the solution in Java following the spirit of his Python implementation? The idea is not to use arrays or any advanced packages.