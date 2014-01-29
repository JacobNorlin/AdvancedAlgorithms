package vertexcover;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GraphFactory {
	
	public static Graph buildRandomGraph(int nodes, int edges){
		
		Graph newGraph = new Graph();
		ArrayList<Node> nodeList = new ArrayList<Node>();
		
		for(int i = 0; i < nodes; i++){
			Node n = new Node(i);
			newGraph.addNode(n);
		}
		
		while(edges != 0){
			Node u = newGraph.getNodes().get(randInt(0,nodes-1));
			Node v = newGraph.getNodes().get(randInt(0,nodes-1));
			
			if(u.equals(v)){
				continue;
			}
			
			Edge e = new Edge(u,v);
			newGraph.addEdge(e);
			edges--;
			
			
		}
		
		return newGraph;
	}
	
	
	public static int randInt(int min, int max) {

	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public static Graph buildGraphFromFile(String path) throws IOException{
		 BufferedReader br = new BufferedReader(new FileReader(path));
		 Graph newGraph = new Graph();
		    try {
		        String[] firstLine = br.readLine().split(" ");
//		        newGraph.setMinCover(Integer.parseInt(firstLine[2]));
		        int edges = Integer.parseInt(firstLine[3]);
		        int nodes = Integer.parseInt(firstLine[2]);
		        for(int i = 1; i <= nodes; i++){
		        	Node n = new Node(i);
		        	newGraph.addNode(n);
		        }
		        
		        String[] line;
		        for(int i = 0; i<edges; i++){
		        	line = br.readLine().split(" ");
		        	Node u = new Node(Integer.parseInt(line[1]));
		        	Node v = new Node(Integer.parseInt(line[2]));
		            Edge newEdge = new Edge(u, v);
		            newGraph.addEdge(newEdge);
		        }
		    } finally {
		        br.close();
		    }
		    return newGraph;
	}

}
