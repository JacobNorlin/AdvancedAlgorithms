package vertexcover;

import java.util.ArrayList;

public class Node implements Comparable<Node>{
	
	private ArrayList<Edge> edges;
	private int id;
	
	
	public Node(ArrayList<Edge> edges, int id){
		edges = new ArrayList<Edge>();
		this.setId(id);
		this.setEdges(edges);
	}
	
	public Node(int id){
		edges = new ArrayList<Edge>();
		this.setId(id);
	}


	public ArrayList<Edge> getEdges() {
		return edges;
	}


	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}
	
	public void addEdge(Edge edge) {
		this.edges.add(edge);
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public int compareTo(Node otherNode) {
		if(otherNode.id == this.id)
			return 0;
		return -1;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o.getClass() != Node.class){
			return false;
		}
		Node otherNode = (Node)o;
		if(otherNode.id == this.id)
			return true;
		return false;
	}
	
	@Override
	public String toString(){
		return "Node: "+id;
	}
}
