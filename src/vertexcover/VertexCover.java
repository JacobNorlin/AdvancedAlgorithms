package vertexcover;

import java.util.ArrayList;
import java.util.List;

public class VertexCover {

	ArrayList<Node> vcGreedy;
	ArrayList<Node> vcOpt;
	Graph g;

	public VertexCover(Graph graph) {
		this.g = graph;
		this.vcGreedy = new ArrayList<Node>();
		this.vcOpt = new ArrayList<Node>();
	}

	public ArrayList<Node> greedy() {
		Graph graph = this.g.copy();
		this.vcGreedy = new ArrayList<Node>();

		while (graph.getEdges().size() > 0) {
			// Choose some random edge
			Edge e = graph.getRandomEdge();
			this.vcGreedy.add(e.getU());
			this.vcGreedy.add(e.getV());

			// remove adjacent edges
			graph.removeNode(e.getU());
			graph.removeNode(e.getV());
		}
		return this.vcGreedy;
	}

	public double ratio() {
		return (this.vcGreedy.size() + 0d) / this.vcOpt.size();
	}

}
