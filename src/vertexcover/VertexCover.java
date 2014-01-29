package vertexcover;

import java.util.ArrayList;

public class VertexCover {
	
	public ArrayList<Node> greedy(Graph graph){
		
		ArrayList<Node> vc = new ArrayList<Node>();
		
		while(graph.getEdges().size() > 0){
			//Choose some random edge
			Edge e = graph.getRandomEdge();
			vc.add(e.getU());
			vc.add(e.getV());
			
//			System.out.println(e);
			
			//remove adjacent edges
			graph.removeNode(graph.getNodes().get(graph.getNodes().indexOf(e.getU())));
			graph.removeNode(graph.getNodes().get(graph.getNodes().indexOf(e.getV())));
		}
		
		return vc;
		
	}

}
