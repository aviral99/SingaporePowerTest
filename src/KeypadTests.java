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

}