import java.awt.List;
import java.util.ArrayList;

public class Median {
	public static void main(String args[]) {
		list = new ArrayList<Integer>();
		list.add(3);
		list.add(8);
		list.add(2);
		list.add(31);
		list.add(6);
		list.add(4);
		list.add(33);
		list.add(82);
		list.add(22);
		list.add(15);
		list.add(1);
		for ( int i = 0; i < list.size(); i++){
		System.out.print(list.get(i) + "\t");
		}
		System.out.println();
		System.out.println("Size of Array " +list.size() ); //8
		System.out.println("Last element of Array"+list.get(list.size() - 1));
		mid = (list.size() + 1)/2;
		System.out.println("Middle index of Array " +mid); //4
		middle = list.get(mid);
		System.out.println("Middle element of Array " +middle); //4
		int med = median(list,1,9);
		System.out.println("Median  of Array " +med);
	}	
	public static int median(ArrayList<Integer> input, int left, int right){
		
	int first = input.get(0);
	int last = input.get(list.size() - 1);
	//int middle = input.get(list.mid());
	
	if ( first < last && first >middle)
		return left;
	else if (middle > first && middle < last )
	
		return ((input.size() + 1) / 2);
	else 
		return right;
	}
	private static int mid;
	private static int middle;
	private static ArrayList<Integer> list ;
}


