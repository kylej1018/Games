/*
Fix the FIXME line to reflect where you saved the Arrays folder.
Complete all these assignments.  Print the task # before each answer.
Do not change anything in these arrays.
Use printArray(arr) to print the contents of an array.  Remember that this command will not work for other codes.
*/
import java.io.*;
import java.util.*;
public class Loops3 {
	public static String loc = "C:\\Users\\kylej\\Desktop\\"; \\FIXME
	public static void main (String [] args) {
		int [] sortedIntArray1 = populateNum("sortedIntArray1"); //these three lines populate some example arrays for you to work with.  Don't mess with them.
		int [] sortedIntArray2 = populateNum("sortedIntArray2");
		int [] unsortedIntArray = populateNum("unsortedIntArray");
		
		Random r = new Random();
		
		//#15. Take sortedIntArray1 and randomize it in a new array.
		//#16. "extractsort" unsortedIntArray. The next smallest element goes to the end in new array {1, 4, 2, 3} --> {} {1} {1, 2} {1, 2, 3} {1, 2, 3, 4}
		//#17. "bubblesort" unsortedIntArray. Trade misplaced duos. {1, 4, 2, 3, 1} --> {1, 2, 4, 3, 1} {1, 2, 3, 4, 1} {1, 2, 3, 1, 4} {1, 2, 1, 3, 4} {1, 1, 2, 3, 4}
		//#18. "countsort" unsortedIntArray  Find range & make a 2D array.  First dimension = all ints in range.  In second dimension, number of occurrences of each int.
		  //{1, 5, 1, 6, 2, 2, 3, 1, 5} --> {1, 2, 3, 4, 5, 6} --> {1, 1, 1, 2, 2, 3, 5, 5, 6}
		  //                                {3, 2, 1, 0, 2, 1}
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
