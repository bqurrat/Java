import java.awt.List;
import java.util.ArrayList;

public class QuickSortQuestionTwo {
	
	public void quick_sort(ArrayList<Integer> input, int left, int right){
		
		if ( (right - left) <= 0) return;
		else {
			int m = partition(input, left, right);
			System.out.println("The value of i :" +m);
			quick_sort(input, left, m - 1);
			quick_sort(input, m + 1, right);
		}
		System.out.println("Nmuber of comparison = " +comparison);	
	}

	public int partition(ArrayList<Integer> input, int left, int right){
		
		swap (input, right, left);
		int p = input.get(left);
		int i = left + 1;
		for (int j = left + 1; j <= right; j++){
			if (input.get(j) < p ){
				swap (input, j, i);
				++i;
			}
		}
		swap (input, left, (i-1));
		long comp = (right - left) ;
		comparison = comp + comparison;
		return i - 1;
	}
	
	
	public void swap(ArrayList<Integer> input, int i, int j){
		int temp = input.get(i);
		input.set (i, input.get(j));
		input.set(j, temp);	
	}
private long comparison = 0;
}
