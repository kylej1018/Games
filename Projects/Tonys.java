import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class Tonys {
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
			//framework is an ArrayList of five columns: year (1970-present), show title, processed show title (w/o "the," "and," punctuation, etc.), Y/N based on if the show has been guessed yet, and hint
		boolean done = false;
		int loc = -1; //kind of an index of the row of Framework.  If loc is constant, year, show title, hint, etc. will all match up with one another.
		boolean cheated = false;
		Random r = new Random();
		System.out.println("Name any show winning the Tony Award for Best Musical or enter QUERY to see what years you've missed.");
		System.out.println("You have unlimited HINT and CHEAT options as well.  Q to quit.  Good luck!");
		while(!done) {
			System.out.print("Guess: ");
			String input = s.nextLine();
			input = processed(input); //gets rid of "the," "and," punctuation, etc. so it's more likely to match processed movie title in framework
			loc = findIn(framework.get(2), input); //finds input ANYWHERE in framework column 3
			if(loc > -1 && framework.get(3).get(loc).equals("N")) { //if you guess right (but only once per show), it updates column with Y/N
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
				loc = r.nextInt(framework.get(0).size()); //gives you a hint of a random show you haven't guessed yet
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
		System.out.println("Name the show that won the Tony Award for Best Musical in the year or enter SKIP.");
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
			System.out.print("You got them all!  Impressive..."); //if you answered them all and didn't cheat
		}
		System.out.println();
	}

	public static String processed(String s) { //processed helps make input & show title more similar so user can be lazy with input
		s = s.toLowerCase();
		if(s.indexOf(" the musical") > -1) {
			s = s.substring(0, s.indexOf(" the musical"));
		}
		while(s.indexOf("the ") > -1) {
			String s1 = s.substring(0, s.indexOf("the "));
			String s2 = s.substring(s.indexOf("the ")+4);
			s = s1+s2;
		}
		if(s.indexOf("a ") == 0) {
			s = s.substring(2);
		}
		if(s.indexOf(" a ") > -1) {
			String s1 = s.substring(0, s.indexOf(" a "));
			String s2 = s.substring(s.indexOf(" a ")+2);
			s = s1+s2;
		}
		while(s.indexOf("!") > -1) {
			String s1 = s.substring(0, s.indexOf("!"));
			String s2 = s.substring(s.indexOf("!")+1);
			s = s1+s2;
		}
		if(s.indexOf(":") > -1) {
			String s1 = s.substring(0, s.indexOf(":"));
			String s2 = s.substring(s.indexOf(":")+1);
			s = s1+s2;
		}
		if(s.indexOf(",") > -1) {
			String s1 = s.substring(0, s.indexOf(","));
			String s2 = s.substring(s.indexOf(",")+1);
			s = s1+s2;
		}
		if(s.indexOf("&") > -1) {
			String s1 = s.substring(0, s.indexOf("&"));
			String s2 = "and" + s.substring(s.indexOf("&")+1);
			s = s1+s2;
		}
		while(s.indexOf("'") > 0) {
			String s1 = s.substring(0, s.indexOf("'"));
			String s2 = s.substring(s.indexOf("'")+1);
			s = s1+s2;
		}
		if(s.equals("fiorello") || s.equals("sound of music/fiorello")) {
			s = "sound of music";
		}
		if(s.equals("monty python")) {
			s = "spamalot";
		}
		if(s.indexOf("forty") == 0 && s.indexOf("second") == 6) {
			s = "42" + s.substring(10);
		}
		if(s.equals("monty pythons spamalot")) {
			s = "spamalot";
		}
		if(s.equals("forum")) {
			s = "funny thing happened on way to forum";
		}
		if(s.equals("les mis")) {
			s = "les miserables";
		}
		if(s.equals("how to succeed") || s.equals("how to succeed in business")) {
			s = "how to succeed in business without really trying";
		}
		if(s.equals("edwin drood")) {
			s = "mystery of edwin drood";
		}
		if(s.equals("sweeney todd demon barber of fleet street")) {
			s = "sweeney todd";
		}
		if(s.equals("aint misbehaving")) {
			s = "aint misbehavin";
		}
		if(s.equals("9")) {
			s = "nine";
		}
		if(s.equals("avenue q")) {
			s = "wicked";
		}
		if(s.equals("billy elliot")) {
			s = "next to normal";
		}
		if(s.equals("millie")) {
			s = "thoroughly modern millie";
		}
		if(s.equals("la cage")) {
			s = "la cage aux folles";
		}
		if(s.equals("gentlemans guide")) {
			s = "gentlemans guide to love and murder";
		}
		return s;
	}

	public static boolean scan(ArrayList <String> arr) { //checks to see if all shows are "Y" or if more guessing is needed
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

		arr.get(1).add(0, "Kiss Me, Kate");
		arr.get(1).add(0, "South Pacific");
		arr.get(1).add(0, "Guys & Dolls");
		arr.get(1).add(0, "The King and I");
		arr.get(1).add(0, "Wonderful Town");
		arr.get(1).add(0, "Kismet");
		arr.get(1).add(0, "The Pajama Game");
		arr.get(1).add(0, "Damn Yankees");
		arr.get(1).add(0, "My Fair Lady");
		arr.get(1).add(0, "The Music Man");
		arr.get(1).add(0, "Redhead");
		arr.get(1).add(0, "The Sound of Music/Fiorello!");
		arr.get(1).add(0, "Bye Bye Birdie");
		arr.get(1).add(0, "How to Succeed in Business Without Really Trying");
		arr.get(1).add(0, "A Funny Thing Happened on the Way to the Forum");
		arr.get(1).add(0, "Hello, Dolly!");
		arr.get(1).add(0, "Fiddler on the Roof");
		arr.get(1).add(0, "Man of La Mancha");
		arr.get(1).add(0, "Cabaret");
		arr.get(1).add(0, "Hallelujah, Baby!");
		arr.get(1).add(0, "1776");
		arr.get(1).add(0, "Applause");
		arr.get(1).add(0, "Company");
		arr.get(1).add(0, "Two Gentlemen of Verona");
		arr.get(1).add(0, "A Little Night Music");
		arr.get(1).add(0, "Raisin");
		arr.get(1).add(0, "The Wiz");
		arr.get(1).add(0, "A Chorus Line");
		arr.get(1).add(0, "Annie");
		arr.get(1).add(0, "Ain't Misbehavin'");
		arr.get(1).add(0, "Sweeney Todd");
		arr.get(1).add(0, "Evita");
		arr.get(1).add(0, "42nd Street");
		arr.get(1).add(0, "Nine");
		arr.get(1).add(0, "Cats");
		arr.get(1).add(0, "La Cage aux Folles");
		arr.get(1).add(0, "Big River");
		arr.get(1).add(0, "The Mystery of Edwin Drood");
		arr.get(1).add(0, "Les Miserables");
		arr.get(1).add(0, "The Phantom of the Opera");
		arr.get(1).add(0, "Jerome Robbins' Broadway");
		arr.get(1).add(0, "City of Angels");
		arr.get(1).add(0, "The Will Rogers follies");
		arr.get(1).add(0, "Crazy for You");
		arr.get(1).add(0, "Kiss of the Spider Woman");
		arr.get(1).add(0, "Passion");
		arr.get(1).add(0, "Sunset Boulevard");
		arr.get(1).add(0, "Rent");
		arr.get(1).add(0, "Titanic");
		arr.get(1).add(0, "The Lion King");
		arr.get(1).add(0, "Fosse");
		arr.get(1).add(0, "Contact");
		arr.get(1).add(0, "The Producers");
		arr.get(1).add(0, "Thoroughly Modern Millie");
		arr.get(1).add(0, "Hairspray");
		arr.get(1).add(0, "Avenue Q");
		arr.get(1).add(0, "Spamalot");
		arr.get(1).add(0, "Jersey Boys");
		arr.get(1).add(0, "Spring Awakening");
		arr.get(1).add(0, "In the Heights");
		arr.get(1).add(0, "Billy Elliot");
		arr.get(1).add(0, "Memphis");
		arr.get(1).add(0, "The Book of Mormon");
		arr.get(1).add(0, "Once");
		arr.get(1).add(0, "Kinky Boots");
		arr.get(1).add(0, "A Gentleman's Guide to Love and Murder");
		arr.get(1).add(0, "Fun Home");
		arr.get(1).add(0, "Hamilton");
		arr.get(1).add(0, "Dear Evan Hansen");
		arr.get(1).add(0, "The Band's Visit");

		arr.get(4).add(0, "Another Openin', Another Show by Cole Porter");
		arr.get(4).add(0, "Some Enchanted Evening by Rodgers & Hammerstein");
		arr.get(4).add(0, "Luck Be a Lady by Frank Loesser");
		arr.get(4).add(0, "Shall We Dance? by Rodgers & Hammerstein");
		arr.get(4).add(0, "One Hundred Easy Ways by Leonard Berstein, Betty Comden, Adolph Green");
		arr.get(4).add(0, "And This is My Beloved by Alexander Borodin, Chet Forrest, Bob Wright");
		arr.get(4).add(0, "Steam Heat by Richard Adler & Jerry Ross");
		arr.get(4).add(0, "Whatever Lola Wants by Richard Adler & Jerry Ross");
		arr.get(4).add(0, "On the Street Where You Live by Lerner & Loewe");
		arr.get(4).add(0, "Seventy-Six Trombones by Meredith Wilson");
		arr.get(4).add(0, "Two Faces in the Dark by Albert Hague & Dorothy Fields");
		arr.get(4).add(0, "Do-Re-Mi by Rodgers & Hammerstein");
		arr.get(4).add(0, "Put On a Happy Face by Charles Strouse & Lee Adams");
		arr.get(4).add(0, "Brotherhood of Man by Frank Loesser");
		arr.get(4).add(0, "Comedy Tonight by Stephen Sondheim");
		arr.get(4).add(0, "Before the Parade Passes By by Jerry Herman");
		arr.get(4).add(0, "Tradition by Bock & Harnick");
		arr.get(4).add(0, "The Impossible Dream by Mitch Leigh & Joe Darion");
		arr.get(4).add(0, "Wilkommen by Kander & Ebb");
		arr.get(4).add(0, "Being Good Isn't Good Enough by Jule Styne, Betty Comden, Adolph Green");
		arr.get(4).add(0, "He Plays the Violin by Sherman Edward");
		arr.get(4).add(0, "Who's That Girl? by Charles Strouse & Lee Adams");
		arr.get(4).add(0, "The Ladies Who Lunch by Stephen Sondheim");
		arr.get(4).add(0, "Summer, Summer by Galt MacDermot & John Guare");
		arr.get(4).add(0, "Send in the Clowns by Stephen Sondheim");
		arr.get(4).add(0, "Man Say by Judd Woldin & Robert Brittan");
		arr.get(4).add(0, "Ease On Down the Road by Charlie Smalls");
		arr.get(4).add(0, "What I Did For Love by Marvin Hamlisch & Ed Kleban");
		arr.get(4).add(0, "Tomorrow by Charles Strouse, Martin Charnin");
		arr.get(4).add(0, "I Can't Give You Anything But Love by Fats Waller");
		arr.get(4).add(0, "Nothing's Gonna Harm You by Stephen Sondheim");
		arr.get(4).add(0, "Don't Cry for Me Argentina by Andrew Lloyd Webber & Tim Rice");
		arr.get(4).add(0, "We're In the Money by Harry Warren & Al Dubin");
		arr.get(4).add(0, "Only With You by Maury Yeston");
		arr.get(4).add(0, "Memory by Andrew Lloyd Webber & Trevor Nunn");
		arr.get(4).add(0, "I Am What I Am by Jerry Herman");
		arr.get(4).add(0, "Worlds Apart by Roger Miller");
		arr.get(4).add(0, "A Man Could Go Quite Mad by Rupert Holmes");
		arr.get(4).add(0, "I Dreamed a Dream by Claude-Michel Schonberg & Herbert Kretzmer");
		arr.get(4).add(0, "The Music of the Night by Andrew Lloyd Webber & Charles Hart");
		arr.get(4).add(0, "An anthology featuring songs from The King and I, On the Town, and West Side Story");
		arr.get(4).add(0, "You're Nothing Without Me by Cy Coleman & David Zippel");
		arr.get(4).add(0, "Look Around by Cy Coleman, Betty Comden, Adolph Green");
		arr.get(4).add(0, "I Got Rhythm by George & Ira Gershwin");
		arr.get(4).add(0, "The Day After That by Kander & Ebb");
		arr.get(4).add(0, "Is This What You Call Love? by Stephen Sondheim");
		arr.get(4).add(0, "As If We Never Said Goodbye by Andrew Lloyd Webber, Christopher Hampton, Don Black");
		arr.get(4).add(0, "Seasons of Love by Jonathan Larson");
		arr.get(4).add(0, "In Every Age by Maury Yeston");
		arr.get(4).add(0, "Circle of Life by Elton John, Tim Rice");
		arr.get(4).add(0, "A revue featuring songs from Cabaret, Pippin, Chicago, and Damn Yankees");
		arr.get(4).add(0, "A dance play featuring songs by Rodgers & Hart, Grieg, and Bizet");
		arr.get(4).add(0, "Springtime for Hitler by Mel Brooks");
		arr.get(4).add(0, "What Do I Need With Love? by Jeanine Tesori & Dick Scanlan");
		arr.get(4).add(0, "You Can't Stop the Beat by Marc Shaiman & Scott Wittman");
		arr.get(4).add(0, "Everyone's a Little Bit Racist by Robert Lopez & Jeff Marx");
		arr.get(4).add(0, "You Won't Succeed on Broadway by John Du Prez & Eric Idle");
		arr.get(4).add(0, "December, 1963 by Bob Crewe & Bob Gaudio");
		arr.get(4).add(0, "Mama Who Bore Me by Duncan Sheik & Steven Sater");
		arr.get(4).add(0, "Alabanza by Lin-Manuel Miranda");
		arr.get(4).add(0, "Electricity by Elton John & Lee Hall");
		arr.get(4).add(0, "Big Love by David Bryan & Joe DiPietro");
		arr.get(4).add(0, "Hasa Diga Eebowai by Robert Lopez, Trey Parker, Matt Stone");
		arr.get(4).add(0, "Falling Slowly by Glen Hansard & Marketa Irglova");
		arr.get(4).add(0, "Land of Lola by Cyndi Lauper");
		arr.get(4).add(0, "I Don't Understand the Poor by Steven Lutvak & Robert L. Freedman");
		arr.get(4).add(0, "Ring of Keys by Jeanine Tesori & Lisa Kron");
		arr.get(4).add(0, "Guns and Ships by Lin-Manuel Miranda");
		arr.get(4).add(0, "Waving Through a Window by Pasek & Paul");
		arr.get(4).add(0, "Welcome to Nowhere by David Yazbek");

		for(int i = 1949; i < 2019; i++) {
			arr.get(0).add(0,""+i); //year
			arr.get(3).add("N");
			String s = "" + arr.get(1).get(i-1949);
			arr.get(2).add(processed(s)); //show title is processed in this column but intact in its original column
		}
		
		return arr;
	}
}