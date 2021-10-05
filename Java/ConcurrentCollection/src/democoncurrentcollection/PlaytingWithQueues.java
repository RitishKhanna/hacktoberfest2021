package democoncurrentcollection;

import java.util.PriorityQueue;
import java.util.Queue;

public class PlaytingWithQueues {
	
	public static void main(String[] args) {
		Queue<String> q = new PriorityQueue<>();
		System.out.println(q.offer("S"));
		System.out.println(q.offer("P"));
		System.out.println(q.offer("E"));
		System.out.println(q.offer("T"));
		System.out.println(q.peek());
		System.out.println(q);
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q);
		
	}

}
