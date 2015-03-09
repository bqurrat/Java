import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class GraphReverse {
	public GraphReverse(String file_name) {
		readFromFile(file_name);
	}

	private void readFromFile(String file_name) {
		System.out.println("Creating graph from file ...");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file_name));
			String line;

			while ((line = br.readLine()) != null) {
				int key;
				int to_add;

				Scanner in_line = new Scanner(line).useDelimiter("\\s+");
				to_add = in_line.nextInt();
				key = in_line.nextInt();

				if (graph.containsKey(key)) {
					graph.get(key).add(to_add);
				} else {
					ArrayList<Integer> insert_arr = new ArrayList<Integer>();
					insert_arr.add(to_add);
					graph.put(key, insert_arr);
				}
			}
			br.close();

			System.out
					.println("Graph is ready. Call getGraph() to obtain a copy");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void printGraph() {
		Iterator it = graph.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			System.out.print(pairs.getKey() + ":\t"); // + " = " +
			System.out.print(pairs.getValue() + "\n");
		}
	}
	private HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();

}
