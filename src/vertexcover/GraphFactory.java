package vertexcover;

import java.util.ArrayList;
import java.util.Random;

public class GraphFactory {
	
	public static Graph buildRandomGraph(int nodes, int edges){
		
		Graph newGraph = new Graph();
		ArrayList<Node> nodeList = new ArrayList<Node>();
		
		for(int i = 0; i < nodes; i++){
			Node n = new Node(i);
			nodeList.add(n);
		}
		
		while(edges != 0){
			Node u = nodeList.get(randInt(0,nodes-1));
			Node v = nodeList.get(randInt(0,nodes-1));
			
			if(u.equals(v)){
				continue;
			}
			
			Edge e = new Edge(u,v);
			u.addEdge(e);
			v.addEdge(e);
			newGraph.addNode(v);
			newGraph.addNode(u);
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

}
