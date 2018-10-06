package queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	private Node 	firstNode;
	private Node 	lastNode;
	private int 	size;
	
	// construct an empty deque
	public Deque() {
		firstNode 	= null;
		lastNode	= null;
		size		= 0;
	}
	// is the deque empty?
	public boolean isEmpty() {
		return firstNode == null;
	}
	// return the number of items on the deque
	public int size() {
		return size;
	}
	// add the item to the front
	public void addFirst(Item item) {
		validate(item);
		Node newNode = new Node(null, firstNode, item);
		if (size != 0) {
			newNode.prevNode	= firstNode;
			firstNode.nextNode 	= newNode;
			firstNode 			= newNode;
		}
		else
			firstNode = lastNode = newNode;
		size++;
	}
	// add the item to the end
	public void addLast(Item item) {
		validate(item);
		Node newNode = new Node(lastNode, null, item);
		if (size != 0) {
			newNode.nextNode	= lastNode;
			lastNode.prevNode 	= newNode;
			lastNode 			= newNode;
		}
		else
			firstNode = lastNode = newNode;
		size++;
	}
	// remove and return the item from the front
	public Item removeFirst() {
		if (size == 0)
			throw new NoSuchElementException();
		Item item = firstNode.item;
		if (size == 1) {
			size--;
			firstNode = lastNode = null;
			return item;
		}
		firstNode 			= firstNode.prevNode;
		firstNode.nextNode 	= null;
		size--;
		return item;
	}
	// remove and return the item from the end
	public Item removeLast() {
		if (size == 0)
			throw new NoSuchElementException();
		Item item = lastNode.item;
		if (size == 1) {
			size--;
			firstNode = lastNode = null;
			return item;
		}
		lastNode 			= lastNode.nextNode;
		lastNode.prevNode 	= null;
		size--;
		return item;
	}
	// return an iterator over items in order from front to end
	public Iterator<Item> iterator() {
		return new Iterator<Item>() {
			Node curNode = firstNode;
			@Override
			public boolean hasNext() {
				return curNode != null;
			}

			@Override
			public Item next() {
				if (curNode == null) {
					throw new NoSuchElementException();
				}
				Item item = curNode.item;
				curNode = curNode.prevNode;
				return item;
			}
			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
	private void validate(Item item) {
		if (item == null) throw new IllegalArgumentException();
	}
	
	private class Node {
		Node nextNode;
		Node prevNode;
		Item item;
		
		public Node(Node nextNode, Node prevNode, Item item) {
			this.nextNode 	= nextNode;
			this.prevNode 	= prevNode;
			this.item 		= item;
		}
	}
	// unit testing (optional)
	public static void main(String[] args) {
		Deque<Integer> deque = new Deque<>();
		deque.addFirst(3);
		deque.addFirst(2);
		deque.addFirst(1);
		deque.addLast(4);
		deque.addLast(5);
		deque.addLast(6);
		
		deque.removeFirst();
		deque.removeLast();
		deque.removeLast();
		deque.removeLast();
		deque.removeLast();
		
		System.out.println(deque.size);
		for (Integer integer : deque) {
			System.out.print(integer + " ");
		}
		System.out.println(deque.size);
		System.out.println("");
		
	}
}
