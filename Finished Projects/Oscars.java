import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class Oscars {
	public static void main (String [] args) {
		Scanner s = new Scanner(System.in);
		String mode = "";
		while(!mode.equals("easy") && !mode.equals("hard")) { //user decides if they have to match movie to year (hard) or can enter ANY year's movie (easy)
			System.out.print("Easy mode or hard mode? ");
			mode = s.nextLine();
			if(mode.length() > 3) {
				mode = mode.substring(0,4).toLowerCase();
			}
		}
		if(mode.equals("hard")) {
			hard(s);
		}
		if(mode.equals("easy")) {
			easy(s);
		}
	}

	public static void easy(Scanner s) {
		ArrayList <ArrayList> framework = populate();
			//framework is an ArrayList of five columns: year (1970-present), movie title, processed movie title (w/o "the," "and," punctuation, etc.), Y/N based on if the movie has been guessed yet, and hint
		boolean done = false;
		int loc = -1; //kind of an index of the row of Framework.  If loc is constant, year, movie title, hint, etc. will all match up with one another.
		boolean cheated = false;
		Random r = new Random();
		System.out.println("Name any Best Picture winner since 1970 or enter QUERY to see what years you've missed.");
		System.out.println("You have unlimited HINT and CHEAT options as well.  Q to quit.  Good luck!");
		while(!done) {
			System.out.print("Guess: ");
			String input = s.nextLine();
			input = processed(input); //gets rid of "the," "and," punctuation, etc. so it's more likely to match processed movie title in framework
			loc = findIn(framework.get(2), input); //finds input ANYWHERE in framework column 3
			if(loc > -1 && framework.get(3).get(loc).equals("N")) { //if you guess right (but only once per film), it updates column with Y/N
				System.out.println(framework.get(0).get(loc) + ": " + framework.get(1).get(loc));
				framework.get(3).add(loc,"Y");
				framework.get(3).remove(loc+1);
			}
			if(input.equals("query")) {
				for(int i = framework.get(0).size()-1; i > -1; i--) {
					if(framework.get(3).get(i).equals("N")) {
						System.out.print(framework.get(0).get(i) + " "); //prints out all unfinished years
					}
				}
				System.out.println();
			}
			if(input.equals("cheat")) {
				cheated = true;
				loc = r.nextInt(framework.get(0).size()); //gives you a random answer that you haven't guessed yet
				while(framework.get(3).get(loc) != "N") {
					loc = r.nextInt(framework.get(0).size());
				}
				System.out.println(framework.get(0).get(loc) + ": " + framework.get(1).get(loc));
				framework.get(3).add(loc, "Y");
				framework.get(3).remove(loc+1);
			}
			if(input.equals("hint")) {
				loc = r.nextInt(framework.get(0).size()); //gives you a hint of a random movie you haven't guessed yet
				while(framework.get(3).get(loc) != "N") {
					loc = r.nextInt(framework.get(0).size());
				}
				System.out.println(framework.get(4).get(loc));
			}


			loc = -1;
			done = scan(framework.get(3)); //if you've entered them all, or enter Quit command, loop will break.
			if(input.equals("q") || input.equals("quit")) {
				done = true;
			}
		}
		System.out.print("The end!  ");
		if(!cheated && scan(framework.get(3))) {
			System.out.print("You got them all!  Impressive..."); //if you answered them all and didn't cheat
		}
		System.out.println();
	}

	public static void hard(Scanner s) {
		ArrayList <ArrayList> framework = populate(); //framework & other variables have same function here as above
		boolean done = false;
		int loc = 0;
		System.out.println("Name the film that won Best Picture in the year or enter SKIP.");
		System.out.println("You have 10 HINT and 5 CHEAT options as well.  Q to quit.  Good luck!");
		int cheats = 5;
		int hints = 10;

		while(!done) {
			System.out.print(framework.get(0).get(loc) + ": ");
			String input = s.nextLine();
			input = processed(input);
			if(input.equals(framework.get(2).get(loc))) { //rather than random search, it matches it only to the current location
				framework.get(3).add(loc,"Y");
				framework.get(3).remove(framework.get(0).size());
				loc++;
			}
			if(input.equals("skip")) {
				for(int i = 0; i < framework.size(); i++) {
					framework.get(i).add(framework.get(i).get(loc)); //moves all items at this location to end of Framework list, to be answered later.
					framework.get(i).remove(loc);
				}
			}
			if(input.equals("cheat") && cheats > 0) {
				System.out.println("ANSWER: " + framework.get(1).get(loc)); //prints out the answer for this year
				cheats--;
				framework.get(3).add(loc,"Y");
				framework.get(3).remove(framework.get(0).size());
				loc++;
			}
			if(input.equals("hint") && hints > 0) { //prints out the hint for this year
				hints--;
				System.out.println(framework.get(4).get(loc));
			}
			done = scan(framework.get(3));
			if(input.equals("q") || input.equals("quit")) {
				done = true;
			}
		}
		System.out.print("The end!  ");
		if(cheats == 5 && scan(framework.get(3))) {
			System.out.print("You got them all!  Impressive...");
		}
		System.out.println();
	}

	public static String processed(String s) { //processed helps make input & movie title more similar so user can be lazy with input
		s = s.toLowerCase();
		while(s.indexOf("the ") > -1) {
			String s1 = s.substring(0, s.indexOf("the "));
			String s2 = s.substring(s.indexOf("the ")+4);
			s = s1+s2;
		}
		if(s.equals("crash")) {
			s = "brokeback mountain";
		}
		if(s.equals("moonlight")) {
			s = "la la land";
		}
		if(s.indexOf("return of king") > 0 && s.indexOf("lord of rings") > -1) {
			s = "return of king";
		}
		if(s.equals("cuckoos nest")) {
			s = "one flew over cuckoos nest";
		}
		if(s.equals("lord of rings")) {
			s = "return of king";
		}
		if(s.indexOf("twelve") == 0) {
			s = "12" + s.substring(6);
		}
		if(s.indexOf("a ") == 0) {
			s = s.substring(2);
		}
		if(s.indexOf(" a ") > -1) {
			String s1 = s.substring(0, s.indexOf(" a "));
			String s2 = s.substring(s.indexOf(" a ")+2);
			s = s1+s2;
		}
		if(s.indexOf("part ii") > -1) {
			String s1 = s.substring(0, s.indexOf("part ii"));
			String s2 = s.substring(s.indexOf("part ii")+5);
			s = s1+s2;
		}
		if(s.indexOf("part 2") > -1) {
			String s1 = s.substring(0, s.indexOf("part 2"));
			String s2 = s.substring(s.indexOf("part 2")+5);
			s = s1+s2;
		}
		if(s.indexOf(".") > -1) {
			String s1 = s.substring(0, s.indexOf("."));
			String s2 = s.substring(s.indexOf(".")+1);
			s = s1+s2;
		}
		if(s.indexOf("vs") > -1) {
			String s1 = s.substring(0, s.indexOf("vs")+1);
			String s2 = s.substring(s.indexOf("vs")+2);
			s = s1+s2;
		}
		if(s.indexOf("ii") > 0) {
			s = s.substring(0, s.indexOf("ii")) + "2";
		}
		while(s.indexOf("'") > 0) {
			String s1 = s.substring(0, s.indexOf("'"));
			String s2 = s.substring(s.indexOf("'")+1);
			s = s1+s2;
		}
		return s;
	}

	public static boolean scan(ArrayList <String> arr) { //checks to see if all movies are "Y" or if more guessing is needed
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i).equals("Y")) {}
			else {return false;}
		}
		return true;
	}

	public static int findIn(ArrayList <String> arr, String s) { //scans a list for a specific word/phrase
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i).equals(s))
			return i;
		}
		return -1;
	}

	public static ArrayList <ArrayList> populate() { //fills Framework
		ArrayList <ArrayList> arr = new ArrayList <ArrayList>();
		for(int i = 0; i < 5; i++) { //year, full, mush, correct, hint
			arr.add(new ArrayList <String>());
		}

		arr.get(1).add(0, "Patton");
		arr.get(1).add(0, "The French Connection");
		arr.get(1).add(0, "The Godfather");
		arr.get(1).add(0, "The Sting");
		arr.get(1).add(0, "The Godfather Part II");
		arr.get(1).add(0, "One Flew Over the Cuckoo's Nest");
		arr.get(1).add(0, "Rocky");
		arr.get(1).add(0, "Annie Hall");
		arr.get(1).add(0, "The Deer Hunter");
		arr.get(1).add(0, "Kramer vs. Kramer");
		arr.get(1).add(0, "Ordinary People");
		arr.get(1).add(0, "Chariots of Fire");
		arr.get(1).add(0, "Gandhi");
		arr.get(1).add(0, "Terms of Endearment");
		arr.get(1).add(0, "Amadeus");
		arr.get(1).add(0, "Out of Africa");
		arr.get(1).add(0, "Platoon");
		arr.get(1).add(0, "The Last Emperor");
		arr.get(1).add(0, "Rain Man");
		arr.get(1).add(0, "Driving Miss Daisy");
		arr.get(1).add(0, "Dances With Wolves");
		arr.get(1).add(0, "The Silence of the Lambs");
		arr.get(1).add(0, "Unforgiven");
		arr.get(1).add(0, "Schindler's List");
		arr.get(1).add(0, "Forrest Gump");
		arr.get(1).add(0, "Braveheart");
		arr.get(1).add(0, "The English Patient");
		arr.get(1).add(0, "Titanic");
		arr.get(1).add(0, "Shakespeare in Love");
		arr.get(1).add(0, "American Beauty");
		arr.get(1).add(0, "Gladiator");
		arr.get(1).add(0, "A Beautiful Mind");
		arr.get(1).add(0, "Chicago");
		arr.get(1).add(0, "The Lord of the Rings: Return of the King");
		arr.get(1).add(0, "Million Dollar Baby");
		arr.get(1).add(0, "Crash");
		arr.get(1).add(0, "The Departed");
		arr.get(1).add(0, "No Country for Old Men");
		arr.get(1).add(0, "Slumdog Millionaire");
		arr.get(1).add(0, "The Hurt Locker");
		arr.get(1).add(0, "The King's Speech");
		arr.get(1).add(0, "The Artist");
		arr.get(1).add(0, "Argo");
		arr.get(1).add(0, "12 Years a Slave");
		arr.get(1).add(0, "Birdman");
		arr.get(1).add(0, "Spotlight");
		arr.get(1).add(0, "Moonlight");
		arr.get(1).add(0, "The Shape of Water");
		arr.get(1).add(0, "Green Book");

		arr.get(4).add(0, "Directed by Franklin J. Schaffner & starring George C. Scott");
		arr.get(4).add(0, "Directed by William Friedkin & starring Gene Hackman");
		arr.get(4).add(0, "Directed by Francis Ford Coppola & starring Marlon Brando");
		arr.get(4).add(0, "Directed by George Roy Hill & starring Robert Redford, Paul Newman");
		arr.get(4).add(0, "Directed by Francis Ford Coppola & starring Al Pacino");
		arr.get(4).add(0, "Directed by Milos Forman & starring Jack Nicholson");
		arr.get(4).add(0, "Directed by John G. Avildsen & starring Sylvester Stallone");
		arr.get(4).add(0, "Directed by Woody Allen & starring Diane Keaton, Woody Allen");
		arr.get(4).add(0, "Directed by Michael Cimino & starring Robert de Niro");
		arr.get(4).add(0, "Directed by Robert Benton & starring Dustin Hoffman, Meryl Streep");
		arr.get(4).add(0, "Directed by Robert Redford & starring Mary Tyler Moore");
		arr.get(4).add(0, "Directed by Hugh Hudson & starring Ben Cross, Ian Charleson");
		arr.get(4).add(0, "Directed by Richard Attenborough & starring Ben Kingsley");
		arr.get(4).add(0, "Directed by James L. Brooks & starring Shirley MacLaine, Jack Nicholson");
		arr.get(4).add(0, "Directed by Milos Forman & starring F. Murray Abraham, Tom Hulce");
		arr.get(4).add(0, "Directed by Sydney Pollack & starring Robert Redford, Meryl Streep");
		arr.get(4).add(0, "Directed by Oliver Stone & starring Tom Berenger, Charlie Sheen");
		arr.get(4).add(0, "Directed by Bernardo Bertolucci & starring John Lone");
		arr.get(4).add(0, "Directed by Barry Levinson & starring Dustin Hoffman, Tom Cruise");
		arr.get(4).add(0, "Directed by Bruce Beresford & starring Jessica Tandy, Morgan Freeman");
		arr.get(4).add(0, "Directed by Kevin Costner & starring Kevin Costner");
		arr.get(4).add(0, "Directed by Jonathan Demme & starring Anthony Hopkins, Jodie Foster");
		arr.get(4).add(0, "Directed by Clint Eastwood & starring Clint Eastwood, Gene Hackman");
		arr.get(4).add(0, "Directed by Steven Spielberg & starring Liam Neeson, Ben Kingsley");
		arr.get(4).add(0, "Directed by Robert Zemeckis & starring Tom Hanks");
		arr.get(4).add(0, "Directed by Mel Gibson & starring Mel Gibson");
		arr.get(4).add(0, "Directed by Anthony Minghella & starring Ralph Fiennes");
		arr.get(4).add(0, "Directed by James Cameron & starring Leonardo DiCaprio, Kate Winslet");
		arr.get(4).add(0, "Directed by John Madden & starring Gwyneth Paltrow");
		arr.get(4).add(0, "Directed by Sam Mendes & starring Kevin Spacey");
		arr.get(4).add(0, "Directed by Ridley Scott & starring Russell Crowe");
		arr.get(4).add(0, "Directed by Ron Howard & starring Russell Crowe");
		arr.get(4).add(0, "Directed by Rob Marshall & starring Renee Zellweger, Catherine Zeta-Jones");
		arr.get(4).add(0, "Directed by Peter Jackson & starring Elijah Wood");
		arr.get(4).add(0, "Directed by Clint Eastwood & starring Hilary Swank, Clint Eastwood");
		arr.get(4).add(0, "Directed by Paul Haggis & starring Matt Dillon");
		arr.get(4).add(0, "Directed by Martin Scorsese & starring Leonardo DiCaprio, Jack Nicholson");
		arr.get(4).add(0, "Directed by Joel and Ethan Coen & starring Javier Bardem");
		arr.get(4).add(0, "Directed by Danny Boyle & starring Dev Patel");
		arr.get(4).add(0, "Directed by Kathryn Bigelow & starring Jeremy Renner");
		arr.get(4).add(0, "Directed by Tom Hooper & starring Colin Firth");
		arr.get(4).add(0, "Directed by Michel Hazanavicius & starring Jean Dujardin");
		arr.get(4).add(0, "Directed by Ben Affleck & starring Ben Affleck");
		arr.get(4).add(0, "Directed by Steve McQueen & starring Chiwetel Ejiofor");
		arr.get(4).add(0, "Directed by Alejandro G. Inarritu & starring Michael Keaton");
		arr.get(4).add(0, "Directed by Tom McCarthy & starring Mark Ruffalo, Michael Keaton");
		arr.get(4).add(0, "Directed by Barry Jenkins & starring Mahershala Ali");
		arr.get(4).add(0, "Directed by Guillermo del Toro & starring Sally Hawkins");
		arr.get(4).add(0, "Directed by Peter Farrelly & starring Viggo Mortense, Mahershala Ali");

		for(int i = 1970; i < 2018; i++) {
			arr.get(0).add(0,""+i); //year
			arr.get(3).add("N");
			String s = "" + arr.get(1).get(i-1970);
			arr.get(2).add(processed(s)); //movie title is processed in this column but intact in its original column
		}
		
		return arr;
	}
}