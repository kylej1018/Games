/*Download the Arrays.zip in the "homework" section of this Github.
Fix the FIXME line to reflect where you saved it.
Complete all these assignments.  You're encouraged to use System.out.print and println often for debugging - use it to see if your variables are actually what you expect.  Use it to see if you can even reach that part of the code or if it gets stuck before.
*/
import java.io.*;
import java.util.*;
public class Loops {
	public static String loc = "C:\\Users\\kylej\\Desktop\\"; \\FIXME
	public static void main (String [] args) {

		/*LESSON 1 things to know before starting:
		So, variables are great.  Ints, Strings, doubles, all that.  But how do they interact?
		If you put an int and a double in the same equation, the answer is a double.  If you print 10/5.0, the answer is 2.0, not 2.
		What if you really wanted that to be an int?  You typecast like so: (int)(10/5.0) produces 2, not 2.0
		You could typecast variables as well. a = 0.0; (int)a will give you 0.
		What will be your output if you divide 7/2?  It's not 3.5, so you should try it.
		But Strings take priority.  If you print 1+2, you'll get 3.  If you print 1.0 + "2", you'll get "1.02".

		Math operators.  +, -, *, and / are pretty self-explanatory.  ^ (power) does not exist.  % is cool, it gives you the remainder when two numbers are divided, like how 9%5 is 4.
		Sometimes you don't want to re-initialize an int variable, you just want it to change value.
		You can do i *= 2, which is like saying i = i*2.
		i -= 5 subtracts 5 from i.
		i += 1 increments i by 1 but most programmers will just say i++;

		Loops.
		Sometimes you want to do something a bunch of times.  There are two loops to do that with, called for-loops and while-loops.
		For-loops execute a set number of times.  They look like this:
		for(int i = 1; i <= 100; i += 2) {
			//do code
		}
		The first bit establishes the iteration variable i, which starts at 1.  It will keep track of which loop we are on.
		The second bit is a boolean that must be true for the loop to execute - i must be less than or equal to 100.
		The third bit happens every time the loop completes - i increments by 2.
		Thus, this loop will happen fifty times.  On the fifty first time, i will go from 99 to 101 and the loop will "break" and the code will continue.
		It is very good to have loops break.  If they run forever, life sucks.

		While-loops execute "while" the condition is true.  They look like this:
		while(i <= 100) {
			//do code
		}
		So you probably need to make i get bigger inside the loop, or else it will never break.
		Every for loop can be replaced with a while loop (although for loops, it's easier to read what you expect).
		Not every while loop can be replaced with a for loop.  Sometimes you just don't know how much you need to do something.  There is at least one of these in LESSON 1's assignments.

		Here's a loop for you to run:
			for(int i = 0; i > -1800000000  || i < -1900000000; i = i + 50000) {
				System.out.println(""+i);
			}
		What happened?  Your computer reached its maximum size limit.  It can only think about 2,147,483,647 things before it runs out of bits and has to reset in this very strange way.
		Look up the Year 2038 problem.  What does that have to do with this number?

		Random.  A random number generator is made with Random r = new Random();  You can assign a variable to r.nextInt() and that variable will have been randomly generated.  Please only make one Random r per code.
		
		Before each operation, System.out.print the task number.
		Please print these operations in complete sentences, like "66 + 44 = 100" so you can tell when your math is wrong.

		*/
		Random r = new Random();
		//#1. Sum two random numbers <= 1000
		//#2. Subtract two random numbers <= 1000
		//#3. Multiply two random numbers <= 100
		//#4. Divide two doubles <= 1000
		//#5. Divide two ints <= 1000 and print quotient and fraction remainder ("50/9 = 5 5/9")
		//#6. Raise a random number <=10 to the power of another number <= 10
		//#7. Find the factorial of a random number <= 15
		//#8. Find Fibonacci sequence up to a random number of iterations <= 20 (0, 1, 1, 2, 3, 5, 8, 13, 21...) (look up what this sequence is)
		//#9. Find the Collatz sequence of a number <= 50 (look up what this is)

		/*LESSON 2 things to know before starting:
		Before each transformation, System.out.print the task number.
		Sometimes you need lots of variables remembered.  We store them in a list called an "array."
		Making an array of ints named "arr" is not too hard.  Check it out:
		int [] arr = new int[10];
		The [10] means that this list has 10 numbers.  You need to know how big your array is right when you make it.

		You can figure out how long an unknown array is with int size = arr.length
		You can access an element in an array with int x = arr[5], which returns the element at Place 5.
		Here's the rub.  Place 5 is not the fifth place.
		ARRAYS START AT 0.  The first element is arr[0].  The second element is arr[1], and so on.
		There is nothing at arr[arr.length].  If you have an array with length 3, its indexes are 0, 1, and 2.  There is no 3.
		The last element is at arr[arr.length - 1].
		
		I've made some example arrays.  Do not change anything in these arrays; you will use them throughout this code.  Make a new array and if needed, use a loop to copy the elements over.
		
		Finally, when you want to print the contents of an array, use printArray(arr).  I made it for this code, it won't work in other codes.
		*/

		int [] sortedIntArray1 = populateNum("sortedIntArray1"); //these three lines populate some example arrays for you to work with.  Don't mess with them.
		int [] sortedIntArray2 = populateNum("sortedIntArray2");
		int [] unsortedIntArray = populateNum("unsortedIntArray");
	
		//#10. Make an array containing only the smallest and largest numbers in unsortedIntArray {1, 5, 3, 8, 9, 2, 1, 4, 0} --> {0, 9}
		//#11. Make an array where each index is a number equal to sum of all numbers in unsortedIntArray...excluding unsortedIntArray at that index {1, 2, 3, 4, 11} --> {20, 19, 18, 17, 10}
		//#12. Choose a random number from 2,25 and make an array that lists all its factors, without extra zeroes {10} --> {1, 2, 5, 10}
		//#13. Merge sortedIntArray1 and sortedIntArray2 into a new array {1, 2, 5, 6, 9} + {1, 4, 5, 6, 8} --> {1, 1, 2, 4, 5, 5, 6, 6, 8, 9}
		//#14. Make a new array identical to unsortedIntArray1, except consecutive duplicates are deleted {1, 4, 9, 2, 2, 0} --> {1, 4, 9, 2, 0}

		/*LESSON 3 things to know before starting:
		Kinda sucks that sometimes you don't know how long an array is before starting.  That's why we have ArrayLists.
		ArrayList <String> arr = new ArrayList<String>();
		Then if you want to add something, it looks like arr.add("My first list!"); and will be added to the end.
		If you want to add it at a certain index (say 0), it looks like arr.add(0, "This is added at the first spot, which is index 0"); which will shift everything after it down.
		If you want to remove something at a certain index (say 0), it looks like arr.remove(0)
		The first element is arr.get(0), the second element is arr.get(1), and so on.
		How big is it?  arr.size() will tell ya!

		Why don't we use ArrayLists all the time???
		The answer is that there are different kinds of variables.  Ints, doubles, chars, and booleans are all "primitive" variables.
		Which basically only means they can't get stored in an ArrayList.
		What can you store in an ArrayList?  Strings.  Colors.  Even other arrays or ArrayLists.

		One last thing you'll need to know.  We talked about arrays [] as a list of things, often numbers.
		You can have two-dimensional arrays.  They look like this.
		int [][] arr = new int [3][5]; makes a 3x5 grid.
		You access the first element at arr[0][0] and the last one at arr[2][4].
		You could even have three, four, or higher dimensional arrays.  However you like to store your data.
		*/

		//#15. Take sortedIntArray1 and randomize it in a new array.
		//#16. "extractsort" unsortedIntArray. The next smallest element goes to the end in new array {1, 4, 2, 3} --> {} {1} {1, 2} {1, 2, 3} {1, 2, 3, 4}
		//#17. "bubblesort" unsortedIntArray. Trade misplaced duos. {1, 4, 2, 3, 1} --> {1, 2, 4, 3, 1} {1, 2, 3, 4, 1} {1, 2, 3, 1, 4} {1, 2, 1, 3, 4} {1, 1, 2, 3, 4}
		//#18. "countsort" unsortedIntArray  Find range & make a 2D array.  First dimension = all ints in range.  In second dimension, number of occurrences of each int.
			//{1, 5, 1, 6, 2, 2, 3, 1, 5} --> {1, 2, 3, 4, 5, 6} --> {1, 1, 1, 2, 2, 3, 5, 5, 6}
			//				  {3, 2, 1, 0, 2, 1}

		/*LESSON 4 things to know before starting:
		You could argue that Strings are really just arrays of chars.  I'm going to teach you a few nice tools.
		String s = "apple".
		You can do s.length(), which sould be 5 in this case.
		You can find the char at an index with s.charAt(0), which would be 'a' in this case (yes, Strings start at 0 too).
		You can find the first index of a smaller String with s.indexOf("p"), which would be 1 in this case.
		You can even alphabetize Strings with s1.compareTo(s2).  If the answer is > 0, s1 is first alphabetically.  If the answer is < 0, s2 is.

		Finally, it'd be nice to ask if two Strings are the same.
		String s2 = "apple".
		But if you test s1 == s2, the answer is false.  Here's why.
		Remember how we said there are primitive variables?  If you compare them with ==, it's going to ask if they have the same VALUE.
		Strings are not primitive.  If you compare them with ==, it's going to ask if they are the same OBJECT.  Which they aren't.
		s1 and s2 are stored in totally different places in your computer.  They're different objects.
		The way around this is to test if s1.equals(s2), which will return true if they have the same text and false if not.
		Beware of setting things equal to one another if they're not primitive!!
		If you make a new array named arr2 but you do it like this:
		int [] arr2 = arr1;
		that's bad.  Every time you change something in arr1, it will change in arr2 also.  Your computer has assigned them the same object.
		You're better off making a loop to copy each element of arr1 over to arr2 after saying arr2 = new int[arr1.length];
		*/

		ArrayList <String> stringArray1 = populateStr("StringArray1"); //more example arrays.  Don't mess with them.
		ArrayList <String> stringArray2 = populateStr("StringArray2");
		ArrayList <String> keywordCipher = populateStr("KeywordCipher");

		//#19. Find and delete duplicates in stringArray1 {abc, def, ghi, jkl, abc, mno} --> {abc, def, ghi, jkl, mno}
		//#20. Add elements to stringArray2 so all have same number of entries as letters in name {a, bc, def, gh} --> {a, bc, bc, def, def, def, gh, gh}
		//#21. Create an arraylist spelling numbers in unsortedIntArray {1, 2, 3, 4} --> {one, two, three, four}
		//#22. Alphabetize stringArray2 "insertsort", where the next element is placed in a new array between already alphabetically organized words.
		//#23. Invert each word in stringArray2 {the quick brown fox} --> {eht kciuq nworb xof}
		//#24. Make an array of only the palindromes in stringArray2

		/*LESSON 5 things to know before starting:
		We're using Scanner.  Refer to Guessing_Game if you need a refresher on how to get user-generated Strings and numbers.  You'll use parseInt here.
		You can make a string all the same case with s.toUpperCase() or s.toLowerCase();
		You can split off part of a string at a certain index.
		s.substring(2) will be "ple", or from index 2 to the end of s.
		s.substring(0, 2) will be "ap", or from index 0 to right before index 2.
		*/

		Scanner s = new Scanner(System.in);

		//#25. Prompt user input.  Print out the same thing but replace all O/o with 0, E/e with 3, L/l with 1, and S/s with 5
		//#26. Prompt user input. Alphabetize each word in the sentence but don't reverse the whole sentence. {the quick brown fox} --> {eht cikqu bnorw fox}
		//#27. Prompt user input and perform a reverse cipher
			//original: ABCDEFGHIJKLMNOPQRSTUVWXYZ
			//coded:    ZYXWVUTSRQPONMLKJIHGFEDCBA
		//#28. Prompt two user inputs.  The second is a number to dictate advancement of the first in an advance cipher.
			//original:  ABCDEFGHIJKLMNOPQRSTUVWXYZ
			//coded (3): XYZABCDEFGHIJKLMNOPQRSTUVW
		//#29. Prompt two user inputs.  The second is a keyword to encode the first in a keyword cipher.
			//original: ABCDEFGHIJKLMNOPQRSTUVWXYZ
			//coded:    SKELINGTOABCDFHJMPQRUVWXYZ (keyword = SKELLINGTON, but you can't have duplicate letters)
		//#30. Identify the keyword in Kyle's keyword cipher.  The encoded phrase is the first element in keywordCipher.  The remaining elements in the list are possible keywords you'll have to try.  Only one will make a coherent sentence.  Print the keywords and their sentences.
	}

	public static int [] populateNum(String s) { //this is how the computer reads the text files.  Don't mess with this.
		ArrayList <String> arr1 = populateStr(s);
		int [] arr2 = new int[arr1.size()];
		for(int i = 0; i < arr1.size(); i++) {
			arr2[i] = Integer.parseInt(arr1.get(i));
		}
		return arr2;
	}

	public static ArrayList <String> populateStr(String s) { //this is how the computer reads the text files.  Don't mess with this.
		ArrayList <String> arr = new ArrayList<String>();
		String loc2 = loc + "\\" + s + ".txt";
		try {
			File f = new File(loc2);
			BufferedReader br = new BufferedReader(new FileReader(f));
			String input = br.readLine();
			while(input != null) {
				arr.add(input);
				input = br.readLine();
			}
		}
		catch(Exception e) {}
		return arr;
	}

	public static void printArray (int [] arr) { //this prints your arrays for you
		for(int i = 0; i < arr.length; i++) {
			System.out.print(" "+arr[i]);
		}
		System.out.println();
	}

	public static void printArray (ArrayList <String> arr) { //this prints your arrays for you
		for(int i = 0; i < arr.size(); i++) {
			System.out.print(" "+arr.get(i));
		}
		System.out.println();
	}
}
