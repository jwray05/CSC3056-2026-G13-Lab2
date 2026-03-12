package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataUtilitiesTest {

	private Values2D values2D;

	@Before
	public void setUp() {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(1, 0, 0);
		testValues.addValue(4, 1, 0);
		testValues.addValue(2.5, 0, 1);
		testValues.addValue(3.5, 1, 1);
	}

	@After
	public void tearDown() {
		values2D = null;
	}

	@Test
	// column 0, 1 + 4 = 5
	public void testCalculateColumnTotalWithValidData0() {
		assertEquals("Column 0 total should be 5.0", 5.0, DataUtilities.calculateColumnTotal(values2D, 0),
				0.0000001d);
	}

	@Test
	// column 1, 2.5 + 3.5 = 6
	public void testCalculateColumnTotalWithValidData1() {
		assertEquals("Column 1 total should be 6.0", 6.0, DataUtilities.calculateColumnTotal(values2D, 1),
				0.0000001d);
	}

	@Test
	// invalid column should return 0.0
	public void testCalculateColumnTotalWithNegativeColumn() {
		try {
			assertEquals("Negative column index should return 0.0", 0.0,
					DataUtilities.calculateColumnTotal(values2D, -1), 0.0000001d);
		} catch (Exception e) {
			fail("Unexpected exception thrown: " + e.getClass().getName());
		}
	}

	@Test
	public void testCalculateColumnTotalWithNullData() {
		try {
			DataUtilities.calculateColumnTotal(null, 0);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}

	@Test
	// column 21 does not exist, so return 0.0
	public void testCalculateColumnTotalWithOutOfRangeColumn() {
		try {
			assertEquals("Out of range column index should return 0", 0.0,
					DataUtilities.calculateColumnTotal(values2D, 21), 0.0000001d);
		} catch (Exception e) {
			fail("Unexpected exception thrown: " + e.getClass().getName());
		}
	}


	@Test
	public void testCalculateRowTotalWithValidRow0() {
		assertEquals("Row 0 total should be 3.5", 3.5, DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d);
	}

	@Test
	public void testCalculateRowTotalWithValidRow1() {
		assertEquals("Row 1 total should be 7.5", 7.5, DataUtilities.calculateRowTotal(values2D, 1), 0.0000001d);
	}

	@Test
	public void testCalculateRowTotalWithNegativeRow() {
		try {
	        assertEquals("Negative row index should return 0.0", 0.0,
	                DataUtilities.calculateRowTotal(values2D, -1), 0.0000001d);
	    } catch (Exception e) {
	        fail("Unexpected exception thrown: " + e.getClass().getName());
	    }
	}

	@Test
	public void testCalculateRowTotalWithOutOfRangeRow() {
		try {
	        assertEquals("Out of range row index should return 0.0", 0.0,
	                DataUtilities.calculateRowTotal(values2D, 2), 0.0000001d);
	    } catch (Exception e) {
	        fail("Unexpected exception thrown: " + e.getClass().getName());
	    }
	}

	@Test
	public void testCalculateRowTotalWithNullData() {
		try {
			DataUtilities.calculateRowTotal(null, 0);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}

	@Test
	public void testCalculateRowTotalWithNullDataNegativeRow() {
		try {
			DataUtilities.calculateRowTotal(null, -1);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}

	@Test
	public void testCalculateRowTotalWithNullDataOutOfRangeRow() {
		try {
			DataUtilities.calculateRowTotal(null, 2);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	
	
	/*NUMBER ARRAY*/
	
	
	
	
	
	
	//checking for multiple doubles first 
    @Test
    public void testCreateNumberArrayWithMultipleNumbers() {
    	try {
        double[] data = {1.0, 2.5, 5.0};
        Number[] result = DataUtilities.createNumberArray(data);

        assertNotNull("Returned array should not be null", result);
        assertEquals("Returned array length should be 3", 3, result.length);
        
        assertNotNull("First returned value should not be null", result[0]);
        assertNotNull("Second returned value should not be null", result[1]);
        assertNotNull("Third returned value should not be null", result[2]);
        
        assertEquals("First value incorrect", 1.0, result[0].doubleValue(), 0.0000001d);
        assertEquals("Second value incorrect", 2.5, result[1].doubleValue(), 0.0000001d);
        assertEquals("Third value incorrect", 5.0, result[2].doubleValue(), 0.0000001d);
    	} catch(Exception e) {
    		fail("Unexpected exception thrown: " + e.getClass().getName());
    	}
    	
    }
    

    //checking for 1 input
    @Test
    public void testCreateNumberArrayWithSingleNumber() {
    	try {
        double[] data = {3.25};
        Number[] result = DataUtilities.createNumberArray(data);
        
        assertNotNull("Returned array should not be null", result);
        assertNotNull("Only returned value should not be null", result[0]);
        assertEquals("Returned array length should be 1", 1, result.length);
        assertEquals("Single value incorrect", 3.25, result[0].doubleValue(), 0.0000001d);
    	}catch (Exception e) {
    		fail("Unexpected exception thrown: " + e.getClass().getName());
    	}
    }

    //checking for empty array input
    @Test
    public void testCreateNumberArrayWithAnEmptyArray() {
        double[] data = {};
        Number[] result = DataUtilities.createNumberArray(data);

        assertNotNull("Returned array should not be null", result);
        assertEquals("Returned array should be empty", 0, result.length);
    }

    //checking it works for positive negative and zero
    @Test
    public void testCreateNumberArrayWithNegativeZeroPositiveValues() {
    	try {
        double[] data = {-3.5, 0.0, 8};
        Number[] result = DataUtilities.createNumberArray(data);

        assertNotNull("Returned array should not be null", result);
        assertEquals("Returned array length should be 3", 3, result.length);
        
        assertNotNull("First returned value should not be null", result[0]);
        assertNotNull("Second returned value should not be null", result[1]);
        assertNotNull("Third returned value should not be null", result[2]);
        
        assertEquals("First value incorrect", -3.5, result[0].doubleValue(), 0.0000001d);
        assertEquals("Second value incorrect", 0.0, result[1].doubleValue(), 0.0000001d);
        assertEquals("Third value incorrect", 8, result[2].doubleValue(), 0.0000001d);
    	}catch (Exception e) {
    		fail("Unexpected exception thrown: " + e.getClass().getName());
    	}
    }
    
    
    //checking null instead of empty
    @Test
    public void testCreateNumberArrayNullInput() {
        try {
            DataUtilities.createNumberArray(null);
            fail("Expected IllegalArgumentException for null input");
        } catch (Exception e) {
            assertTrue("Incorrect exception type thrown",
                    e.getClass().equals(IllegalArgumentException.class));
        }
    }
    
    
    @Test
    public void testCreateNumberArrayWithNaNValue() {
        try {
            double[] data = {Double.NaN};
            Number[] result = DataUtilities.createNumberArray(data);

            assertNotNull("Returned array should not be null", result);
            assertEquals("Returned array length should be 1", 1, result.length);
            assertNotNull("Returned value should not be null", result[0]);
            assertTrue("Returned value should be NaN", Double.isNaN(result[0].doubleValue()));
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getClass().getName());
        }
    }

    
    
    
    
    
    
    
    
    
    
  //testing converting doubles Array 2D to number type with multiple rows
    @Test
    public void testCreateNumberArray2DWithMultipleRows() {
        try {
            double[][] data = {
                {1.0, 2.0},
                {3.5, 4.5}
            };

            Number[][] result = DataUtilities.createNumberArray2D(data);

            assertNotNull("Returned array should not be null", result);
            assertEquals("Returned array length should be 2", 2, result.length);
            assertEquals("First row length should be 2", 2, result[0].length);
            assertEquals("Second row length should be 2", 2, result[1].length);

            assertNotNull("First returned value should not be null", result[0][0]);
            assertNotNull("Second returned value should not be null", result[0][1]);
            assertNotNull("Third returned value should not be null", result[1][0]);
            assertNotNull("Fourth returned value should not be null", result[1][1]);

            assertEquals("First value incorrect", 1.0, result[0][0].doubleValue(), 0.0000001d);
            assertEquals("Second value incorrect", 2.0, result[0][1].doubleValue(), 0.0000001d);
            assertEquals("Third value incorrect", 3.5, result[1][0].doubleValue(), 0.0000001d);
            assertEquals("Fourth value incorrect", 4.5, result[1][1].doubleValue(), 0.0000001d);
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getClass().getName());
        }
    }

    //testing single row input
    @Test
    public void testCreateNumberArray2DWithSingleRow() {
        try {
            double[][] data = {
                {5.0, 8.65}
            };

            Number[][] result = DataUtilities.createNumberArray2D(data);

            assertNotNull("Returned array should not be null", result);
            assertEquals("Returned array length should be 1", 1, result.length);
            assertEquals("Row length should be 2", 2, result[0].length);

            assertNotNull("First returned value should not be null", result[0][0]);
            assertNotNull("Second returned value should not be null", result[0][1]);

            assertEquals("First value incorrect", 5.0, result[0][0].doubleValue(), 0.0000001d);
            assertEquals("Second value incorrect", 8.65, result[0][1].doubleValue(), 0.0000001d);
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getClass().getName());
        }
    }

    //testing empty input
    @Test
    public void testCreateNumberArray2DWithEmptyInput() {
        try {
            double[][] data = {};

            Number[][] result = DataUtilities.createNumberArray2D(data);

            assertNotNull("Returned array should not be null", result);
            assertEquals("Returned array should be empty", 0, result.length);
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getClass().getName());
        }
    }

    //testing empty first row
    @Test
    public void testCreateNumberArray2DWithEmptyFirstRow() {
        try {
            double[][] data = {
                {},
                {1.0}
            };

            Number[][] result = DataUtilities.createNumberArray2D(data);

            assertNotNull("Returned array should not be null", result);
            assertEquals("Returned array length should be 2", 2, result.length);
            assertEquals("First row should be empty", 0, result[0].length);
            assertEquals("Second row length should be 1", 1, result[1].length);

            assertNotNull("Returned value should not be null", result[1][0]);
            assertEquals("Returned value incorrect", 1.0, result[1][0].doubleValue(), 0.0000001d);
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getClass().getName());
        }
    }

    //testing empty second row
    @Test
    public void testCreateNumberArray2DWithEmptySecondRow() {
        try {
            double[][] data = {
                {3.0},
                {}
            };

            Number[][] result = DataUtilities.createNumberArray2D(data);

            assertNotNull("Returned array should not be null", result);
            assertEquals("Returned array length should be 2", 2, result.length);
            assertEquals("First row length should be 1", 1, result[0].length);
            assertEquals("Second row should be empty", 0, result[1].length);

            assertNotNull("Returned value should not be null", result[0][0]);
            assertEquals("Returned value incorrect", 3.0, result[0][0].doubleValue(), 0.0000001d);
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getClass().getName());
        }
    }

    @Test
    public void testCreateNumberArray2DWithNegativeZeroPositiveValues() {
        try {
            double[][] data = {
                {-5.0, 0.0},
                {8.95, -2.15}
            };

            Number[][] result = DataUtilities.createNumberArray2D(data);

            assertNotNull("Returned array should not be null", result);
            assertEquals("Returned array length should be 2", 2, result.length);
            assertEquals("First row length should be 2", 2, result[0].length);
            assertEquals("Second row length should be 2", 2, result[1].length);

            assertNotNull("First returned value should not be null", result[0][0]);
            assertNotNull("Second returned value should not be null", result[0][1]);
            assertNotNull("Third returned value should not be null", result[1][0]);
            assertNotNull("Fourth returned value should not be null", result[1][1]);

            assertEquals("First value incorrect", -5.0, result[0][0].doubleValue(), 0.0000001d);
            assertEquals("Second value incorrect", 0.0, result[0][1].doubleValue(), 0.0000001d);
            assertEquals("Third value incorrect", 8.95, result[1][0].doubleValue(), 0.0000001d);
            assertEquals("Fourth value incorrect", -2.15, result[1][1].doubleValue(), 0.0000001d);
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getClass().getName());
        }
    }

    @Test
    public void testCreateNumberArray2DWithNullInput() {
        try {
            DataUtilities.createNumberArray2D(null);
            fail("Expected IllegalArgumentException for null input");
        } catch (Exception e) {
            assertTrue("Incorrect exception type thrown",
                    e.getClass().equals(IllegalArgumentException.class));
        }
    }
    
    
    
    
    
    
    
    
    
    
    
   

    @Test
    public void testGetCumulativePercentagesWithMultiplePositiveValues() {
        DefaultKeyedValues keyvalues = new DefaultKeyedValues();
        keyvalues.addValue("A", 5);
        keyvalues.addValue("B", 9);
        keyvalues.addValue("C", 2);

        KeyedValues result = DataUtilities.getCumulativePercentages(keyvalues);

        assertEquals("Result should contain 3 items", 3, result.getItemCount());
        assertEquals("First key incorrect", "A", result.getKey(0));
        assertEquals("Second key incorrect", "B", result.getKey(1));
        assertEquals("Third key incorrect", "C", result.getKey(2));

        assertNotNull("First returned value should not be null", result.getValue(0));
        assertNotNull("Second returned value should not be null", result.getValue(1));
        assertNotNull("Third returned value should not be null", result.getValue(2));

        assertEquals("First cumulative percentage incorrect",
                0.3125, result.getValue(0).doubleValue(), 0.0000001d);
        assertEquals("Second cumulative percentage incorrect",
                0.875, result.getValue(1).doubleValue(), 0.0000001d);
        assertEquals("Third cumulative percentage incorrect",
                1.0, result.getValue(2).doubleValue(), 0.0000001d);
    }

    @Test
    public void testGetCumulativePercentagesWithSinglePostiveValue() {
        DefaultKeyedValues keyvalues = new DefaultKeyedValues();
        keyvalues.addValue("A", 4);

        KeyedValues result = DataUtilities.getCumulativePercentages(keyvalues);

        assertEquals("Result should contain 1 item", 1, result.getItemCount());
        assertEquals("Key incorrect", "A", result.getKey(0));
        assertNotNull("Returned value should not be null", result.getValue(0));
        assertEquals("Single item cumulative percentage should be 1.0",
                1.0, result.getValue(0).doubleValue(), 0.0000001d);
     
    }

    
    @Test
    public void testGetCumulativePercentagesWithNegativeValues() {
        DefaultKeyedValues keyvalues = new DefaultKeyedValues();
        keyvalues.addValue("A", -2);
        keyvalues.addValue("B", -3);

        KeyedValues result = DataUtilities.getCumulativePercentages(keyvalues);

        assertEquals("Result should contain 2 items", 2, result.getItemCount());
        assertEquals("First key incorrect", "A", result.getKey(0));
        assertEquals("Second key incorrect", "B", result.getKey(1));

        assertNotNull("First returned value should not be null", result.getValue(0));
        assertNotNull("Second returned value should not be null", result.getValue(1));

        assertEquals("First cumulative percentage incorrect",
                0.4, result.getValue(0).doubleValue(), 0.0000001d);
        assertEquals("Second cumulative percentage incorrect",
                1.0, result.getValue(1).doubleValue(), 0.0000001d);
    }

    
    
    
    @Test
    public void testGetCumulativePercentagesWithZeroValue() {
        DefaultKeyedValues keyvalues = new DefaultKeyedValues();
        keyvalues.addValue("A", 0);
        keyvalues.addValue("B", 4);
        keyvalues.addValue("C", 4);

        KeyedValues result = DataUtilities.getCumulativePercentages(keyvalues);

        assertEquals("Result should contain 3 items", 3, result.getItemCount());

        assertNotNull("First returned value should not be null", result.getValue(0));
        assertNotNull("Second returned value should not be null", result.getValue(1));
        assertNotNull("Third returned value should not be null", result.getValue(2));

        assertEquals("First cumulative percentage incorrect",
                0.0, result.getValue(0).doubleValue(), 0.0000001d);
        assertEquals("Second cumulative percentage incorrect",
                0.5, result.getValue(1).doubleValue(), 0.0000001d);
        assertEquals("Third cumulative percentage incorrect",
                1.0, result.getValue(2).doubleValue(), 0.0000001d);
    }

    @Test
    public void testGetCumulativePercentagesWithEmptyData() {
        DefaultKeyedValues keyvalues = new DefaultKeyedValues();

        KeyedValues result = DataUtilities.getCumulativePercentages(keyvalues);

        assertEquals("Result should be empty", 0, result.getItemCount());
    }

    @Test
    public void testGetCumulativePercentagesWithNullInput() {
        try {
            DataUtilities.getCumulativePercentages(null);
            fail("Expected IllegalArgumentException for null input");
        } catch (Exception e) {
            assertTrue("Incorrect exception type thrown",
                    e.getClass().equals(IllegalArgumentException.class));
        }
    }




}

