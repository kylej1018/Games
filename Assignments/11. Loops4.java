/*
 * Fix the FIXME line to reflect where you saved the Arrays folder.
 * Complete all these assignments.  Print the task # before each answer.
 * Do not change anything in these arrays.
 * Use printArray(arr) to print the contents of an array or ArrayList.  Remember that this command will not work for other codes.
 */
import java.io.*;
import java.util.*;
public class Loops4 {
	public static String loc = "C:\\Users\\kylej\\Desktop\\"; \\FIXME
	public static void main (String [] args) {
		// These three lines populate some example arrays for you to work with.  Don't mess with them.
		int [] sortedIntArray1 = populateNum("sortedIntArray1");
		int [] sortedIntArray2 = populateNum("sortedIntArray2");
		int [] unsortedIntArray = populateNum("unsortedIntArray");
		ArrayList <String> stringArray1 = populateStr("StringArray1"); // more example arrays.  Don't mess with them.
		ArrayList <String> stringArray2 = populateStr("StringArray2");
		ArrayList <String> keywordCipher = populateStr("KeywordCipher");
    
		// #19. Find and delete duplicates in stringArray1 {abc, def, ghi, jkl, abc, mno} --> {abc, def, ghi, jkl, mno}
		// #20. Add elements to stringArray2 so all have same number of entries as letters in name {a, bc, def, gh} --> {a, bc, bc, def, def, def, gh, gh}
		// #21. Create an arraylist spelling numbers in unsortedIntArray {1, 2, 3, 4} --> {one, two, three, four}
		// #22. Alphabetize stringArray2 "insertsort", where the next element is placed in a new array between already alphabetically organized words.
		// #23. Invert each word in stringArray2 {the quick brown fox} --> {eht kciuq nworb xof}
		// #24. Make an array of only the palindromes in stringArray2
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
		catch(Exception e) {}
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
