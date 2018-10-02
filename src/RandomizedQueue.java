import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Node 	firstNode;
	private Node 	lastNode;
	private int 	size;
	
	// construct an empty randomized queue
	public RandomizedQueue() {
		size = 0;
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
		Node newNode = new Node(null, null, item);
		if (size == 0) {
			firstNode = lastNode = newNode;
		}
		size++;
	}
	// remove and return a random item
	public Item dequeue() {
		if (size ==  0)
			throw new NoSuchElementException();
		return null;
	}
	// return a random item (but do not remove it)
	public Item sample() {
		if (size ==  0)
			throw new NoSuchElementException();
		return null;
	}
	// return an independent iterator over items in random order
	public Iterator<Item> iterator() {
		return new Iterator<Item>() {
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}
			@Override
			public Item next() {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public void remove() {
				throw new UnsupportedOperationException("remove");
			}
		};
	}
	private class Node {
		Node nextNode;
		Node prevNode;
		Item item;
		
		public Node(Node nextNode, Node prevNode, Item item) {
			this.nextNode = nextNode;
			this.prevNode = prevNode;
			this.item = item;
		}
	}
	// unit testing (optional)
	public static void main(String[] args) {
		
	}
}
