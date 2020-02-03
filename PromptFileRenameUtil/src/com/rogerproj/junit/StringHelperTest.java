package com.rogerproj.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.rogerproj.junitExample.StringHelper;

public class StringHelperTest {
	StringHelper shp = new StringHelper();
	@Test
	public void testTruncateAInFirst2Positions() {
		assertEquals("BAB",shp.truncateAInFirst2Positions("ABAB"));
	}

	@Test
	public void testAreFirstAndLastTwoCharactersTheSame() {
		//fail("Not yet implemented");	
		assertEquals(true,shp.areFirstAndLastTwoCharactersTheSame("ABCAB"));
		assertFalse("String to just let you know that it failed",shp.areFirstAndLastTwoCharactersTheSame("ADBCAB"));
		assertTrue(shp.areFirstAndLastTwoCharactersTheSame("ABCAB"));

	}

}
