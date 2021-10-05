package democoncurrentcollection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class PlayingWithLinkedBlockingQueue {

	public static void main(String[] args) throws InterruptedException {
		LinkedBlockingQueue<Integer> q = new LinkedBlockingQueue<>(2);
		System.out.println(q.add(11));
		System.out.println(q.add(22));
		//System.out.println(q.add(3)); exception
		System.out.println(q.offer(23));
		System.out.println(q.offer(45, 2, TimeUnit.SECONDS));
		//q.put(4); will not be able to put because there is no space left
		System.out.println("Here");
		System.out.println(q.take());
		System.out.println(q.take());
		System.out.println(q.take());
	}

}
