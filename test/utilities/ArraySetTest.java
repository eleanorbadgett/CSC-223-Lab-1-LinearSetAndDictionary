package utilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class ArraySetTest
{
	@Test
	void testArraySetCollectionOfE() {
		ArraySet<Integer> list = new ArraySet<Integer>();
		
		Set<Integer> set = new HashSet<Integer>(Arrays.asList(2,-8,44,21,-4));
		
		for (int i : set) {
			list.add(i);
		}
		
		assertTrue(set.equals(list));
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
		
		Set<Integer> set = new HashSet<Integer>(Arrays.asList(2,-8));
		Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(2,-8,4,3));
		Set<Integer> set3 = new HashSet<Integer>(Arrays.asList(3,4));
		Set<Integer> set4 = new HashSet<Integer>(Arrays.asList());
		
		// testing addAll() that changes list
		assertTrue(list.addAll(set));
		
		// testing addAll() that changes part of list
		assertTrue(list.addAll(set2));
		
		// testing addAll() that does not change list (adds duplicates)
		assertFalse(list.addAll(set3));
		
		// testing addAll() that does not change the list (adds nothing)
		assertFalse(list.addAll(set4));
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
		ArraySet<Integer> listCorrect = new ArraySet<Integer>();
		
		int [] set = new int[] {7,5,-3,9,2};
		
		for(int i : set) {
			list.add(i);
		}
		
		int [] set2 = new int[] {5,9};
		
		for(int i : set2) {
			listCorrect.add(i);
		}
		
		Set<Integer> remove = new HashSet<Integer>(Arrays.asList(7,2,-3));
		
		// checks the the list changed
		assertTrue(list.removeAll(remove));
		
		// checks that the list contains the correct values
		assertEquals(listCorrect, list);
		
		// removing rest of list (intentionally with elements not in same order)
		Set<Integer> remove2 = new HashSet<Integer>(Arrays.asList(9,5));

		// checks that the list changed
		assertTrue(list.removeAll(remove2));
		
		// checks that the list is now empty
		assertTrue(list.isEmpty());
		
		// now to check for element not in list
		Set<Integer> remove3 = new HashSet<Integer>(Arrays.asList(-3));
		
		// -3 is not in list (empty), so no change
		assertFalse(list.removeAll(remove3));
		
		// -3 is not in list (-5), so no change
		list.add(-5);
		assertFalse(list.removeAll(remove3));
		
		// now to check empty remove
		Set<Integer> remove4 = new HashSet<Integer>(Arrays.asList());
		
		// no items to remove, so no change
		assertFalse(list.removeAll(remove4));
	}

	@Test
	void testAddAllIntCollectionOfQextendsE() {
		
		ArraySet<Integer> list = new ArraySet<Integer>();
		int[] arr = new int[] {6,-4,3};
		
		for(int i : arr) {
			list.add(i);
		}
		
		Set<Integer> set = new HashSet<Integer>(Arrays.asList(19,-1,5));
		Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(2,-3));
		Set<Integer> set3 = new HashSet<Integer>(Arrays.asList(2,-3,99,-100));
		Set<Integer> set4 = new HashSet<Integer>(Arrays.asList(11,-13));
		
		// adds to the start of the set
		assertTrue(list.addAll(0, set));
		
		// adds to the middle of the set
		assertTrue(list.addAll(1, set2));
		
		// adds to the set with all duplicates, so no change
		assertFalse(list.addAll(4, set2));
		
		// adds to the set with some duplicates
		assertTrue(list.addAll(2, set3));
		
		// adds to the end of the set explicitly
		assertTrue(list.addAll(list.size() - 1, set4));
	}
}
