/*
Download the Arrays.zip in the "Extras" section of this Github and unzip it.
Fix the FIXME line to reflect where you saved it.
Complete all these assignments.  Print the task # before each answer.

I've made some example arrays.  Do not change anything in these arrays; you will use them throughout this code.  Make a new array and if needed, use a loop to copy the elements over.

Finally, when you want to print the contents of an array named arr, use this line:
	printArray(arr);
I made printArray for this code, it won't work in other codes.
*/

import java.io.*;
import java.util.*;
public class Loops {
	public static String loc = "C:\\Users\\kylej\\Desktop\\"; \\FIXME
	public static void main (String [] args) {
		int [] sortedIntArray1 = populateNum("sortedIntArray1"); //these three lines populate some example arrays for you to work with.  Don't mess with them.
		int [] sortedIntArray2 = populateNum("sortedIntArray2");
		int [] unsortedIntArray = populateNum("unsortedIntArray");
	
		//#10. Make an array containing only the smallest and largest numbers in unsortedIntArray {1, 5, 3, 8, 9, 2, 1, 4, 0} --> {0, 9}
		//#11. Make an array where each index is a number equal to sum of all numbers in unsortedIntArray...excluding unsortedIntArray at that index {1, 2, 3, 4, 11} --> {20, 19, 18, 17, 10}
		//#12. Choose a random number from 2,25 and make an array that lists all its factors, without extra zeroes {10} --> {1, 2, 5, 10}
		//#13. Merge sortedIntArray1 and sortedIntArray2 into a new array {1, 2, 5, 6, 9} + {1, 4, 5, 6, 8} --> {1, 1, 2, 4, 5, 5, 6, 6, 8, 9}
		//#14. Make a new array identical to unsortedIntArray1, except consecutive duplicates are deleted {1, 4, 9, 2, 2, 0} --> {1, 4, 9, 2, 0}
	}
}
