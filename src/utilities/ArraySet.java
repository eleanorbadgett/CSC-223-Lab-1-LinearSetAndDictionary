package utilities;

import java.util.*;

public class ArraySet<E> implements List<E>, Set<E>
{
	protected ArrayList<E> _list;

	public ArraySet()
	{
		_list = new ArrayList<E>();
	}

	@Override
	public boolean add(E e) {
		if (!_list.contains(e) ) {
			_list.add(e);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		boolean changed = false;
		
		for (E e : c) {
			if (!_list.contains(e) ) {
				_list.add(e);
				changed = true;
			}
		}
		
		return changed;
	}

	@Override
	public int size() {
		return _list.size();
	}

	@Override
	public boolean isEmpty() {
		return _list.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return _list.contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		return _list.iterator();
	}

	@Override
	public Object[] toArray() {
		return _list.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return _list.toArray(a);
	}

	@Override
	public boolean remove(Object o) {
		return _list.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return _list.containsAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		boolean changed = false;
		int n = 0;
		
		// using n to maintain the order from c to _list
		for (E e : c) {
			if (!_list.contains(e) ) {
				_list.add(index + n, e);
				changed = true;
				n++;
			}
		}
		
		return changed;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return _list.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return _list.retainAll(c);
	}

	@Override
	public void clear() {
		_list.clear();
	}

	@Override
	public E get(int index) {
		return _list.get(index);
	}

	@Override
	public E set(int index, E element) {
		E out = _list.get(index);
		
		if (!_list.contains(element)) {
			_list.set(index, element);
		}
		
		return out;
	}

	@Override
	public void add(int index, E element) {
		if (!_list.contains(element) ) {
			_list.add(element);
		}
	}

	@Override
	public E remove(int index) {
		return _list.remove(index);
	}

	@Override
	public int indexOf(Object o) {
		return _list.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return indexOf(o);
	}

	@Override
	public ListIterator<E> listIterator() {
		return _list.listIterator();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return _list.listIterator(index);
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return _list.subList(fromIndex, toIndex);
	}

	@Override
	public Spliterator<E> spliterator() {
		return _list.spliterator();
	}
}
