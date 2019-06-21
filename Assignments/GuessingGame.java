import java.util.Scanner;
import java.util.Random;

/*INSTRUCTIONS
Make an app called GuessingGame.
It should use the command prompt, not appletviewer.
When the game starts, the computer should have a random number between 1 and 100.
It should tell the user to guess.  Probably should indicate the numberical limits. (System.out.print)
Computer takes numerical input.  See below.
Based on what the user guesses, the computer should provide hints.  Probably whether the user should guess bigger or smaller.
Computer takes input & continues to respond with hints until the user guesses correctly.
The computer should indicate success, tell the user how many tries they took, and comment, ideally in a humorous way.
The computer offers to play again and prompts the user to type a number to express their desire (Y, N, y, n, Yes, No, YES, NO, yes, no).
What if the user doesn't type what your'e expecting?
Bonus: every time you (re)start the game, the computer offers easy or hard mode.  Hard mode should require more guesses because there are more possible numbers.
Always comment your code.
App tools you should learn during this lesson: Random, Scanner, if, loops, and Exceptions.*/

//Basic input is achieved with the following:
String input; //or whatever your variables are named
Scanner sc = new Scanner(System.in); //or you can name it something other than sc
input = sc.nextLine(); //if you name your Scanner something else, replace this sc

//Numberical input is achieved with the following:
int num1; //or whatever your variables are named
Scanner sc = new Scanner(System.in);
try {
  num1 = Integer.parseInt(sc.nextLine());
}
catch (Exception e) {}

//IMPORTANT: You should only declare & initialize one Scanner per code.  Use that same scanner for every sc.nextLine() or Integer.parseInt(sc.nextLine());

/*What is a try/catch statement?
Exceptions happen when the user does something they're not supposed to.
If you don't try/catch, then the program will shut down as soon as the exception happens.
In this case, an Exception would be if your user typed something that wasn't a number.
Should you make the computer say something snarky if an exception is found?  There's brackets after catch if so.*/

//Food for thought 1: What do you think Integer.parseInt(String) does?
//Food for thought 2: Do Scanner and Random seem similar in how they're coded?  Why do you think that is?
