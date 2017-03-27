import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class KeypadParser {

	private ArrayList<ArrayList<String>> keypad;
	private HashMap<String, Integer> characterPosition;

	KeypadParser(String filename) {
		initKeypad();
	}
	
	private void initKeypad() {
		keypad = new ArrayList<ArrayList<String>>();
		characterPosition = new HashMap<String, Integer>(26, 1);

		keypad.add(new ArrayList<String>()); // 0
		keypad.add(new ArrayList<String>()); // 1

		for (int i = 2, j = 97; i <= 9; i++) {
			keypad.add(new ArrayList<String>());
			int c = 3;
			if (i == 7 || i == 9)
				c = 4;
			while (c > 0) {
				keypad.get(i).add(String.valueOf((char) j));
				characterPosition.put(String.valueOf((char) j), i);
				j++;
				c--;
			}
		}
	}
	
	/**
	 * 
	 * @param (String)
	 *            The key sequence for which the letter combinations are
	 *            required.
	 * @return (ArrayList<String>) List of strings defining all the possible
	 *         letter combinations with the given key presses.Returns empty list
	 *         if empty sequence or corrupted sequence is given.
	 */
	public ArrayList<String> letterCombinations(String number) {
		number = number.trim();
		ArrayList<String> combinations = new ArrayList<String>();
		if (number.length() > 0) {
			// iterate over every character in the given sequence.
			for (char ch : number.toCharArray()) {

				// Return if the character is not a key between integers 0 and 9
				if (ch < 48 || ch > 57)
					return new ArrayList<String>();

				String key = String.valueOf(ch);
				ArrayList<String> temp = new ArrayList<String>();
				ArrayList<String> key_char = keypad.get(Integer.parseInt(key));
				if (combinations.size() == 0) {
					for (String str2 : key_char) {
						temp.add(str2);
					}
				} else {
					for (String str1 : combinations) {
						for (String str2 : key_char) {
							temp.add(str1.concat(str2));
						}
					}
				}
				if (temp.size() > 0)
					combinations = (ArrayList<String>) temp.clone();
			}
		}
		return combinations;
	}


	/**
	 * 
	 * @param (String)
	 *            The word for which the number representation is needed.
	 * @return (String) The number which the word represents. -1 if any
	 *         character in the word is not in the keypad. -Runs in O(n) time
	 *         where n is the length of the word.
	 */
	public String wordToNumber(String word) {
		word = word.toLowerCase();
		String number = "";
		for (char ch : word.trim().toCharArray()) {
			int key = getKeyOfCharacter(ch);
			if (key == -1)
				return "-1";
			number += key;
		}
		return number.equals("") ? "-1" : number;
	}

	/**
	 * 
	 * @param (String)
	 *            Word for which the total number of key presses are required
	 * @return (String) Total number of key pressed for the word. -1 if any
	 *         character is not in the keypad. -Runs in O(n) time. Where n is
	 *         the length of the word.
	 */
	public String numberOfKeyPresses(String word) {
		word = word.toLowerCase();
		int press = 0;
		for (char ch : word.trim().toCharArray()) {
			int charPress = getIndexOfCharacter(getKeyOfCharacter(ch), ch);
			if (charPress == -1)
				return "-1";
			press += charPress + 1;
		}
		return press == 0 ? "-1" : ""+press;
	}

	/**
	 * 
	 * @param c
	 *            (char) Character for which the associated key is required
	 * @return (int) The key for the given character. -1 if character not in
	 *         keypad. -Runs in O(1) time. Uses hashmap to find the associated
	 *         key of the character. -1 if character not in keypad
	 */
	private int getKeyOfCharacter(char c) {
		if (characterPosition.get(String.valueOf(c)) == null)
			return -1;
		return characterPosition.get(String.valueOf(c));
	}

	/**
	 * 
	 * @param key
	 *            (int) The key of the character.
	 * @param c
	 *            (char) The character for which the index in the key is
	 *            required
	 * @return (int) The index at which at character is situated of the given
	 *         key. -1 if character or key is not found.
	 */
	private int getIndexOfCharacter(int key, char c) {
		if (key >= 0 && key < keypad.size())
			return keypad.get(key).indexOf(String.valueOf(c));
		return -1;
	}
}
