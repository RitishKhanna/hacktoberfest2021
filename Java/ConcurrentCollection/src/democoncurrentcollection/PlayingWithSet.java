package democoncurrentcollection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class PlayingWithSet {
	
	public static void main(String[] args) {
		Set<String> cities= new CopyOnWriteArraySet<>();
		cities.add("Batala");
		cities.add("Mumbai");
		cities.add("Gurdaspur");
		cities.add("Amritsar");
		cities.add("Pune");
//		for(String citi:cities) {
//			if(citi.equals("Mumbai")) {
//				cities.remove(citi);
//			}
//		}
		
		
		
		long start = System.currentTimeMillis();
		for(int i=1; i<=10000; i++) {
			cities.add(""+i);
		}
		long end = System.currentTimeMillis();
		System.out.println("Time Taken: " + (end-start));
		
		
		
		
//		Thread t1 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				
//				for(String citi:cities) {
//					System.out.println(citi);
//					try {
//						Thread.sleep(2000);
//					}
//					catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		});
//		
//		Thread t2 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				cities.add("hello");
//				try {
//					Thread.sleep(1000);
//				}
//				catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				cities.add("hii");
//			}
//		});
//		
//		t1.start();
//		t2.start();
		
//		Iterator value = cities.iterator();
//	      while (value.hasNext()) {
//	         if (value.next().equals("Mumbai")) {
//	            value.remove();
//	         }
//	      }
//		System.out.println(cities);
		
	}

}
