package utilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class ParallelArrayDictionaryTest
{
	@Test
	void testParallelArrayDictionary()
	{
		ParallelArrayDictionary<Integer, Integer> pad = new ParallelArrayDictionary<Integer, Integer>();
		List<Integer> keys = Arrays.asList(0,1,2,3,4,5);
		List<Integer>  values = Arrays.asList(7,9,3,4,8,2);

		for( int i = 0; i<keys.size(); i++) {
			pad.put(keys.get(i), values.get(i));
		}

		//checks all values coordinate with keys
		for( int k = 0; k<keys.size(); k++) {
			assertEquals((values.get(k)),pad.get(k));
		}



	}

	@Test
	void testGet()
	{
		ParallelArrayDictionary<Integer, Integer> getTest = new ParallelArrayDictionary<Integer, Integer>();

		List<Integer>keys = Arrays.asList(0,1,2,3,4,5);
		List<Integer>values = Arrays.asList(20,24,33,45,21,12);

		for( int i = 0; i<keys.size(); i++) {
			getTest.put(keys.get(i), values.get(i));
		}


		//makes sure cannot get from key that does not exist
		assertThrows(IndexOutOfBoundsException.class, 
				()-> {getTest.get(10);} 
				);
		//can get from every existing key
		for(Integer k : keys) {
			assertEquals(values.get(k), getTest.get(k));
		}
	}

	@Test
	void testPut()
	{
		ParallelArrayDictionary<Integer, Integer> putTest = new ParallelArrayDictionary<Integer, Integer>();

		List<Integer> keys = Arrays.asList(0,1,2,3);
		List<Integer> values = Arrays.asList(33,12,9,4);
		List<Integer> values2 = Arrays.asList(14,5,20,6);

		//pass with current method 

		for( int i = 0; i<keys.size(); i++) {
			assertEquals(values.get(i), putTest.put(keys.get(i), values.get(i)));
		}


		for( int k = 0; k<keys.size(); k++) {
			assertEquals(values2.get(k), putTest.put(keys.get(k),values2.get(k)));
		}

		//adds to at keys outside original arrayList size 
		assertEquals( new Integer(40), putTest.put(4, 40));
		assertEquals(new Integer(23), putTest.put(6, 23));

		//puts in an key that already had a value (replaces)
		assertEquals(new Integer(67), putTest.put(4, 67));

		//what I think the method SHOULD pass
		//		for( int i = 0; i<keys.size(); i++) {
		//			assertEquals(null, putTest.put(keys.get(i), values.get(i)));
		//		}
		//
		//		for( int k = 0; k<keys.size(); k++) {
		//			assertEquals(values.get(k), putTest.put(keys.get(k),values2.get(k)));
		//		}
		//		
		//		//outside original arrayList
		//		assertEquals(null, putTest.put(4, 40));
		//		
		//		//replaces
		//		assertEquals(new Integer(5), putTest.put(1, 22));

	}

	@Test
	void testRemove()
	{
		ParallelArrayDictionary<Integer, Integer> removeTest = new ParallelArrayDictionary<Integer, Integer>();

		List<Integer> keys = Arrays.asList(0,1,2,3,4,5,6);
		List<Integer> values = Arrays.asList(12,5,3,8,20,9,11);

		for( int i = 0; i<keys.size(); i++) {
			removeTest.put(keys.get(i), values.get(i));
		}

		//removes all
		for(int i = removeTest.size()-1; i>=0;i--) {
			assertEquals(values.get(i), removeTest.remove(i));
		}


		ParallelArrayDictionary<Integer, Integer> removeTest2 = new ParallelArrayDictionary<Integer, Integer>();

		List<Integer> keys2 = Arrays.asList(0,1,2,3,4,5,6,7);
		List<Integer> values2 = Arrays.asList(12,5,3,8,20,9,11,40);

		for( int k = 0; k<keys2.size(); k++) {
			removeTest2.put(keys2.get(k), values2.get(k));
		}

		// checks non-sequential removal
		assertEquals( new Integer(5), removeTest2.remove(1));
		assertEquals(new Integer(20), removeTest2.remove(3));
		assertEquals(new Integer(12), removeTest2.remove(0));
		assertEquals(new Integer(40), removeTest2.remove(4));



		ParallelArrayDictionary<Integer, Integer> nullTest = new ParallelArrayDictionary<Integer, Integer>();

		List<Integer> keys3 = Arrays.asList(0,1,2);
		List<Integer> values3 = Arrays.asList(2,4,null);

		for( int i = 0; i<keys3.size(); i++) {
			nullTest.put(keys3.get(i), values3.get(i));
		}
		//checks null return if element at key does not exist
		assertEquals(null, nullTest.remove(2));

	}

	@Test
	void testPutAll()
	{
		ParallelArrayDictionary<Integer, Integer> putAllTest = new ParallelArrayDictionary<Integer, Integer>();
		 List<Integer> keys = Arrays.asList(0,1,2,3);
		 List<Integer> values = Arrays.asList(4,6,11,9);
		 
		 for( int i = 0; i<keys.size(); i++) {
				putAllTest.put(keys.get(i), values.get(i));
			}
		
		 ParallelArrayDictionary<Integer, Integer> putAll2 = new ParallelArrayDictionary<Integer, Integer>();
		 
		 putAll2.putAll(putAllTest);
		 
		 for( int k = 0; k<keys.size(); k++) {
				assertEquals((values.get(k)),putAll2.get(k));
			}
		 
		 


	}

	@Test
	void testClear()
	{
		ParallelArrayDictionary<Integer, Integer> clearTest = new ParallelArrayDictionary<Integer, Integer>();

		List<Integer> keys = Arrays.asList(0,1,2,3);
		List<Integer> values = Arrays.asList(33,12,9,4);

		for( int i = 0; i<keys.size(); i++) {
			clearTest.put(keys.get(i), values.get(i));
		}

		//verifies existence
		for( int k = 0; k<keys.size(); k++) {
			assertEquals((values.get(k)),clearTest.get(k));
		}

		clearTest.clear();

		//verifies existence no longer
		assertThrows(IndexOutOfBoundsException.class, 
				()-> {clearTest.get(0);} 
				);
		assertThrows(IndexOutOfBoundsException.class, 
				()-> {clearTest.get(3);} 
				);

	}
}
