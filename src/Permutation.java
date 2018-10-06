import java.io.File;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

public class Permutation {
	public static void main(String[] args) {
		RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
		int			numberWords	= Integer.parseInt(args[0]);
		String 		fileName 	= StdIn.readString();
		File 		file 		= new File(fileName);
		In 			in 			= new In(file);
		Character	text;
		System.out.println("Read:");
		while (in.hasNextChar()) {
			text = in.readChar();
			if (!Character.isWhitespace(text))  {
				System.out.print(text + " ");
				randomizedQueue.enqueue(text.toString());
			}
		}
		System.out.println("");
		System.out.println("Input:");
		for (int i = 0; i < numberWords; i++) {
			System.out.print(randomizedQueue.dequeue() + " ");
		}
	}
}
