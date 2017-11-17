package adt.dictionary.hash;

import java.util.Iterator;

public class DictionaryHashTable<K, V> implements DictionaryInterface<K, V>{

	private int numOfEntries; // Number of pairs of entries in the hashTable
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
		hashTableSize = getNextPrime(initialCapacity);
		@SuppressWarnings("unchecked")
		Node<K, V>[] temp = (Node<K, V>[])new Node[hashTableSize]; // A temp variable that type casts the Node array into an array of size hashTableSize
		hashTable = temp; // hashTable array is assigned to temp
	}
	
	/**
	 * Method will accept an integer and find it's next prime number
	 * @param nextPrime   A number that will become the next prime number
	 * @return temp	      Temporary variable to return the next prime number
	 */
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

	 /**
	  *  Method that will check to see if a current integer value is prime
	  * @param nextPrime   An integer value that will be passed into the method
	  * @return isPrime    A return type that will return false if the number is not prime, or true if the number is prime
	  */
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
		Node temporary;
		int hash; // will store the value of the hash
		int index; // will store the value of the hashTable index
		boolean flagged = true; // will mark an index as flagged
		
		if(key == null || value == null) {
			throw new IllegalArgumentException();
		}
		else {
			V oldValue;
		}
		
		if(hashTableSize == numOfEntries) {	// condition stating if hash table is too full, then rehash
			
			for(int i = 0; i < getNextPrime(hashTableSize) - 1; i++) {
				hash = hashTable[i].hashCode();
				index = hash % getNextPrime(hashTableSize);
				
				
			}
			
		}
		
		return null;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			
			
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public V getValue(K key) {
		// TODO Auto-generated method stub
		Node temp;
		
		getKeyIterator();
		return null;
	}

	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<K> getKeyIterator() {
		// TODO Auto-generated method stub
		Node temp;
		
		for(int i = 0; i < numOfEntries; i++) {
			getValue(hashTable[i].getKey());
		}
		return null;
	}

	@Override
	public Iterator<V> getValueIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	
}
