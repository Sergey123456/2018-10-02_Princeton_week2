package queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Node 	firstNode;
	private Node 	lastNode;
	private int 	size;
	
	// construct an empty randomized queue
	public RandomizedQueue() {
		firstNode 	= null;
		lastNode 	= null;
		size 		= 0;
	}
	// is the randomized queue empty?
	public boolean isEmpty() {
		return size == 0;
	}
	// return the number of items on the randomized queue
	public int size() {
		return size;
	}
	// add the item
	public void enqueue(Item item) {
		if (item == null)
			throw new IllegalArgumentException();
		Node newNode = new Node(null, item);
		if (size != 0) {
			lastNode.prevNode 	= newNode;
			lastNode			= newNode;
		} else {
			firstNode = lastNode = newNode;
		}
		size++;
	}
	// remove and return a random item
	public Item dequeue() {
		if (size ==  0)
			throw new NoSuchElementException();
		Node curNode = firstNode;
		if (size == 1) {
			firstNode = lastNode = null;
			size = 0;
			return curNode.item;
		}
		int randIndex = StdRandom.uniform(size);
		Node nextNode 	= null;
		for (int i = 0; i < randIndex; i++) {
			nextNode 	= curNode;
			curNode 	= curNode.prevNode;
		}
		if (nextNode == null) { 				// first element
			firstNode = curNode.prevNode;
		} else if (curNode.prevNode == null) { 	// last element
			nextNode.prevNode 	= null;
			lastNode 			= nextNode;
		} else {								// middle element
			nextNode.prevNode = curNode.prevNode;
		}
		size--;
		return curNode.item;
	}
	// return a random item (but do not remove it)
	public Item sample() {
		if (size ==  0)
			throw new NoSuchElementException();
		return this.iterator().next();
	}
	// return an independent iterator over items in random order
	public Iterator<Item> iterator() {
		Iterator<Item> itr = new Itr();
		return itr;
	}
	private class Itr implements Iterator<Item> {
		Object[] 	items;
		int			index;
		public Itr() {
			items 			= new Object[size];
			Node curNode 	= firstNode;
			for (int i = 0; i < size; i++) {
				items[i] 	= curNode.item;
				curNode 	= curNode.prevNode;
			}
			StdRandom.shuffle(items);
			index = 0;
		}
		@Override
		public boolean hasNext() {
			return index < size;
		}
		@Override
		public Item next() {
			if (index >= size) {
				throw new NoSuchElementException();
			}
			return (Item)items[index++];
		}
		@Override
		public void remove() {
			throw new UnsupportedOperationException("remove");
		}
	}
		
	private class Node {
		Node prevNode;
		Item item;
		
		public Node(Node prevNode, Item item) {
			this.prevNode = prevNode;
			this.item = item;
		}
	}
	// unit testing (optional)
	public static void main(String[] args) {
		RandomizedQueue<Integer> queue = new RandomizedQueue<>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		
		for (int i = 0; i < 4; i++) {
			Iterator<Integer> itr = queue.iterator();
			while (itr.hasNext()) {
				System.out.println(itr.next());
			}
			System.out.println("delete:" + queue.dequeue());	
			System.out.println("size: " + queue.size);
		}
		
	}
}
