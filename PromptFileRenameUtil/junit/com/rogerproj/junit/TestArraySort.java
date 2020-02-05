package com.rogerproj.junit;

import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestArraySort {
	
	   int[] arrRandom={18,120,6,9};
	   int[] arrSorted={6,9,18,120};

	@Before
	public void setup(){
		System.out.println("@Before Random Array = "+Arrays.toString(arrRandom));
		//arrRandom=null;
	}
	//@Test(expected=NullPointerException.class)
	@Test(timeout=100)
	public void checkArraySorted(){
		Arrays.sort(arrRandom);
		Assert.assertArrayEquals(arrSorted,arrRandom);
	}
	@After
	public void printArraySorted(){
		System.out.println("@After Random Array = "+Arrays.toString(arrRandom));

	}

}
