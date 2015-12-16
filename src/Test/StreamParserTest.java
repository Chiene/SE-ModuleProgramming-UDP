package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import UDPModule.Tool.StreamParser;

public class StreamParserTest {

	@Test
	public void testMsgCorrectFormat() {
		assertFalse(StreamParser.getMsgToken("ADD Item testetst").length != 3);
	}

	@Test
	public void testMsgFaliureFormatWithNoSpace() {
		assertFalse(StreamParser.getMsgToken("ADDItemtestetst").length != 3);
	}

	@Test
	public void testMsgFaliureFormatWithOneSpace() {
		assertFalse(StreamParser.getMsgToken("ADDItem testetst").length != 3);
	}

	@Test
	public void testMsgEmpty() {
		assertFalse(StreamParser.getMsgToken(" ").length != 3);
	}

}
