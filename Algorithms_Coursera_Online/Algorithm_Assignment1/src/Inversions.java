import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Inversions {
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
		MergeSort m = new MergeSort();
		ArrayList<Integer> result = m.merge_sort(list, list.size());
		
		for (int j = 0; j < result.size(); ++j) {
			//System.out.print(result.get(j) + "\n");
		}
		//System.out.print(list.size());
	}
}
