/*
 * Fix the FIXME line to reflect where you saved the Arrays folder.
 * Complete all these assignments.  Print the task # before each answer.
 * Do not change anything in these arrays.
 * Use printArray(arr) to print the contents of an array or ArrayList.  Remember that this command will not work for other codes.
*/
import java.io.*;
import java.util.*;
public class Loops5 {
	public static String loc = "C:\\Users\\kylej\\Desktop\\"; \\FIXME
	public static void main (String [] args) {
		// These three lines populate some example arrays for you to work with.  Don't mess with them.
		int [] sortedIntArray1 = populateNum("sortedIntArray1");
		int [] sortedIntArray2 = populateNum("sortedIntArray2");
		int [] unsortedIntArray = populateNum("unsortedIntArray");
		ArrayList <String> stringArray1 = populateStr("StringArray1"); // more example arrays.  Don't mess with them.
		ArrayList <String> stringArray2 = populateStr("StringArray2");
		ArrayList <String> keywordCipher = populateStr("KeywordCipher");

		Scanner sc = new Scanner(System.in);
    
		// #25. Prompt user input.  Translate the input to Pig Latin and print it out.
		// #26. Prompt user input. Alphabetize each word in the sentence but don't reverse the whole sentence. {the quick brown fox} --> {eht cikqu bnorw fox}
		// #27. Prompt user input and perform a reverse cipher
			// original: ABCDEFGHIJKLMNOPQRSTUVWXYZ
			// coded:    ZYXWVUTSRQPONMLKJIHGFEDCBA
		// #28. Prompt two user inputs.  The second is a number to dictate advancement of the first in an advance cipher.
			// original:  ABCDEFGHIJKLMNOPQRSTUVWXYZ
			// coded (3): XYZABCDEFGHIJKLMNOPQRSTUVW
		// #29. Prompt two user inputs.  The second is a keyword to encode the first in a keyword cipher.
			// original: ABCDEFGHIJKLMNOPQRSTUVWXYZ
			// coded:    SKELINGTOABCDFHJMPQRUVWXYZ (keyword = SKELLINGTON, but you can't have duplicate letters)
		// #30. Identify the keyword in Kyle's keyword cipher.  The encoded phrase is the first element in keywordCipher.  The remaining elements in the list are possible keywords you'll have to try.  Only one will make a coherent sentence.  Print the keywords and their sentences.
  }
    
	public static int [] populateNum(String s) { // this is how the computer reads the text files.  Don't mess with this.
		ArrayList <String> arr1 = populateStr(s);
		int [] arr2 = new int[arr1.size()];
		for(int i = 0; i < arr1.size(); i++) {
			arr2[i] = Integer.parseInt(arr1.get(i));
		}
		return arr2;
	}

	public static ArrayList <String> populateStr(String s) { // this is how the computer reads the text files.  Don't mess with this.
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
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return arr;
	}
    
  public static void printArray (int [] arr) { // this prints your arrays for you
		for(int i = 0; i < arr.length; i++) {
			System.out.print(" "+arr[i]);
		}
		System.out.println();
	}

	public static void printArray (ArrayList <String> arr) { // this prints your arrays for you
		for(int i = 0; i < arr.size(); i++) {
			System.out.print(" "+arr.get(i));
		}
		System.out.println();
	}
}
