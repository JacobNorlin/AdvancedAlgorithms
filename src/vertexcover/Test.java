package vertexcover;

import java.util.List;

public class Test {

	class TestRandom implements Runnable {

		public void run() {
			for (int n = 100, i = 1; n <= 500; n += 100) {
				for (double j = 0.5; j < 3; j += 0.5, i++) {
					try {
						Test.print(
								"Random",
								i,
								GraphFactory.buildRandomGraph(n, new Double(n
										* j).intValue()));
					} catch (Exception e) {
					}
				}
			}
		}
	}

	class TestComplete implements Runnable {
		public void run() {
			for (int n = 100, i = 1; n <= 500; n += 100) {
				for (double j = 0.00; j < 0.05; j += 0.01, i++) {
					print("Complete", i,
							GraphFactory.buildNearCompleteGraph(n, j));
				}
			}
		}
	}

	class TestStar implements Runnable {
		public void run() {
			for (int n = 100, i = 1; n <= 500; n += 100) {
				for (double j = 0.00; j < 0.05; j += 0.01, i++) {
					try {
						print("Star", i, GraphFactory.buildStarGraph(n, j));
					} catch (Exception e) {
					}
				}
			}
		}
	}

	class TestSparse implements Runnable {
		public void run() {
			for (int n = 100, i = 1; n <= 500; n += 100) {
				for (double j = 0.00; j < 0.05; j += 0.01, i++) {
					print("Sparse", i, GraphFactory.buildNearSparseGraph(n, j));
				}
			}
		}
	}

	public static void main(String args[]) throws Exception {
		Test t = new Test();
		new Thread(t.new TestComplete()).start();
		new Thread(t.new TestSparse()).start();
		new Thread(t.new TestStar()).start();
		new Thread(t.new TestRandom()).start();
	}

	public static void print(String type, int i, Graph g) {
		if (false) {
			System.out.println(i);
			return;
		}
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
		System.out.println(String.format("%s;#%d;%d;%d;%f;%f", type, i,
				greedy.size(), ilp.size(), (g.getNodes().size() + 0d)
						/ g.getEdges().size(), vc.ratio()));
	}

}
