package vertexcover;

import java.util.ArrayList;
import java.util.List;

import net.sf.javailp.*;

public class VertexCover {

	List<Node> vcGreedy;
	List<Node> vcOpt;
	Graph g;
	float greedyTime;
	float optTime;

	public VertexCover(Graph graph) {
		this.g = graph;
		this.vcGreedy = new ArrayList<Node>();
		this.vcOpt = new ArrayList<Node>();
	}

	public List<Node> greedy() {
		// System.err.println("Started Greedy");
		float start = System.currentTimeMillis();
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
		this.greedyTime = System.currentTimeMillis() - start;
		// System.err.println("Finished Greedy");
		return this.vcGreedy;
	}

	public double ratio() {
		if (this.vcOpt.size() == 0) {
			return 0;
		}
		return (this.vcGreedy.size() + 0d) / this.vcOpt.size();
	}

	public List<Node> ilp() {
		// System.err.println("Started ILP");
		float start = System.currentTimeMillis();
		this.vcOpt = new ArrayList<Node>();

		SolverFactory factory = new SolverFactoryGurobi();
		factory.setParameter(Solver.VERBOSE, 0);

		Problem problem = new Problem();
		Linear linear = new Linear();

		// Set objective function as sum of all X_n
		for (Node n : g.getNodes()) {
			linear.add(1, n);
		}
		problem.setObjective(linear, OptType.MIN);

		// Add constraint that for every edge X_n+X_m >= 1
		for (Edge e : g.getEdges()) {
			linear = new Linear();
			linear.add(1, e.getU());
			linear.add(1, e.getV());
			problem.add(linear, ">=", 1);
		}

		for (Node n : g.getNodes()) {
			problem.setVarType(n, Boolean.class);
		}

		Solver solver = factory.get();
		solver.setParameter(g.getNodes().get(0), new Integer(1));
		Result result = solver.solve(problem);
		for (Node n : g.getNodes()) {
			if (result.get(n).intValue() == 1) {
				this.vcOpt.add(n);
			}
		}

		this.optTime = System.currentTimeMillis() - start;
		// System.err.println("Finished ILP");
		result = null;
		solver = null;

		return this.vcOpt;
	}

	public float greedyTime() {
		return this.greedyTime * 1000;
	}

	public float optTime() {
		return this.optTime * 1000;
	}
}
