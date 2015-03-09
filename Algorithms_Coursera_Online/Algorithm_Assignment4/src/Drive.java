import java.util.ArrayList;
import java.util.HashMap;


public class Drive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			SCCByKosaraju my_graph = new SCCByKosaraju("SCC.txt");
			my_graph.kosaRaju();
			//System.out.println("-----------------------------------------");
			 
			/*GraphReverse my_graph = new GraphReverse("SCCByKosaraju.txt");
		my_graph.printGraph();	
		}*/
	}
}