package self.learning.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class Serachtask extends RecursiveTask<Integer>{
	
	
	private static final long serialVersionUID = 1L;
	
	private int [] arr;
	private int start, end;
	private int searchElement;
	
	

	public Serachtask(int[] arr, int start, int end, int searchElement) {
		super();
		this.arr = arr;
		this.start = start;
		this.end = end;
		this.searchElement = searchElement;
	}



	@Override
	protected Integer compute() {
		// TODO Auto-generated method stub
		int size = end - start +1;
		if (size >3) {
			
			int mid = (start+end)/2;
			Serachtask task1 = new Serachtask(arr, start, mid, searchElement);
			Serachtask task2 = new Serachtask(arr, mid+1, end, searchElement);
			task1.fork();
		    task2.fork();
		    int result = task1.join() + task2.join();
		    return result;
		    
		} else {
			return processsearch();
		}
		
	}



	private Integer processsearch() {
		// TODO Auto-generated method stub
		int result=0;;
		for (int i = start; i <= end; i++) {
			if (arr[i] == searchElement) {
				result++;
			}
		}
		return result;
	}
	
}

public class ForkJoinDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {6, 2, 6, 4, 5, 6, 7, 8, 6, 10, 11, 6};
		int searchEle = 6;
		int start = 0;
		int end = arr.length - 1;
		
		ForkJoinPool pool = ForkJoinPool.commonPool();
		Serachtask task = new Serachtask(arr, start, end, searchEle);
		int result = pool.invoke(task);
		
		System.out.printf("%d found %d times", searchEle, result);

	}

}
