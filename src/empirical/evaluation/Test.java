package empirical.evaluation;

import java.util.ArrayList;

public class Test {
	
	public static void main(String args[]){
		Graph g = GraphFactory.buildRandomGraph(5, 5);
		System.out.println(g);
		
		VertexCover vc = new VertexCover();
		
		ArrayList<Node> s = vc.greedy(g);
		
		for(Node n : s){
			System.out.println(n.getId());
		}
		
	}
	

}
