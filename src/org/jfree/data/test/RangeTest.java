package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeTest {

    private Range rangeObjectUnderTest;

    @Before
    public void setUp() throws Exception {
        double lowerBoundToSet = -1.0;
        double upperBoundToSet = 1.0;
        rangeObjectUnderTest = new Range(lowerBoundToSet, upperBoundToSet);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCenteralValueShouldBeZero() throws Exception {
        String assertionMessage = "Central value should be 0.0";
        double expectedCentralValue = 0.0;
        Range currentRangeObject = this.rangeObjectUnderTest;
        double actualCentralValue = currentRangeObject.getCentralValue();
        double acceptableDelta = 0.000000001d;
        assertEquals(assertionMessage, expectedCentralValue, actualCentralValue, acceptableDelta);
    }
    
    @Test
    public void testContainsNominalValueInsideRange() throws Exception {
        double valueToTest = 0.0;
        Range currentRangeObject = this.rangeObjectUnderTest;
        boolean actualResult = currentRangeObject.contains(valueToTest);
        String assertionMessage = "Range should contain 0.0";
        assertTrue(assertionMessage, actualResult);
    }

    @Test
    public void testContainsNominalValueBelowRange() throws Exception {
        double valueToTest = -5.0;
        Range currentRangeObject = this.rangeObjectUnderTest;
        boolean actualResult = currentRangeObject.contains(valueToTest);
        String assertionMessage = "Range should not contain -5.0";
        assertFalse(assertionMessage, actualResult);
    }

    @Test
    public void testContainsNominalValueAboveRange() throws Exception {
        double valueToTest = 5.0;
        Range currentRangeObject = this.rangeObjectUnderTest;
        boolean actualResult = currentRangeObject.contains(valueToTest);
        String assertionMessage = "Range should not contain 5.0";
        assertFalse(assertionMessage, actualResult);
    }

    @Test
    public void testContainsLowerBoundaryValue() throws Exception {
        double valueToTest = -1.0;
        Range currentRangeObject = this.rangeObjectUnderTest;
        boolean actualResult = currentRangeObject.contains(valueToTest);
        String assertionMessage = "Range should contain lower bound -1.0";
        assertTrue(assertionMessage, actualResult);
    }

    @Test
    public void testContainsUpperBoundaryValue() throws Exception {
        double valueToTest = 1.0;
        Range currentRangeObject = this.rangeObjectUnderTest;
        boolean actualResult = currentRangeObject.contains(valueToTest);
        String assertionMessage = "Range should contain upper bound 1.0";
        assertTrue(assertionMessage, actualResult);
    }

    @Test
    public void testContainsValueJustBelowLowerBoundary() throws Exception {
        double valueToTest = -1.0000001;
        Range currentRangeObject = this.rangeObjectUnderTest;
        boolean actualResult = currentRangeObject.contains(valueToTest);
        String assertionMessage = "Range should not contain -1.0000001";
        assertFalse(assertionMessage, actualResult);
    }

    @Test
    public void testContainsValueJustAboveUpperBoundary() throws Exception {
        double valueToTest = 1.0000001;
        Range currentRangeObject = this.rangeObjectUnderTest;
        boolean actualResult = currentRangeObject.contains(valueToTest);
        String assertionMessage = "Range should not contain 1.0000001";
        assertFalse(assertionMessage, actualResult);
    }

    @Test
    public void testConstrainNominalValueInsideRange() throws Exception {
        double localLowerBound = -1.0;
        double localUpperBound = 1.0;
        Range range = new Range(localLowerBound, localUpperBound);
        double inputValue = 0.0;
        double actualResult = range.constrain(inputValue);
        double expectedResult = 0.0;
        double acceptableDelta = 0.0000001d;
        String message = "Constrain 0.0 should return 0.0";
        assertEquals(message, expectedResult, actualResult, acceptableDelta);
    }

    @Test
    public void testConstrainNominalValueBelowRange() throws Exception {
        double localLowerBound = -1.0;
        double localUpperBound = 1.0;
        Range range = new Range(localLowerBound, localUpperBound);
        double inputValue = -5.0;
        double actualResult = range.constrain(inputValue);
        double expectedResult = -1.0;
        double acceptableDelta = 0.0000001d;
        String message = "Constrain -5.0 should return -1.0";
        assertEquals(message, expectedResult, actualResult, acceptableDelta);
    }

    @Test
    public void testConstrainNominalValueAboveRange() throws Exception {
        double localLowerBound = -1.0;
        double localUpperBound = 1.0;
        Range range = new Range(localLowerBound, localUpperBound);
        double inputValue = 5.0;
        double actualResult = range.constrain(inputValue);
        double expectedResult = 1.0;
        double acceptableDelta = 0.0000001d;
        String message = "Constrain 5.0 should return 1.0";
        assertEquals(message, expectedResult, actualResult, acceptableDelta);
    }

    @Test
    public void testConstrainValueOnLowerBoundary() throws Exception {
        double localLowerBound = -1.0;
        double localUpperBound = 1.0;
        Range range = new Range(localLowerBound, localUpperBound);
        double inputValue = -1.0;
        double actualResult = range.constrain(inputValue);
        double expectedResult = -1.0;
        double acceptableDelta = 0.0000001d;
        String message = "Constrain -1.0 should return -1.0";
        assertEquals(message, expectedResult, actualResult, acceptableDelta);
    }

    @Test
    public void testConstrainValueOnUpperBoundary() throws Exception {
        double localLowerBound = -1.0;
        double localUpperBound = 1.0;
        Range range = new Range(localLowerBound, localUpperBound);
        double inputValue = 1.0;
        double actualResult = range.constrain(inputValue);
        double expectedResult = 1.0;
        double acceptableDelta = 0.0000001d;
        String message = "Constrain 1.0 should return 1.0";
        assertEquals(message, expectedResult, actualResult, acceptableDelta);
    }

    @Test
    public void testConstrainValueJustBelowLowerBoundary() throws Exception {
        double localLowerBound = -1.0;
        double localUpperBound = 1.0;
        Range range = new Range(localLowerBound, localUpperBound);
        double inputValue = -1.0000001;
        double actualResult = range.constrain(inputValue);
        double expectedResult = -1.0;
        double acceptableDelta = 0.0000001d;
        String message = "Constrain -1.0000001 should return -1.0";
        assertEquals(message, expectedResult, actualResult, acceptableDelta);
    }

    @Test
    public void testConstrainValueJustAboveUpperBoundary() throws Exception {
        double localLowerBound = -1.0;
        double localUpperBound = 1.0;
        Range range = new Range(localLowerBound, localUpperBound);
        double inputValue = 1.0000001;
        double actualResult = range.constrain(inputValue);
        double expectedResult = 1.0;
        double acceptableDelta = 0.0000001d;
        String message = "Constrain 1.0000001 should return 1.0";
        assertEquals(message, expectedResult, actualResult, acceptableDelta);
    }
    
    @Test
    public void testCombineOverlappingRanges() throws Exception {
        double r1Lower = -1.0;
        double r1Upper = 1.0;
        Range range1 = new Range(r1Lower, r1Upper);
        double r2Lower = 0.0;
        double r2Upper = 2.0;
        Range range2 = new Range(r2Lower, r2Upper);
        double expectedLower = -1.0;
        double expectedUpper = 2.0;
        Range expectedRange = new Range(expectedLower, expectedUpper);
        Range actualRange = Range.combine(range1, range2);
        String message = "Combine should yield (-1.0, 2.0)";
        assertEquals(message, expectedRange, actualRange);
    }

    @Test
    public void testCombineDisjointRanges() throws Exception {
        double r1Lower = -1.0;
        double r1Upper = 1.0;
        Range range1 = new Range(r1Lower, r1Upper);
        double r2Lower = 3.0;
        double r2Upper = 5.0;
        Range range2 = new Range(r2Lower, r2Upper);
        double expectedLower = -1.0;
        double expectedUpper = 5.0;
        Range expectedRange = new Range(expectedLower, expectedUpper);
        Range actualRange = Range.combine(range1, range2);
        String message = "Combine disjoint should yield (-1.0, 5.0)";
        assertEquals(message, expectedRange, actualRange);
    }

    @Test
    public void testCombineWithSecondRangeNull() throws Exception {
        double r1Lower = -1.0;
        double r1Upper = 1.0;
        Range range1 = new Range(r1Lower, r1Upper);
        Range range2 = null;
        double expectedLower = -1.0;
        double expectedUpper = 1.0;
        Range expectedRange = new Range(expectedLower, expectedUpper);
        Range actualRange = Range.combine(range1, range2);
        String message = "Combine with null range2 should return range1";
        assertEquals(message, expectedRange, actualRange);
    }

    @Test
    public void testCombineWithFirstRangeNull() throws Exception {
        Range range1 = null;
        double r2Lower = 0.0;
        double r2Upper = 2.0;
        Range range2 = new Range(r2Lower, r2Upper);
        double expectedLower = 0.0;
        double expectedUpper = 2.0;
        Range expectedRange = new Range(expectedLower, expectedUpper);
        Range actualRange = Range.combine(range1, range2);
        String message = "Combine with null range1 should return range2";
        assertEquals(message, expectedRange, actualRange);
    }

    @Test
    public void testCombineWithBothRangesNull() throws Exception {
        Range range1 = null;
        Range range2 = null;
        Range actualRange = Range.combine(range1, range2);
        String message = "Combine two nulls should return null";
        assertNull(message, actualRange);
    }

    @Test
    public void testIntersectsRangeEntirelyBelow() throws Exception {
        double inputB0 = -5.0;
        double inputB1 = -3.0;
        Range currentRange = this.rangeObjectUnderTest;
        boolean actualResult = currentRange.intersects(inputB0, inputB1);
        String message = "Interval below should not intersect";
        assertFalse(message, actualResult);
    }

    @Test
    public void testIntersectsRangePartialOverlapLower() throws Exception {
        double inputB0 = -5.0;
        double inputB1 = 0.0;
        Range currentRange = this.rangeObjectUnderTest;
        boolean actualResult = currentRange.intersects(inputB0, inputB1);
        String message = "Interval overlapping lower should intersect";
        assertTrue(message, actualResult);
    }

    @Test
    public void testIntersectsRangeEncompassing() throws Exception {
        double inputB0 = -5.0;
        double inputB1 = 5.0;
        Range currentRange = this.rangeObjectUnderTest;
        boolean actualResult = currentRange.intersects(inputB0, inputB1);
        String message = "Encompassing interval should intersect";
        assertTrue(message, actualResult);
    }

    @Test
    public void testIntersectsRangeEntirelyInside() throws Exception {
        double inputB0 = -0.5;
        double inputB1 = 0.5;
        Range currentRange = this.rangeObjectUnderTest;
        boolean actualResult = currentRange.intersects(inputB0, inputB1);
        String message = "Interval inside should intersect";
        assertTrue(message, actualResult);
    }

    @Test
    public void testIntersectsRangePartialOverlapUpper() throws Exception {
        double inputB0 = 0.0;
        double inputB1 = 5.0;
        Range currentRange = this.rangeObjectUnderTest;
        boolean actualResult = currentRange.intersects(inputB0, inputB1);
        String message = "Interval overlapping upper should intersect";
        assertTrue(message, actualResult);
    }

    @Test
    public void testIntersectsRangeEntirelyAbove() throws Exception {
        double inputB0 = 3.0;
        double inputB1 = 5.0;
        Range currentRange = this.rangeObjectUnderTest;
        boolean actualResult = currentRange.intersects(inputB0, inputB1);
        String message = "Interval above should not intersect";
        assertFalse(message, actualResult);
    }

    @Test
    public void testIntersectsOnLowerBoundary() throws Exception {
        double inputB0 = -1.0;
        double inputB1 = -1.0;
        Range currentRange = this.rangeObjectUnderTest;
        boolean actualResult = currentRange.intersects(inputB0, inputB1);
        String message = "Interval on lower boundary should intersect";
        assertTrue(message, actualResult);
    }

    @Test
    public void testIntersectsOnUpperBoundary() throws Exception {
        double inputB0 = 1.0;
        double inputB1 = 1.0;
        Range currentRange = this.rangeObjectUnderTest;
        boolean actualResult = currentRange.intersects(inputB0, inputB1);
        String message = "Interval on upper boundary should intersect";
        assertTrue(message, actualResult);
    }

    @Test
    public void testExpandToIncludeValueBelowRange() throws Exception {
        double inputValue = -5.0;
        Range baseRange = this.rangeObjectUnderTest;
        double expectedLower = -5.0;
        double expectedUpper = 1.0;
        Range expectedRange = new Range(expectedLower, expectedUpper);
        Range actualRange = Range.expandToInclude(baseRange, inputValue);
        String message = "Expand to -5.0 should yield (-5.0, 1.0)";
        assertEquals(message, expectedRange, actualRange);
    }

    @Test
    public void testExpandToIncludeValueInsideRange() throws Exception {
        double inputValue = 0.0;
        Range baseRange = this.rangeObjectUnderTest;
        double expectedLower = -1.0;
        double expectedUpper = 1.0;
        Range expectedRange = new Range(expectedLower, expectedUpper);
        Range actualRange = Range.expandToInclude(baseRange, inputValue);
        String message = "Expand to 0.0 should yield (-1.0, 1.0)";
        assertEquals(message, expectedRange, actualRange);
    }

    @Test
    public void testExpandToIncludeValueAboveRange() throws Exception {
        double inputValue = 5.0;
        Range baseRange = this.rangeObjectUnderTest;
        double expectedLower = -1.0;
        double expectedUpper = 5.0;
        Range expectedRange = new Range(expectedLower, expectedUpper);
        Range actualRange = Range.expandToInclude(baseRange, inputValue);
        String message = "Expand to 5.0 should yield (-1.0, 5.0)";
        assertEquals(message, expectedRange, actualRange);
    }

    @Test
    public void testExpandToIncludeWithNullRange() throws Exception {
        double inputValue = 2.0;
        Range baseRange = null;
        double expectedLower = 2.0;
        double expectedUpper = 2.0;
        Range expectedRange = new Range(expectedLower, expectedUpper);
        Range actualRange = Range.expandToInclude(baseRange, inputValue);
        String message = "Expand null to 2.0 should yield (2.0, 2.0)";
        assertEquals(message, expectedRange, actualRange);
    }

    @Test
    public void testExpandToIncludeValueOnLowerBoundary() throws Exception {
        double inputValue = -1.0;
        Range baseRange = this.rangeObjectUnderTest;
        double expectedLower = -1.0;
        double expectedUpper = 1.0;
        Range expectedRange = new Range(expectedLower, expectedUpper);
        Range actualRange = Range.expandToInclude(baseRange, inputValue);
        String message = "Expand to lower bound should yield (-1.0, 1.0)";
        assertEquals(message, expectedRange, actualRange);
    }

    @Test
    public void testExpandToIncludeValueOnUpperBoundary() throws Exception {
        double inputValue = 1.0;
        Range baseRange = this.rangeObjectUnderTest;
        double expectedLower = -1.0;
        double expectedUpper = 1.0;
        Range expectedRange = new Range(expectedLower, expectedUpper);
        Range actualRange = Range.expandToInclude(baseRange, inputValue);
        String message = "Expand to upper bound should yield (-1.0, 1.0)";
        assertEquals(message, expectedRange, actualRange);
    }
}