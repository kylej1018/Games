/*
 * Fix the FIXME line to reflect where you saved the Arrays folder.
 * Complete all these assignments.  Print the task # before each answer.
 * Do not change anything in these arrays.
 * Use printArray(arr) to print the contents of an array or ArrayList.  Remember that this command will not work for other codes.
*/
import java.io.File;
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

		Scanner s = new Scanner(System.in);
    
		// #26. Prompt user input.  Translate the input to Pig Latin and print it out.
		// #27. Prompt user input. Alphabetize each word in the sentence but don't reverse the whole sentence. {the quick brown fox} --> {eht cikqu bnorw fox}
		// #28. Prompt user input and perform a reverse cipher
			// original: ABCDEFGHIJKLMNOPQRSTUVWXYZ
			// coded:    ZYXWVUTSRQPONMLKJIHGFEDCBA
		// #29. Prompt two user inputs.  The second is a number to dictate advancement of the first in an advance cipher.
			// original:  ABCDEFGHIJKLMNOPQRSTUVWXYZ
			// coded (3): XYZABCDEFGHIJKLMNOPQRSTUVW
		// #30. Prompt two user inputs.  The second is a keyword to encode the first in a keyword cipher.
			// original: ABCDEFGHIJKLMNOPQRSTUVWXYZ
			// coded:    SKELINGTOABCDFHJMPQRUVWXYZ (keyword = SKELLINGTON, but you can't have duplicate letters)
		// #31. Identify the keyword in Kyle's keyword cipher.  The encoded phrase is the first element in keywordCipher.  The remaining elements in the list are possible keywords you'll have to try.  Only one will make a coherent sentence.  Print the keywords and their sentences.
  }
    
	public static int[] populateNum(String str) { // this is how the computer reads the text files. Don't mess with this.
		ArrayList<String> arr1 = populateStr(str);
		int[] arr2 = new int[arr1.size()];
		for (int i = 0; i < arr1.size(); i++) {
			arr2[i] = Integer.parseInt(arr1.get(i));
		}
		return arr2;
	}

	public static ArrayList<String> populateStr(String str) { // this is how the computer reads the text files. Don't mess with this.
		ArrayList<String> arr = new ArrayList<String>();
		String loc2 = loc + "\\" + str + ".txt";
		try {
			Scanner s = new Scanner(new File(loc2));
			while(s.hasNextLine()) {
				String input = s.nextLine();
				arr.add(input);
			}
			s.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return arr;
	}

	public static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	public static void printArray(ArrayList<String> arr) {
		 System.out.println(arr);
	}
}
