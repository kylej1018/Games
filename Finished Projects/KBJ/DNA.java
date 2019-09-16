import java.util.Scanner;
public class DNA {
	public static void main (String [] args) {
		Scanner s = new Scanner(System.in);
		String end = "";

		while(end.equals("")) {
		System.out.print("Enter DNA sequence or Q to quit: ");
		String sequence = s.nextLine().toUpperCase();
		if(sequence.equals("Q")) break;
		System.out.print("Reverse? Enter Y/N: ");
		char reverse = s.nextLine().charAt(0);
		System.out.print("Complement? Enter Y/N: ");
		char complement = s.nextLine().charAt(0);
		System.out.print("Bisulfite? Enter Y/N: ");
		char bisulfite = s.nextLine().charAt(0);
		
		if(reverse == 'Y' || reverse == 'y')
			sequence = reverseSeq(sequence);
		if(complement == 'Y' || complement == 'y')
			sequence = complementSeq(sequence);
		if(bisulfite == 'Y' || bisulfite == 'y')
			sequence = bisulfiteSeq(sequence);

		System.out.println(sequence);
		}
	}

	public static String reverseSeq(String seq) {
		if(seq.length() == 1)
			return "" + seq.charAt(0);
		return "" + seq.charAt(seq.length()-1) + reverseSeq(seq.substring(0,seq.length()-1));
	}
	public static String complementSeq(String seq) {
		String output = "";
		for(int i = 0; i < seq.length(); i++) {
			char base = seq.charAt(i);
			if(base == 'A') output += 'T';
			if(base == 'T') output += 'A';
			if(base == 'C') output += 'G';
			if(base == 'G') output += 'C';
			if(base == 'R') output += 'Y';
			if(base == 'Y') output += 'R';
			if(base == 'S') output += 'S';
			if(base == 'W') output += 'W';
			if(base == 'K') output += 'M';
			if(base == 'M') output += 'K';
			if(base == 'B') output += 'V';
			if(base == 'D') output += 'H';
			if(base == 'H') output += 'D';
			if(base == 'V') output += 'B';
		}
		return output;
	}
	public static String bisulfiteSeq(String seq) {
		if(seq.length() == 0) return "";
		if(seq.length() == 1) {
			if(seq.charAt(0) == 'C') return "T";
			return seq;
		}
		if(seq.charAt(0) != 'C')
			return seq.charAt(0)+bisulfiteSeq(seq.substring(1));
		if(seq.substring(0,2).equals("CG")) return "Y" + bisulfiteSeq(seq.substring(1));
		if(seq.charAt(0) == 'C') return "T" + bisulfiteSeq(seq.substring(1));
		return seq.charAt(0) + bisulfiteSeq(seq.substring(1));
	}
}
