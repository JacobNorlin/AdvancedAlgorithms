package vertexcover;

import java.util.ArrayList;
import java.util.Random;

public class Graph {

	private ArrayList<Node> nodes;
	private ArrayList<Edge> edges;
	private int minCover;

	public Graph() {
		nodes = new ArrayList<Node>();
		edges = new ArrayList<Edge>();
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}

	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public void addNode(Node n) {
		nodes.add(n);
		for (Edge e : n.getEdges()) {
			if (!edges.contains(e))
				edges.add(e);
		}
	}

	public void addEdge(Edge e) {
		e.getU().addEdge(e);
		e.getV().addEdge(e);
		edges.add(e);
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		for (Node n : nodes) {
			sb.append(n);
			sb.append("\n");
		}
		sb.append("\n");

		for (Edge e : edges) {
			sb.append(e);
			sb.append("\n");
		}
		return sb.toString();

	}

	public int getAmountOfEdges() {
		return edges.size();
	}

	public void removeNode(Node n) {
		// System.out.println(n);
		// System.out.println(n.getEdges());
		for (Edge e : n.getEdges()) {
			edges.remove(e);
			}
		nodes.remove(n);
	}

	public Edge getRandomEdge() {
		return edges.get(new Random().nextInt(edges.size()));
	}

	public int getMinCover() {
		return minCover;
	}

	public void setMinCover(int minCover) {
		this.minCover = minCover;
	}
	
	public double ratio() {
		return (this.edges.size()+0d)/this.nodes.size();
	}
	
	public Graph copy() {
		Graph g = new Graph();
		g.minCover = this.minCover;
		g.nodes = new ArrayList<Node>(this.nodes);
		g.edges = new ArrayList<Edge>(this.edges);
		return g;
	}

}
