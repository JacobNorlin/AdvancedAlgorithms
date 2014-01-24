package empirical.evaluation;

import java.util.ArrayList;

public class VertexCover {
	
	public ArrayList<Node> greedy(Graph graph){
		
		ArrayList<Node> vc = new ArrayList<Node>();
		
		while(graph.getEdges().size() > 0){
			//Choose some random edge
			Edge e = graph.getRandomEdge();
			vc.add(e.getU());
			vc.add(e.getV());
			
			//remove adjacent edges
			graph.removeNode(e.getU());
			graph.removeNode(e.getV());
		}
		
		return vc;
		
	}

}
