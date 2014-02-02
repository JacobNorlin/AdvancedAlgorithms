package vertexcover;

import java.util.List;

public class Test {

	public static void main(String args[]) throws Exception {

		System.out.println("Random!!!!!");
		for (int n = 100, i = 1; n <= 500; n += 50) {
			for (double j = 1; j <= 4; j += 0.5, i++) {
				print(i,
						GraphFactory.buildRandomGraph(n,
								new Double(n * j).intValue()));
			}
		}

		System.out.println();
		System.out.println();
		System.out.println("Complete!!!!!");
		for (int n = 100, i = 1; n <= 500; n += 50) {
			for (double j = 0.00; j <= 0.05; j += 0.01, i++) {
				print(i, GraphFactory.buildNearCompleteGraph(n, j));
			}
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Star!!!!!");
		for (int n = 100, i = 1; n <= 500; n += 50) {
			for (double j = 0.00; j <= 0.05; j += 0.01, i++) {
				print(i, GraphFactory.buildStarGraph(n, j));
			}
		}

		System.out.println();
		System.out.println();
		System.out.println("Sparse!!!!!");
		for (int n = 100, i = 1; n <= 500; n += 50) {
			for (double j = 0.00; j <= 0.05; j += 0.01, i++) {
				print(i, GraphFactory.buildNearSparseGraph(n, j));
			}
		}

	}

	public static void print(int i, Graph g) {
		VertexCover vc = new VertexCover(g);
		List<Node> greedy = vc.greedy();
		List<Node> ilp = vc.ilp();

		// System.out.println("Greedy:	" + String.format("%5d",greedy.size()) +
		// "	" + String.format("%.2f msec", vc.greedyTime()));
		// System.out.println("Opt:	" + String.format("%5d",ilp.size()) + "	" +
		// String.format("%.2f msec", vc.optTime()));
		// System.out.println("Ratio g:	" +
		// String.format("%.2f",(g.getNodes().size()+0d)/g.getEdges().size()));
		// System.out.println("Ratio s:	" + String.format("%.2f",vc.ratio()));
		// System.out.println();
		System.out.println(String.format("#%d;%d;%d;%f;%f", i, greedy.size(),
				ilp.size(), (g.getNodes().size() + 0d) / g.getEdges().size(),
				vc.ratio()));
	}

}
