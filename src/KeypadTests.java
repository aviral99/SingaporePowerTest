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
	}

	@Test
	public void shouldReturnCorrectNumberRepresenation() {
		// assert statements
		assertEquals("43556", tester.wordToNumber("hello"));
		assertEquals("9", tester.wordToNumber("z"));
	}

}