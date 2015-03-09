import java.awt.List;
import java.util.ArrayList;

import acm.graphics.GObject;

public class MergeSort {
	

	public ArrayList<Integer> merge_sort(ArrayList<Integer> input, int len) {
		
		if ( input.size() == 1 ) return input;
		else {
			ArrayList<Integer> first_half = copy_for_merge_sort(input, 0, input.size() / 2); 
			ArrayList<Integer> second_half = copy_for_merge_sort(input, input.size() / 2, input.size()); 
		
			
			ArrayList<Integer> B = merge_sort(first_half, len);
			ArrayList<Integer> C = merge_sort(second_half, len);
			
			ArrayList<Integer> D = merge(B, C);
			
			if ( len == input.size() )
				System.out.print("Nmuber of split Inversons = " +count_split_inversion );
			System.out.print( "\n");
			
			return D;
			
		}				
	}
	
	private ArrayList<Integer> copy_for_merge_sort(ArrayList<Integer> input, int s, int e) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for ( int i = s; i < e; ++i ) {
			result.add( input.get(i) );
		}
		
		return result;
	}
	private ArrayList<Integer> merge(ArrayList<Integer> B, ArrayList<Integer> C) {
		//System.out.println("B_size: " + B.size() );
		//System.out.println("C_size: " + C.size() );
		
		
		int s = B.size() + C.size();
		ArrayList<Integer> D = new ArrayList<Integer>(s);
		//System.out.println("created_size: " + D.size() );
		int i = 0; // pointer in B 
		int j = 0; // pointer in C
		
		for ( int k = 0; k < s; ++k ) {
			if ( i < B.size() && j < C.size() ) {
				if ( B.get(i) <= C.get(j) ) {
					D.add(B.get(i));
					++i;
				} else {
					
					
					D.add(C.get(j));
					++j;
					//System.out.println("Size:" +B.size());
					//System.out.println("Value of j:" +j);
					
					int split_inversion = B.size() - i ;
					count_split_inversion = split_inversion + count_split_inversion ;
					//System.out.println("First Loop:" +count_split_inversion);
				}
			} else if ( i < B.size() ) {
				
				D.add(B.get(i));
				++i;
			} else {
				D.add(C.get(j));
				++j;
				int split_inversion = B.size() - i ;
				count_split_inversion = split_inversion + count_split_inversion ;
				//System.out.println("Second Loop:" +count_split_inversion);
			
			}
			
		}
		
		return D;
	}
	

	public void PrintArray( ArrayList<Integer> x) {
		for ( int i = 0; i < x.size(); ++i ) {
			System.out.print(x.get(i) + "\t");
		}
		System.out.println();
	}
	//private int split_inversion = 0;
	private long count_split_inversion = 0;
}
