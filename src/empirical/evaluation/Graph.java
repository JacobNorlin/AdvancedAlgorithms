package empirical.evaluation;

import java.util.ArrayList;

public class Graph {
	
	private ArrayList<Node> nodes;
	private ArrayList<Edge> edges;
	
	public Graph(){
		nodes = new ArrayList<Node>();
		edges = new ArrayList<Edge>();
	}
	
	
	public ArrayList<Edge> getEdges() {
		return edges;
	}


	public ArrayList<Node> getNodes() {
		return nodes;
	}


	
	public void addNode(Node n){
		nodes.add(n);
		for (Edge e : n.getEdges()) {
			if(!edges.contains(e))
				edges.add(e);
		}
	}
	
	@Override
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		for(Edge e : edges){
			sb.append(e);
			sb.append("\n");
		}
		return sb.toString();
		
		
	}
	
	public void removeNode(Node n){
		try{
			Node removedNode = nodes.remove(nodes.indexOf(n));
			for(Edge e : removedNode.getEdges()){
				int indexOfEdge = edges.indexOf(e);
				if(indexOfEdge >= 0){
					edges.remove(indexOfEdge);
				}
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public Edge getRandomEdge(){
		return edges.get(GraphFactory.randInt(0, edges.size()-1));
	}
	
	

}
