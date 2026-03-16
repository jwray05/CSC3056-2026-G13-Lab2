package org.jfree.data.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import org.jfree.data.Range;

public class RangeAdditionalTest {

	    // ---------------------------
	    // Tests for combine()
	    // ---------------------------

	    @Test
	    public void testCombineOverlappingRanges() {
	        Range r1 = new Range(0, 10);
	        Range r2 = new Range(5, 15);

	        Range result = Range.combine(r1, r2);

	        assertEquals(0, result.getLowerBound(), 0.0001);
	        assertEquals(15, result.getUpperBound(), 0.0001);
	    }

	    @Test
	    public void testCombineDisjointRanges() {
	        Range r1 = new Range(0, 5);
	        Range r2 = new Range(10, 20);

	        Range result = Range.combine(r1, r2);

	        assertEquals(0, result.getLowerBound(), 0.0001);
	        assertEquals(20, result.getUpperBound(), 0.0001);
	    }

	    @Test
	    public void testCombineWithNullRange() {
	        Range r1 = null;
	        Range r2 = new Range(5, 10);

	        Range result = Range.combine(r1, r2);

	        assertEquals(5, result.getLowerBound(), 0.0001);
	        assertEquals(10, result.getUpperBound(), 0.0001);
	    }


	    // ---------------------------
	    // Tests for expand()
	    // ---------------------------

	    @Test
	    public void testExpandNormalMargins() {
	        Range r = new Range(10, 20);

	        Range result = Range.expand(r, 0.1, 0.1);

	        assertEquals(9, result.getLowerBound(), 0.0001);
	        assertEquals(21, result.getUpperBound(), 0.0001);
	    }

	    @Test
	    public void testExpandZeroMargins() {
	        Range r = new Range(10, 20);

	        Range result = Range.expand(r, 0.0, 0.0);

	        assertEquals(10, result.getLowerBound(), 0.0001);
	        assertEquals(20, result.getUpperBound(), 0.0001);
	    }


	    // ---------------------------
	    // Tests for getLength()
	    // ---------------------------

	    @Test
	    public void testGetLengthNormalRange() {
	        Range r = new Range(0, 10);

	        assertEquals(10, r.getLength(), 0.0001);
	    }

	    @Test
	    public void testGetLengthSinglePointRange() {
	        Range r = new Range(5, 5);

	        assertEquals(0, r.getLength(), 0.0001);
	    }


	    // ---------------------------
	    // Tests for getLowerBound()
	    // ---------------------------

	    @Test
	    public void testGetLowerBoundPositiveRange() {
	        Range r = new Range(3, 8);

	        assertEquals(3, r.getLowerBound(), 0.0001);
	    }

	    @Test
	    public void testGetLowerBoundNegativeRange() {
	        Range r = new Range(-10, 5);

	        assertEquals(-10, r.getLowerBound(), 0.0001);
	    }


	    // ---------------------------
	    // Tests for getUpperBound()
	    // ---------------------------

	    @Test
	    public void testGetUpperBoundPositiveRange() {
	        Range r = new Range(3, 8);

	        assertEquals(8, r.getUpperBound(), 0.0001);
	    }

	    @Test
	    public void testGetUpperBoundNegativeRange() {
	        Range r = new Range(-10, -2);

	        assertEquals(-2, r.getUpperBound(), 0.0001);
	    }
	

}
