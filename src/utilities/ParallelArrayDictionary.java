/**
 * This class implements a dictionary with parallel arrays. The parallel-
 * ness ensures the indices of keys and their corresponding values are equal.
 * 
 * Authors: Jack Roberts, Eleanor Badgett
 * Date: 1/19/23
 */

package utilities;

import java.util.*;

public class ParallelArrayDictionary<Key, Value> implements Map<Key, Value>
{
    protected ArraySet<Key>    _keys;
    protected ArrayList<Value> _values;
	
	public ParallelArrayDictionary()
	{
		_keys = new ArraySet<Key>();
		_values = new ArrayList<Value>();
	}

	@Override
	public int size() {
		return _keys.size();
	}

	@Override
	public boolean isEmpty() {
		return _keys.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return _keys.contains(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return _values.contains(value);
	}

	@Override
	public Value get(Object key) {
		return _values.get(_keys.indexOf(key));
	}

	@Override
	public Value put(Key key, Value value) {				
		if(!_keys.contains(key)) {
			_keys.add(key);
			_values.add(value);
			return null;
		}
		
		Value oldValue = get(key);
		_values.set(_keys.indexOf(key), value);
		
		return oldValue;
	}

	@Override
	public Value remove(Object key) {
		if (!_keys.contains(key)) {
			return null;
		}
		
		Value value = _values.remove(_keys.indexOf(key));
		_keys.remove(_keys.indexOf(key));
		
		return value;
	}

	@Override
	public void putAll(Map<? extends Key, ? extends Value> m) {
		for (Key key : m.keySet()) {
			put(key, m.get(key));
		}
	}

	@Override
	public void clear() {
		_keys.clear();
		_values.clear();
	}

	@Override
	public Set<Key> keySet() {
		return _keys;
	}

	@Override
	public Collection<Value> values() {
		return _values;
	}

	@Override
	public Set<Entry<Key, Value>> entrySet() {
		Map<Key, Value> m = new HashMap<>();
		
		for (Key key : _keys) {
			m.put(key, get(key));
		}
		
		return m.entrySet();
	}
}