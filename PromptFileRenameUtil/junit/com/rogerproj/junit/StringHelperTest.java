package com.rogerproj.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.rogerproj.junitExample.StringHelper;

public class StringHelperTest {
	StringHelper shp; 

	@BeforeClass
	public static void createClass(){
		System.out.println(" Before: just calling before class ");
	}
	
	@Before
	public void createObject(){
		System.out.println(" @Before :Creating object for StringHelper ");
		shp = new StringHelper();
	}

	@Test
	public void testTruncateAInFirst2Positions() {
		assertEquals("BAB",shp.truncateAInFirst2Positions("ABAB"));
	}

	@Test
	public void testAreFirstAndLastTwoCharactersTheSame() {
		//fail("Not yet implemented");	
		assertEquals(true,shp.areFirstAndLastTwoCharactersTheSame("ABCAB"));
		assertFalse("Some helpful message",shp.areFirstAndLastTwoCharactersTheSame("ADBCAB"));
		assertTrue(shp.areFirstAndLastTwoCharactersTheSame("ABCAB"));
	}
	
	@After
	public void deleteObject(){
		shp=null;
		System.out.println(" After: deleting object for StringHelper ");
	}
}
