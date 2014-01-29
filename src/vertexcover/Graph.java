package vertexcover;

import java.util.ArrayList;

public class Graph {

	private ArrayList<Node> nodes;
	private ArrayList<Edge> edges;
	private int minCover;

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

	public void addEdge(Edge e){
		//this is dumb i dont like this
		nodes.get(nodes.indexOf(e.getU())).addEdge(e);
		nodes.get(nodes.indexOf(e.getV())).addEdge(e);
		edges.add(e);
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

	public int getAmountOfEdges(){
		return edges.size();
	}

	public void removeNode(Node n){
//		System.out.println(n);
//		System.out.println(n.getEdges());
		for(Edge e : n.getEdges()){
			int indexOfEdge = edges.indexOf(e);
			if(indexOfEdge >= 0){
				edges.remove(indexOfEdge);
//				System.out.print(e+" ");
			}



		}
		nodes.remove(nodes.indexOf(n));
	}

	public Edge getRandomEdge(){
		return edges.get(GraphFactory.randInt(0, edges.size()-1));
	}


	public int getMinCover() {
		return minCover;
	}


	public void setMinCover(int minCover) {
		this.minCover = minCover;
	}



}
