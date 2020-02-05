package com.rogerproj.junit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rogerproj.junitExample.StringHelper;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {

	StringHelper sh= new StringHelper();
	private final String input;
	private final String expectedOutput;

	public StringHelperParameterizedTest(String input,String expectedOutput){
		this.input=input;
		this.expectedOutput=expectedOutput;
	}
	@Parameters
	public static Collection<String[]> getParmatrisedInputs(){
		String[][] inputs={{"TEST","TEST"},
				{"AABBC","BBC"},
				{"NATO","NTO"},
				{"ANGLO","NGLO"},
				{"ANDRE","NDRE"},
				{"AA",""},
				{"AARON","RON"}
		};
		return Arrays.asList(inputs);
	}

	@Test
	public void testTestTruncateAInFirst2Positions() {
		assertEquals(expectedOutput, sh.truncateAInFirst2Positions(input));
	}
}
