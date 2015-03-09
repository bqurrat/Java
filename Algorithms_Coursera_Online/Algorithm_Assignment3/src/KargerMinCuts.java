import java.io.BufferedReader;                                                                          
import java.io.FileReader;                                                                              
import java.io.IOException;                                                                             
import java.util.ArrayList;                                                                             
import java.util.HashMap;                                                                               
import java.util.Iterator;                                                                              
import java.util.Map;                                                                                   
import java.util.Random;                                                                                
import java.util.Scanner;                                                                               
import java.util.Set;                                                                                   
import java.util.Collections;                                                                           
                                                                                                        
                                                                                                        
import acm.util.RandomGenerator;                                                                        
                                                                                                        
public class KargerMinCuts {                                                                                                                                                                        
	public KargerMinCuts(String file_name) {
		// TODO Auto-generated constructor stub
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
				ArrayList<Integer> to_add = new ArrayList<Integer>();                                   
                                                                                                        
				Scanner in_line = new Scanner(line).useDelimiter("\\s+");                               
				key = in_line.nextInt();                                                                
                                                                                                        
				while (in_line.hasNext()) {                                                             
					to_add.add(in_line.nextInt());                                                      
				}                                                                                       
				graph.put(key, to_add);                                                                 
			}                                                                                           
			br.close();                                                                                 
                                                                                                        
			System.out.println("Graph is ready. Call getGraph() to obtain a copy");                     
		} catch (IOException e) {                                                                       
			e.printStackTrace();                                                                        
		}                                                                                               
	}                                                                                                   
                                                                                                        
	public HashMap<Integer, ArrayList<Integer>> getGraph() {                                            
		return graph;                                                                                   
	}                                                                                                   
                                                                                                        
	public void printGraph() {                                                                          
		Iterator it = graph.entrySet().iterator();                                                      
		while (it.hasNext()) {                                                                          
			Map.Entry pairs = (Map.Entry) it.next();                                                    
                                                                                                        
			System.out.print(pairs.getKey() + ":\t"); // + " = " +                                      
			printArrayList((ArrayList<Integer>) pairs.getValue());                                      
		}                                                                                               
	}                                                                                                   
                                                                                                        
	private void printArrayList(ArrayList<Integer> x) {                                                 
		for (int i = 0; i < x.size(); ++i) {                                                            
			System.out.print(x.get(i));                                                                 
			System.out.print("\t");                                                                     
		}                                                                                               
		System.out.println();                                                                           
	}                                                                                                   
                                                                                                        
	private int randomKey() {                                                                           
		ArrayList<Integer> keys = new ArrayList<Integer> (graph.keySet());                              
		int RandomkeyIndex = (int) (Math.random() * keys.size());                                       
		return keys.get(RandomkeyIndex);                                                                
	}                                                                                                   
                                                                                                        
	private int randomValue(int randomKey) {                                                            
		ArrayList<Integer> val = graph.get(randomKey);                                                  
		return val.get( (int) (Math.random() * val.size()) );                                           
	}                                                                                                   
                                                                                                        
	private void pickRemainingEdge() {                                                                  
		chosenKey = randomKey();                                                                        
		chosenValue = randomValue(chosenKey);                                                           
	}                                                                                                   
	                                                                                                    
	public int minCut() {                                                                               
		while (graph.size() > 2){                                                                       
			pickRemainingEdge();                                                                        
			replacerandomValueWithrandomKey();                                                          
			searchRandomValueInMapKey();                                                                
			appendArrayList();                                                                          
			removeOccurences();                                                                         
			graph.remove(chosenValue);                                                                  
			graph.put(chosenKey, arr1);                                                                 
		}                                                                                               
		                                                                                                
		for (ArrayList<Integer> ptr  : graph.values()) {                                                
			return ptr.size();                                                                          
		}                                                                                               
		return 1;                                                                                       
	}                                                                                                   
	                                                                                                    
	                                                                                                    
	public void replacerandomValueWithrandomKey() {                                                     
		for (ArrayList<Integer> ptr  : graph.values()) {                                                
			for ( int i = 0; i < ptr.size(); ++i ) {                                                    
				if ( ptr.get(i) == chosenValue ) {                                                      
					ptr.set(i, chosenKey);		                                                        
				}                                                                                       
			}                                                                                           
		}                                                                                               
		                                                                                                
		arr1 = graph.get(chosenKey);                                                                    
	}                                                                                                   
	                                                                                                    
	public void searchRandomValueInMapKey(){	                                                        
	    if ( graph.containsKey(chosenValue) ) {                                                         
		    arr2 = graph.get(chosenValue);                                                              
		} else {                                                                                        
	    	System.out.println("Test Statement");		                                                
	    }                                                                                               
	}                                                                                                   
	                                                                                                    
	public void appendArrayList(){	                                                                    
		arr1.addAll(arr2);	                                                                            
	}                                                                                                   
	                                                                                                    
	public void removeOccurences(){			                                                            
		while ( arr1.contains(chosenKey) ) {                                                            
			int index = arr1.indexOf(chosenKey);                                                        
			arr1.remove(index);                                                                         
		}                                                                                               
	}                                                                                                   
	                                                                                                    
                                                                                                        
	private HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();    
	private ArrayList<Integer> arr1 = new ArrayList<Integer>();                                         
	private ArrayList<Integer> arr2 = new ArrayList<Integer>();                                         
	private int chosenValue;                                                                            
	private int chosenKey;                                                                              
                                                                                                        
}                                                                                                       
                                                                                                        
