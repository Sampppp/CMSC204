import java.util.Queue;
import java.util.LinkedList;
public class CarQueue {
	
	private Queue<Integer> queue = new LinkedList<>();
	
	public CarQueue() {
		queue.add(1);
		queue.add(1);
		queue.add(1);
		queue.add(1);
		queue.add(1);
		queue.add(1);		
	}
	
	public void addToQueue() {
		class CarQueueRunnable implements Runnable{
			@Override
			public void run() {
				try {
					/** Adds 0,1,2 or 3 to queue
				     *  0 = up
				     *  1 = down
				     *  2 = right
				     *  3 = left
				     */

					queue.add(0);
					queue.add(1);
					queue.add(2);
					queue.add(3);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					return;
				}
			}
		}
			
		Runnable r = new CarQueueRunnable();
		Thread t = new Thread(r);
	    t.start();
	}
	
	public int deleteQueue() {
		return queue.remove();
	}
	
}
