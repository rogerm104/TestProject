package com.rogerproj.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ LinkedListTest.class, StringHelperParameterizedTest.class,
		StringHelperTest.class, TestArraySort.class })
public class TestSutieConsolidation1 {

}
