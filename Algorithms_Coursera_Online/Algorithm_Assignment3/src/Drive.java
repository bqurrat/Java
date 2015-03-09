import java.util.ArrayList;
import java.util.HashMap;
public class Drive {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int min_val = 100000; 
		for ( int i = 0; i < 1000; ++i ) {
			int temp_val = 0;
			KargerMinCuts my_graph = new KargerMinCuts("kargerMinCut.txt");
			temp_val = my_graph.minCut();
			
			min_val = Math.min(temp_val, min_val);
		}
			
		System.out.println("min_cut: " + min_val);
	}
}


