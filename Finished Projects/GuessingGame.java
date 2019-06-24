import java.util.Scanner;
import java.util.Random;

public class GuessingGame { 
	public static void main (String [] args) {
		
	
	Random r = new Random();
	int goal = r.nextInt(99) + 1;
	int i = 0;
	int guess = -1;
	boolean isInt = false;
	Scanner sc = new Scanner(System.in);
	String [] snarkyArray = {"N-U-M-B-E-R.", 
				"Was I not being clear before?", 
				"You're going to be stuck in this part of the code until you follow the rules.", 
				"Some people just don't listen.", 
				"If I have to say number one more time...", 
				"The arrogance of some people.", 
				"Hey, smart ass. Just type a number.", 
				"Where did you learn to count? Dy5lex1@: School for the Gifted?", 
				"It's like talking to a brick wall. Type a frickin number, pal.", 
				"Trying to get you to type a number is not good for my blood pressure."};
	String [] triesArray1 = {"Well fuck me sideways and call me bob. That was pretty good.", 
				"Good job, man! It's people like you who bring back my faith in the world.", 
				"Somebody ate his cornflakes this morning. ;)", 
				"Your mom would be proud."};
	String [] triesArray2 = {"That wasn't /bad/. It wasn't good either...", 
				"You know what they say: C's get degrees.", 
				"A for effort.", 
				"I got a little bored while you were guessing, but you got it eventually."};
	String [] triesArray3 = {"There has to be people like you in the world to make others grateful that they're not dumb.", 
				"Hah. Yeah. Ok. You \"won.\"", 
				"Honestly, that went on waaaaay longer than I was willing to sit through. Next time you get three tries, then I'm going to bed.", 
				"I'm sorry. You were taking so long, I went to Starbucks. Are you done now?"};
	String [] idiotArray = {"You're kidding me, right?",
				"Have we not gone over this before?", 
				"I feel like a goddamn broken record.", 
				"If I have to tell you to follow directions one more time, I'm not going to let you play again..."};
	int w = r.nextInt(9);
	int x = r.nextInt(3);
	boolean startOver = true;

	
		System.out.println("Guess a number between 1 and 100.");
		System.out.println("Also, based on the type of people who have done this before you, I'm just going to emphasize NUMBER.");
	while (startOver == true) {
		System.out.println(" ");
		System.out.print("Type a fucking number: ");

		while (guess != goal) {
			while (isInt == false) {
				try {
				  guess = Integer.parseInt(sc.nextLine());
				  isInt = true;
				}
				catch (Exception e) {System.out.println(snarkyArray[w]);}
				w = r.nextInt(9);
				}

			if (guess > goal) {
				System.out.print("Lower: ");}
			else if (guess < goal) {
				System.out.print("Higher: ");}
			else {
				System.out.print("Huzzah.");}
			isInt = false;
			i++;
		}

		System.out.print("It took you " + i + " tries to get it right. ");
		if (i <= 5) {
			System.out.println(triesArray1[x]);}
		else if (i <= 8) {
			System.out.println(triesArray2[x]);}
		else if (i > 8) {
			System.out.println(triesArray3[x]);}

		guess = -1;
		boolean idiot = true;
			while (idiot == true) {
				System.out.println("Do you want to play again? Yes or No: ");
				String again = (sc.nextLine());
				if (again.equals("Yes")) {
					startOver = true;
					idiot = false;
					goal = r.nextInt(99) + 1;}
				else if (again.equals("No")) {
					startOver = false;
					idiot = false;
					goal = r.nextInt(99) + 1;}
				else if (!again.equals("Yes")) {
					System.out.println(idiotArray[x]);
					idiot = true;
					x = r.nextInt(3);}
				else if (!again.equals("No")) {
					System.out.println(idiotArray[x]);
					idiot = true;
					x = r.nextInt(3);}
			}
	}	
}
}

//*INSTRUCTIONS
//Computer takes numerical input.  See below.
//Based on what the user guesses, the computer should provide hints.  Probably whether the user should guess bigger or smaller.
//Computer takes input & continues to respond with hints until the user guesses correctly.
//The computer should indicate success, tell the user how many tries they took, and comment, ideally in a humorous way.
//The computer offers to play again and prompts the user to type a number to express their desire (Y, N, y, n, Yes, No, YES, NO, yes, no).
//What if the user doesn't type what your'e expecting?
//Bonus: every time you (re)start the game, the computer offers easy or hard mode.  Hard mode should require more guesses because there are more possible numbers.
//Always comment your code.
//App tools you should learn during this lesson: Random, Scanner, if, loops, and Exceptions.*/

//Basic input is achieved with the following:
//String input; //or whatever your variables are named
//Scanner sc = new Scanner(); //or you can name it something other than sc
//input = sc.nextLine(); //if you name your Scanner something else, replace this sc

//Numberical input is achieved with the following:
//int num1; //or whatever your variables are named
//Scanner sc = new Scanner();
//try {
  //num1 = Integer.parseInt(sc.nextLine());
//}
//catch (Exception e) {}

//IMPORTANT: You should only declare & initialize one Scanner per code.  Use that same scanner for every sc.nextLine() or Integer.parseInt(sc.nextLine());

//*What is a try/catch statement?
//Exceptions happen when the user does something they're not supposed to.
//If you don't try/catch, then the program will shut down as soon as the exception happens.
//In this case, an Exception would be if your user typed something that wasn't a number.
//Should you make the computer say something snarky if an exception is found?  There's brackets after catch if so.*/

//Food for thought 1: What do you think Integer.parseInt(String) does?
//Food for thought 2: Do Scanner and Random seem similar in how they're coded?  Why do you think that is?