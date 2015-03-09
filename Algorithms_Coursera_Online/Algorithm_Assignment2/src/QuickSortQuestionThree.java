import java.util.ArrayList;
import java.util.SortedMap;
public class QuickSortQuestionThree {



		
		public void quick_sort(ArrayList<Integer> input, int left, int right){
			
			if ( (right - left) <= 0) return;
			else {
				int m = partition(input, left, right);
				quick_sort(input, left, m - 1);
				quick_sort(input, m + 1, right);
			}
			System.out.println("Nmuber of comparison = " +comparison);	
		}

		public int partition(ArrayList<Integer> input, int left, int right){
			int pivot = medianpivot(input,left,right);
			//System.out.println("Median Element: " +pivot);
			swap (input,pivot,left);
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
		
		public int medianpivot(ArrayList<Integer> input, int left, int right) {
			int mid = left + ((right - left) / 2);
			//System.out.println("Middle Index: " +mid );
			int first = input.get(left);
			int middle = input.get(mid);
			int last = input.get(right);
			
			System.out.println("Middle Element: " +middle ); //50th - 55 
			
			if ( first < middle && first < last ) {
				if ( middle < last) return mid;
				else return right;
			}
			
			if ( middle < first && middle < last ) {
				if ( first < last ) return left;
				else return right;
			}
			
			if ( last < first && last < middle ) {
				if ( first < middle) return left;
				else return mid;
			}

			return mid;
		}
		
		
		
		public void swap(ArrayList<Integer> input, int i, int j){
			int temp = input.get(i);
			input.set (i, input.get(j));
			input.set(j, temp);	
		}
	private long comparison = 0;

	
}
