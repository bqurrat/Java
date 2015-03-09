import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Test {
	public static void main(String args[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();
	
		try {
			Scanner s = new Scanner(new File("IntegerArray.txt"));
			while (s.hasNext()) {
				if (s.hasNextInt()) {
					list.add(s.nextInt());
				}
			}
			s.close();
		} catch (IOException ex) {
		System.out.println("File Not Found");
		}
//		list.add(3);
//		list.add(8);
//		list.add(2);
//		list.add(5);
//		list.add(1);
//		list.add(4);
//		list.add(7);
//		list.add(6);
//		
		
		
		
		QuickSortQuestionOne q = new QuickSortQuestionOne();
		//QuickSortQuestionTwo q = new QuickSortQuestionTwo();
		//QuickSortQuestionThree q = new QuickSortQuestionThree();
		if ( !list.isEmpty() ) {
			q.quick_sort(list, 0, list.size() - 1);	
		} else {
			System.out.print("nothing to sort!");
		}
		
		for ( int i = 0; i < list.size(); i++){
			System.out.print(list.get(i) + "\t");
		}
		System.out.println();
	}
}

