package utilities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArraySetTest
{
	@Test
	void testArraySetCollectionOfE() {
		ArraySet<Integer> list = new ArraySet<Integer>();
		
		assertFalse(true);
	}

	@Test
	void testAddE() {
		ArraySet<Integer> list = new ArraySet<Integer>();
		
		int[] set = new int[]{2,-1,3,7,496,5};
		
		// testing add() that changes the content of list
		for (int i : set) {
			assertTrue(list.add(i));
		}
		
		// testing add() that does not change the content of list
		// (elements added above so no content changes should occur)
		for (int i : set) {
			assertFalse(list.add(i));
		}
	}

	@Test
	void testAddAllCollectionOfQextendsE() {
		ArraySet<Integer> list = new ArraySet<Integer>();
	
		assertFalse(true);
	}

	@Test
	void testRetainAll() {
		ArraySet<Integer> list = new ArraySet<Integer>();
		
		assertFalse(true);
	}

	@Test
	void testRemoveAll() {
		ArraySet<Integer> list = new ArraySet<Integer>();
		
		assertFalse(true);
	}

	@Test
	void testAddAllIntCollectionOfQextendsE() {
		ArraySet<Integer> list = new ArraySet<Integer>();
		
		assertFalse(true);
	}
}
