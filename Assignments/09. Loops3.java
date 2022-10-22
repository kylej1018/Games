/* INSTRUCTIONS
 * Fix the FIXME line to reflect where you saved the Arrays folder.
 * Complete all these assignments.  Print the task # before each answer.
 * Do not change anything in these arrays.
 * Use printArray(arr) to print the contents of an array.  Remember that this command will not work for other codes.
 */
import java.io.File;
import java.util.*;
public class Loops3 {
	public static String loc = "C:\\Users\\kylej\\Desktop\\"; \\FIXME
	public static void main (String [] args) {
		// These three lines populate some example arrays for you to work with.  Don't mess with them.
		int [] sortedIntArray1 = populateNum("sortedIntArray1");
		int [] sortedIntArray2 = populateNum("sortedIntArray2");
		int [] unsortedIntArray = populateNum("unsortedIntArray");
		
		Random r = new Random();
		
		// #17. Take sortedIntArray1 and randomize it in a new array.
		// #18. "extractsort" unsortedIntArray. The next smallest element goes to the end in new array {1, 4, 2, 3} --> {} {1} {1, 2} {1, 2, 3} {1, 2, 3, 4}
		// #19. "bubblesort" unsortedIntArray. Trade misplaced duos. {1, 4, 2, 3, 1} --> {1, 2, 4, 3, 1} {1, 2, 3, 4, 1} {1, 2, 3, 1, 4} {1, 2, 1, 3, 4} {1, 1, 2, 3, 4}
		// #20. "countsort" unsortedIntArray  Find range & make a 2D array.  First dimension = all ints in range.  In second dimension, number of occurrences of each int.
		  // {1, 5, 1, 6, 2, 2, 3, 1, 5} --> {1, 2, 3, 4, 5, 6} --> {1, 1, 1, 2, 2, 3, 5, 5, 6}
		  //                                 {3, 2, 1, 0, 2, 1}
		// #21. Generate a random four-digit number and find the number of iterations to get to Kaprekar's constant (look up what this means)
		//	Hint on #21. To find a single digit in a four-digit number, use int division to chop off everything to the right.  1524 / 100 = 15.
		//	Then use % to find the remainder.  15 % 10 = 5.
		//	Don't forget that before you calculate iterations, you have to check the four-digit number can't have all four digits be the same!
		//	Then you'll need to sort to find the digits in increasing and decreasing orders.  You should use an array for this.
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
