package utilities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		
		int[]  set = new int[] {4,3,-6,17,932};
		Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(2,-8));
		
		
		for(int i : set) {
			list.add(i);
		}
		
		list.addAll(set2);
		//can addAll() valid elements
		assertTrue (list.addAll(set2));
		
		//cannot add all duplicate elements
		assertTrue(list.addAll(set2));
	
	}

	@Test
	void testRetainAll() {
		ArraySet<Integer> list = new ArraySet<Integer>();
		
		int[] set = new int[]{2,-1,3,7,496,5};
		
		for(int i : set) {
			list.add(i);
		}
		
		Set<Integer> r = new HashSet<Integer>(Arrays.asList(7,3,-1));
		//test valid retain elements
		assertTrue(list.retainAll(r));
		
		ArraySet<Integer> list2 = new ArraySet<Integer>();
		
		for(int i : set) {
			list2.add(i);
		}
		

		Set<Integer> fail = new HashSet<Integer>(Arrays.asList(88,5,21));
		
		//does not retain invalid elmts 
		assertTrue(list2.retainAll(fail));

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
