import java.util.Scanner;

public class KeypadInterface {

	final static String FILENAME_DICTIONARY = "WordsRTF.RTF";

	public static void main(String[] args) {
		KeypadParser kp = new KeypadParser(FILENAME_DICTIONARY);
		System.out.println("Welcome to Singapore Power Keypad Parser");
		while (true) {

			System.out.println("Enter the choice of your Operation:");
			System.out.println("1. Give a word to get total number of key presses required.");
			System.out.println("2. Give a word to get the number it represents.");
			System.out.println("3. Give a number to get possible letter combinations.");
			System.out.println("4. Give a number to get possible words from dictionary.");
			System.out.println("5. Exit.");
			try {
				Scanner scan = new Scanner(System.in);
				int choice=0;
				if (scan.hasNextLine()) {
					choice = Integer.parseInt(scan.nextLine());
				}
				switch (choice) {
				case 1: {
					System.out.println("Enter word:");
					String word = scan.next();
					System.out.println(kp.numberOfKeyPresses(word));
					break;
				}
				case 2: {
					System.out.println("Enter word:");
					String word = scan.next();
					System.out.println(kp.wordToNumber(word));
					break;
				}
				case 3: {
					System.out.println("Enter number:");
					String number = scan.next();
					System.out.println(kp.letterCombinations(number));
					break;
				}
				case 4: {
					System.out.println("Enter number:");
					String number = scan.next();
					System.out.println(kp.wordsFromDictionary(number));
					break;
				}
				case 5: {
					System.exit(0);
					break;
				}
				default: {
					System.out.println("Invalid Choice. Try Again");
				}
				}				
			} catch (Exception e) {
				System.out.println("There was an error. Try again.");
				continue;
			}
		}
	}
}
