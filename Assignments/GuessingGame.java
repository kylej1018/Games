Make an app called GuessingGame.
It will need a random variable and a scanner, just like Loops, which should clue you into which import statements you need.
It should use the command prompt, not appletviewer.
When the game starts, the computer should have a random number between 1 and 100.
It should tell the user to guess.  Probably should indicate the numberical limits.
Computer takes numerical input.  This is achieved with the following:

int n;
Scanner sc = new Scanner(); //or you can name it something other than sc
n = sc.nextInt();

Based on what the user guesses, the computer should provide hints.  Probably whether the user should guess bigger or smaller.
Computer takes input & continues to respond with hints until the user guesses correctly.
The computer should indicate success, tell the user how many tries they took, and comment, ideally in a humorous way.
The computer offers to play again and prompts the user to type a number to express their desire (1 or 0).
Bonus: every time you (re)start the game, the computer offers easy or hard mode.  Hard mode should require more guesses because there are more possible numbers.

Food for thought: You notice how similar Scanner and Random are in how they're coded?  Why do you think that is?
