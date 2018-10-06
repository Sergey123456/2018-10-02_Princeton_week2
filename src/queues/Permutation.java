package queues;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

public class Permutation {
	public static void main(String[] args) {
		RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
		int			numberWords	= Integer.parseInt(args[0]);
//		String 		fileName 	= StdIn.readString();
//		String 		fileName 	= args[2];
//		In 			in 			= new In(fileName);
//		Character	text;
//		while (in.hasNextChar()) {
//			text = in.readChar();
//			if (!Character.isWhitespace(text))  {
//				System.out.print(text + " ");
//				randomizedQueue.enqueue(text.toString());
//			}
//		}
		while (!StdIn.isEmpty()) {
			randomizedQueue.enqueue(StdIn.readString());
        }
		for (int i = 0; i < numberWords; i++) {
			System.out.println(randomizedQueue.dequeue());
		}
	}
}
