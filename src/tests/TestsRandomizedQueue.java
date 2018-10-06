package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.princeton.cs.algs4.StdRandom;
import queues.RandomizedQueue;

class TestsRandomizedQueue {
	RandomizedQueue<Integer> original_rq_3_elements;
	RandomizedQueue<Integer> original_rq_0_elements;
	
	@BeforeEach
	void setUp() {
		original_rq_3_elements = new RandomizedQueue<>();
		original_rq_0_elements = new RandomizedQueue<>();
		original_rq_3_elements.enqueue(1);
		original_rq_3_elements.enqueue(2);
		original_rq_3_elements.enqueue(3);
	}

	@Test
	void dequeueTest() {
		try {
			original_rq_0_elements.dequeue();
		} catch (Exception e) {
			assertEquals(e.getClass(), NoSuchElementException.class);
		}
		assertEquals(0, original_rq_0_elements.size()); 
		original_rq_0_elements.enqueue(1);
		assertEquals(1, original_rq_0_elements.size()); 
		original_rq_0_elements.enqueue(2);
		assertEquals(2, original_rq_0_elements.size());
		original_rq_0_elements.dequeue();
		original_rq_0_elements.dequeue();
		assertEquals(0, original_rq_0_elements.size());
		try {
			original_rq_0_elements.dequeue();
		} catch (Exception e) {
			assertEquals(e.getClass(), NoSuchElementException.class);
		}
		
		for (int i = 0; i < 10000; i++) {
			original_rq_3_elements.enqueue(i);
		}
		
		for (int i = 0; i < 10000; i++) {
			original_rq_3_elements.dequeue();
		}
		
		for (int i = 0; i < 10000; i++) {
			System.out.println(i);
			if (StdRandom.uniform(3) == 0)  
				original_rq_3_elements.enqueue(i);
			else 
				try {
					original_rq_3_elements.dequeue();
				} catch (NoSuchElementException e) {
					
				}
		}
	}
}
