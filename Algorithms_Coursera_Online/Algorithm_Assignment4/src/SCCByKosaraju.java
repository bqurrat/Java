import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class SCCByKosaraju {
	private static final int N = 875715;

	public SCCByKosaraju(String file_name) {
		myFile_name = file_name;
		readFromFileGraphRev(myFile_name);
		//readFromFile(file_name);
	}
	

	private void readFromFileGraphRev(String file_name) {
	        System.out.println("Creating Reversegraph from file ...");
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

					if (graphRev.containsKey(key)) {
						graphRev.get(key).add(to_add);
					} else {
						ArrayList<Integer> insert_arr = new ArrayList<Integer>();
						insert_arr.add(to_add);
						graphRev.put(key, insert_arr);
					}
				}
				br.close();

				System.out
						.println("ReverseGraph is ready");
			} catch (IOException e) {
				e.printStackTrace();
			}
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
				//key = in_line.nextInt();
				key = finishingTime.get(in_line.nextInt());
				to_add = finishingTime.get(in_line.nextInt());

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
					.println("Original Graph is ready");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void printGraph(HashMap<Integer, ArrayList<Integer>> G) {
		HashMap<Integer, ArrayList<Integer>> graphToPrint = G;
		Iterator it = graphToPrint.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			System.out.print(pairs.getKey() + ":\t"); // + " = " +
			System.out.print(pairs.getValue() + "\n");
		}
	}

	public void DFS(HashMap<Integer, ArrayList<Integer>> G) {
		for (int i = 9; i > 0; --i) {
			sourceVertex = i;
			DFSR(G, i);	
		}
	}

	private void DFSR(HashMap<Integer, ArrayList<Integer>> G, int vertex) {
		HashMap<Integer, ArrayList<Integer>> graphForDFSR = G;
		if (visitTrack.get(vertex) == 0) {
			visitTrack.set(vertex, 1);
			leader.set(vertex,sourceVertex);
			System.out.println ("vertex : " + vertex + " sourceVetrex: " +sourceVertex);
			
			if (graphForDFSR.containsKey(vertex)) {
				ArrayList<Integer> edge_vertices = graphForDFSR.get(vertex);
				for (int j = 0; j < edge_vertices.size(); ++j) {
					DFSR(graphForDFSR, edge_vertices.get(j));
				}
				++time;
				finishingTime.put(vertex, time);
				//System.out.println("Finishing node is " + vertex + " time is "+ time);
			} else {
				++time;
				finishingTime.put(vertex, time);
				//System.out.println("Finishing node is " + vertex + " time is "+ time);
				}
		} 
	}


	public void printList() {
		for (int i = 0; i < leader.size(); ++i) {
			System.out.println("vertex: " + i + "\t leader: "+ leader.get(i));
			}
	}
	public void calculate(){
		
		Collections.sort(leader);
		ArrayList<Integer> result =  new ArrayList<Integer>();
		
		int ctr = 1;
		for ( int j = 1; j < leader.size(); ++j ) {
			if ( leader.get(j) != leader.get(j - 1) ) {
				result.add(ctr);
				ctr = 1;
			} else {
				++ctr;
			}
		}
		result.add(ctr);
		
		Collections.sort(result);
		for ( int k = result.size() - 1; k > result.size() - 6; --k) {
			System.out.println("val: "+ result.get(k));
		}
		
		
		
	}
	
	public void kosaRaju(){
		//printGraph(graphRev);
		DFS(graphRev);
		readFromFile(myFile_name);
		//printGraph(graph);
		System.out.println("----------------");
		System.out.println("----------------");
		System.out.println("----------------");
		System.out.println("----------------");
		for ( int i = 0; i < visitTrack.size(); ++i ) {
			visitTrack.set(i, 0);
		}
		DFS(graph);
		printList();
		calculate();
	}

	private HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
	private HashMap<Integer, ArrayList<Integer>> graphRev = new HashMap<Integer, ArrayList<Integer>>();
	private HashMap<Integer,Integer> finishingTime = new HashMap<Integer, Integer>();
	private HashMap<Integer,Integer> leaderCount = new HashMap<Integer, Integer>();
	private ArrayList<Integer> visitTrack = new ArrayList<Integer>(Collections.nCopies(N, 0));
	private ArrayList<Integer> leader =  new ArrayList<Integer>(Collections.nCopies(N, 0));
	
	
	private int time = 0;
	private int sourceVertex;
	private String myFile_name;

}
