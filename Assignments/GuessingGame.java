import java.util.Scanner;
import java.util.Random;

/*INSTRUCTIONS
Make an app called GuessingGame.  You should have figured out by now how to make the line about "public class".  Do not use KeyListener or MouseListener.
It should use System.out.print and Scanner and be entirely coded within
public static void main(String[] args) {
  //all your code here
}
When the game starts, the computer should have a random number between 1 and 100.
It should tell the user to guess.  Probably should indicate the numberical limits. (System.out.print)
Computer takes numerical input.  See below.
Based on what the user guesses, the computer should provide hints.  Probably whether the user should guess bigger or smaller.
Computer takes input & continues to respond with hints until the user guesses correctly.
The computer should indicate success, tell the user how many tries they took, and comment, ideally in a humorous way.
The computer offers to play again and prompts the user to respond (Y, N, y, n, Yes, No, YES, NO, yes, no).
What if the user doesn't type what your'e expecting?
Bonus: every time you (re)start the game, the computer offers easy or hard mode.  Hard mode should require more guesses because there are more possible numbers.
Always comment your code.

Other than Loops, most programs we've run so far use a popup JFrame window.  You'll see the words JFrame and JPanel in PaintPalette, PrettyLines, and Picture.  Not here.
That means we can't introduce a keyListener to this program.  We'll use scanner instead.
Most programs we run have a myPaint area.  Not here, we have a System.out.print instead.
Scanner and System.out.print are much easier to understand than the JFrame and keyListener.  But they don't look nearly as nice, so we use them for exercises and debugging rather than actual game content.
String input from the user is achieved with the following:*/
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
