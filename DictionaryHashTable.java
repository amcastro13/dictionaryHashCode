package adt.dictionary.hash;

import java.util.Iterator;

public class DictionaryHashTable<K, V> implements DictionaryInterface<K, V>{

	private int numOfEntries; // Number of entries in the hashTable
	private Node<K,V>[] hashTable; // creates the hashTable array
	private int hashTableSize; // The size of the hashTable
	private final static int DEFAULT_CAPACITY = 5;
	private int nextPrimeNum; // value of the next prime number
	private Node node;
	
	private class Node<K, V>{
		
		private K key;
		private V value;
		private boolean flag;
		/**
		 * @return the key
		 */
		public K getKey() {
			return key;
		}

		/**
		 * @return the value
		 */
		public V getValue() {
			return value;
		}

		/**
		 * @return the flag
		 */
		public boolean getFlag() {
			return flag;
		}

		/**
		 * @param key the key to set
		 */
		public void setKey(K key) {
			this.key = key;
		}

		/**
		 * @param value the value to set
		 */
		public void setValue(V value) {
			this.value = value;
		}

		/**
		 * @param flag the flag to set
		 */
		public void setFlag(boolean flag) {
			this.flag = flag;
		}

		
		public Node(K newKey, V newValue, boolean newFlag) {
			
			newKey = getKey();
			newValue = getValue();
			newFlag = getFlag();
		}
		
		
		
	}
	
	public DictionaryHashTable() {
		this(DEFAULT_CAPACITY);
		
	}
	
	public DictionaryHashTable(int initialCapacity) {
		//Node tableNode = new Node(key, value, flag);
		//tableNode
		hashTableSize = getNextPrime(nextPrimeNum);
		@SuppressWarnings("unchecked")
		Node<K, V>[] temp = (Node<K, V>[])new Node[hashTableSize]; // A temp variable that type casts the Node array into an array of size hashTableSize
		hashTable = temp; // hashTable array is assigned to temp
	}
	
	
	 private int getNextPrime(int nextPrime) {
		// TODO Auto-generated method stub
		 boolean isPrime = false;
		 int i = 2;
		 int temp = nextPrime; // temporary variable will store the old hashTable size
		 if(nextPrime % i == 0) {
		 while(!isPrime) {
			 
		 if(nextPrime % i == 0) {
			 i++;
		 }
		 
		 if(nextPrime % i != 0) {
			 temp = nextPrime + i;
			 isPrime = true;
		 }
		 }
		 }
		 
		return temp;
	}

	 private boolean isPrime(int nextPrime) {
		 boolean isPrime = false;
		 int i = 2;
		 if(nextPrime % i != 0) {
			 isPrime = true;
		 }
		return isPrime;
		 
	 }
	/** Adds a new entry to this dictionary. If the given search key already
    exists in the dictionary, replaces the corresponding value.
    @param key    An object search key of the new entry.
    @param value  An object associated with the search key.
    @return  Either null if the new entry was added to the dictionary
             or the value that was associated with key if that value
             was replaced. */
	@SuppressWarnings("unchecked")
	@Override
	public V add(K key, V value) {
		// TODO Auto-generated method stub
		boolean flagged = true;
		getKeyIterator();
		
		for(int i = 0; i < numOfEntries - 1; i++) {
			
			getValue()
		}
		
		if(isEmpty() && !flagged) {
			hashTable[getNextPrime(nextPrimeNum)] = new Node(key, value, flagged);	
			numOfEntries++;
			
			}
		
		return null;
		
	}private int getHashIndex(K key){
	int hashIndex = key.hashCode() % hashTable.length;
	if (hashIndex < 0)
	hashIndex = hashIndex + hashTable.length;
	return hashIndex;
	} 
	
	
	@Override
	//removes item from the hash table
	public V remove(K key) {
		V removedvalue = null;
		int index = getHashIndex(key);
		if(index != -1) {
			removedvalue = hashTable[index].getValue();
		hashTable[index] = null;
		numOfEntries--;
		}
		else {
		System.out.print("the array is empty");
		return null;
		}
		return removedvalue;
	}

	@SuppressWarnings("unchecked")
	@Override
	public V getValue(K key) {
		Iterator<K> itK=getKeyIterator();
		Iterator<V> itV=getValueIterator();
		int place=1;
		V value=null;
		if(itK.hasNext()) {
			while(itK.next()!=key)
				place++;
			for(int i = 0; i < place; i++) 
				value=itV.next();
		}
		return value;
	}

	@Override
	public boolean contains(K key) {
		boolean checker=false;
		Iterator<K> it=getKeyIterator();
		while(it.hasNext())
			if(it.next()==key)
				checker=true;
		return checker;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<K> getKeyIterator() {
		// TODO Auto-generated method stub
		ArrayList<K> list=new ArrayList<K>(numOfEntries);
		for(int i = 0; i < hashTableSize; i++) {
			if(hashTable[i].getKey()!=null){
				list.add(hashTable[i].getKey());
			}
		}
		Iterator<K> it=list.iterator();
		return it;
	}

	@Override
	public Iterator<V> getValueIterator() {
		ArrayList<V> list=new ArrayList<V>(numOfEntries);
		for(int i = 0; i < hashTableSize; i++) {
			if(hashTable[i].getValue()!=null){
				list.add(hashTable[i].getValue());
			}
		}
		Iterator<V> it=list.iterator();
		return it;
	}

	@Override
	public boolean isEmpty() {
		if(getSize()==0) {
			return true;
		}
		else
			return false;
	}

	@Override
	public int getSize() {
		int size=0;
		for(int i = 0; i < hashTableSize; i++) {
			if(hashTable[i].getKey()!=null){
				size++;
			}
		}
		return size;
	}

	@Override
	public void clear() {
		for(int i = 0; i < hashTableSize; i++) {
			hashTable[i]=null;
		}
	}

	
}
