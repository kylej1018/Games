import java.io.*;
import java.util.*;
public class Loops { //does NOT use appletviewer.
	public static String loc = "C:\\Users\\kylej\\Desktop\\Games\\Java\\sofiacode\\Arrays"; \\FIXME
	public static void main (String [] args) {

		//LESSON 1

		Random r = new Random();
		
		//Before each operation, System.out.print the task number.
		//Please print these operations in complete sentences, like "66 + 44 = 100" so you can tell when your math is wrong.

		//#1. Sum two random numbers <= 1000
		//#2. Subtract two random numbers <= 1000
		//#3. Multiply two random numbers <= 100
		//#4. Divide two doubles <= 1000
		//#5. Divide two ints <= 1000 and print quotient and fraction remainder ("50/9 = 5 5/9")
		//#6. Raise a random number <=10 to the power of another number <= 10
		//#7. Find the factorial of a random number <= 15
		//#8. Find Fibonacci sequence up to a random number of iterations <= 20 (0, 1, 1, 2, 3, 5, 8, 13, 21...)
		//#9. Find the Collatz sequence of a number <= 50

		//LESSON 2

		int [] sortedIntArray1 = populateNum("sortedIntArray1"); //these three lines populate some example arrays for you to work with.  Don't mess with them.
		int [] sortedIntArray2 = populateNum("sortedIntArray2");
		int [] unsortedIntArray = populateNum("unsortedIntArray");

		//Before each transformation, System.out.print the task number.
		//Make a new array in each operation so you leave the original unaltered.
		//Use printArray(myarray); in your code after each operation to print each element in your new array.  Put the name of your array in the parentheses.

		//#10. Make an array containing only the smallest and largest numbers in unsortedIntArray {1, 5, 3, 8, 9, 2, 1, 4, 0} --> {0, 9}
		//#11. Make an array where each index is a number equal to sum of all numbers in unsortedIntArray...excluding unsortedIntArray at that index {1, 2, 3, 4, 11} --> {20, 19, 18, 17, 10}
		//#12. Choose a random number from 2,25 and make an array that lists all its factors, without extra zeroes {10} --> {1, 2, 5, 10}
		//#13. Merge sortedIntArray1 and sortedIntArray2 into a new array {1, 2, 5, 6, 9} + {1, 4, 5, 6, 8} --> {1, 1, 2, 4, 5, 5, 6, 6, 8, 9}
		//#14. Make a new array identical to unsortedIntArray1, except consecutive duplicates are deleted {1, 4, 9, 2, 2, 0} --> {1, 4, 9, 2, 0}

		//LESSON 3

		//#15. Take sortedIntArray1 and randomize it in a new array.
		//#16. "extractsort" unsortedIntArray. The next smallest element goes to the end in new array {1, 4, 2, 3} --> {} {1} {1, 2} {1, 2, 3} {1, 2, 3, 4}
		//#17. "bubblesort" unsortedIntArray. Trade misplaced duos. {1, 4, 2, 3, 1} --> {1, 2, 4, 3, 1} {1, 2, 3, 4, 1} {1, 2, 3, 1, 4} {1, 2, 1, 3, 4} {1, 1, 2, 3, 4}
		//#18. "countsort" unsortedIntArray  Find range & make a 2D array.  First dimension = all ints in range.  In second dimension, number of occurrences of each int.
			//{1, 5, 1, 6, 2, 2, 3, 1, 5} --> {1, 2, 3, 4, 5, 6} --> {1, 1, 1, 2, 2, 3, 5, 5, 6}
			//				  {3, 2, 1, 0, 2, 1}

		//LESSON 4

		ArrayList <String> stringArray1 = populateStr("StringArray1"); //more example arrays.  Don't mess with them.
		ArrayList <String> stringArray2 = populateStr("StringArray2");
		ArrayList <String> keywordCipher = populateStr("KeywordCipher");

		//#19. Find and delete duplicates in stringArray1 {abc, def, ghi, jkl, abc, mno} --> {abc, def, ghi, jkl, mno}
		//#20. Add elements to stringArray2 so all have same number of entries as letters in name {a, bc, def, gh} --> {a, bc, bc, def, def, def, gh, gh}
		//#21. Create an arraylist spelling numbers in unsortedIntArray {1, 2, 3, 4} --> {one, two, three, four}
		//#22. Alphabetize stringArray2 "insertsort", where the next element is placed in a new array between already alphabetically organized words.
		//#23. Invert each word in stringArray2 {the quick brown fox} --> {eht kciuq nworb xof}
		//#24. Make an array of only the palindromes in stringArray2

		//LESSON 5

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
