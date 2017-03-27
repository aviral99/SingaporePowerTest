import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class KeypadTests {
	KeypadParser tester = new KeypadParser("WordsRTF.RTF");

	@Test
	public void shouldReturnCorrectKeyPresses() {
		// assert statements
		assertEquals("13", tester.numberOfKeyPresses("hello"));
		assertEquals("1", tester.numberOfKeyPresses("a"));
		assertEquals("6", tester.numberOfKeyPresses("abc"));
		assertEquals("10", tester.numberOfKeyPresses("wxyz"));
		assertEquals("56", tester.numberOfKeyPresses("abcdefghijklmnopqrstuvwxyz"));
		assertEquals("-1", tester.numberOfKeyPresses("hello123"));
		assertEquals("-1", tester.numberOfKeyPresses("123"));
		assertEquals("-1", tester.numberOfKeyPresses("-123"));
		assertEquals("-1", tester.numberOfKeyPresses("!@#$%"));
		
	}

	@Test
	public void shouldReturnCorrectNumberRepresenation() {
		// assert statements
		assertEquals("43556", tester.wordToNumber("hello"));
		assertEquals("9", tester.wordToNumber("z"));
		assertEquals("22233344455566677778889999", tester.wordToNumber("abcdefghijklmnopqrstuvwxyz"));
		assertEquals("-1", tester.wordToNumber("123"));
		assertEquals("-1", tester.wordToNumber("-123"));
		assertEquals("-1", tester.wordToNumber("!@#$%"));
	}
	@Test
	public void shouldReturnCorrectLetterCombinations() {
		// assert statements
		ArrayList<String> testList = new ArrayList<String>();
		testList.add("w");
		testList.add("x");
		testList.add("y");
		testList.add("z");
		assertEquals(testList, tester.letterCombinations("9"));
		assertEquals(testList, tester.letterCombinations("09"));
		assertEquals(testList, tester.letterCombinations("90"));
		testList = new ArrayList<String>();
		testList.add("ad");
		testList.add("ae");
		testList.add("af");
		testList.add("bd");
		testList.add("be");
		testList.add("bf");
		testList.add("cd");
		testList.add("ce");
		testList.add("cf");
		assertEquals(testList, tester.letterCombinations("23"));
		assertEquals(testList, tester.letterCombinations("002003"));
		assertEquals(testList, tester.letterCombinations("002003000"));
		assertEquals(testList, tester.letterCombinations("1231110"));
		assertEquals(testList, tester.letterCombinations("123"));
		testList = new ArrayList<String>();
		assertEquals(testList, tester.letterCombinations("000"));
		assertEquals(testList, tester.letterCombinations("1010"));
		assertEquals(testList, tester.letterCombinations("hello"));
	}

}