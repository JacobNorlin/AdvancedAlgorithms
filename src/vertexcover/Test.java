package vertexcover;

import java.io.IOException;
import java.util.ArrayList;

public class Test {
	
	public static void main(String args[]) throws IOException{
//		Graph g = GraphFactory.buildGraphFromFile("C:\\Users\\jacobna\\workspace\\Advanced Algorithms\\frb30-15-mis\\frb30-15-1.mis");
		Graph g = GraphFactory.buildRandomGraph(3000, 4000);
//		Graph g = GraphFactory.buildNearCompleteGraph(10, 0);
//		Graph g = GraphFactory.buildNearSparseGraph(1000, 0.1);
		
		System.out.println(g);
		
		VertexCover vc = new VertexCover(g);
		
		ArrayList<Node> s = vc.greedy();
		System.out.println(s.size());
	}
	

}
