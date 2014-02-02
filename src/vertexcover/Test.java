package vertexcover;

import java.util.List;

public class Test {

	public static void main(String args[]) throws Exception {
		// GraphFactory.buildGraphFromFile("C:\\Users\\jacobna\\workspace\\Advanced Algorithms\\frb30-15-mis\\frb30-15-1.mis");
		System.out.println("Random graph");
		print(GraphFactory.buildRandomGraph(1000, 2000));
		System.out.println("Complete graph");
		print(GraphFactory.buildNearCompleteGraph(1000, 0.05));
		System.out.println("Sparse");
		print(GraphFactory.buildNearSparseGraph(1000, 0.05));

		
	}

	public static void print(Graph g) {
		VertexCover vc = new VertexCover(g);
		List<Node> greedy = vc.greedy();
		List<Node> ilp = vc.ilp();

		System.out.println("Greedy:	" + String.format("%5d",greedy.size()) 	+ "	" + String.format("%.2f sec", vc.greedyTime()));
		System.out.println("Opt:	" + String.format("%5d",ilp.size()) 	+ "	" + String.format("%.2f sec", vc.optTime()));
		System.out.println("Ratio:	 " + String.format("%.2f",vc.ratio()));
		System.out.println();

	}

}
