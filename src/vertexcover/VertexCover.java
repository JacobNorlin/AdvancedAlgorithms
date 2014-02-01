package vertexcover;

import java.util.ArrayList;
import java.util.List;

import net.sf.javailp.*;

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

	public void optVC(){



		SolverFactory factory = new SolverFactoryLpSolve();
		factory.setParameter(Solver.VERBOSE, 0); 

		Problem problem = new Problem();
		Linear linear = new Linear();
		
		//Set objective function as sum of all X_n
		for(Node n : g.getNodes()){
			linear.add(1, n);
		}
		


		problem.setObjective(linear, OptType.MIN);

		//Add constraint that for every edge X_n+X_m >= 1
		for(Edge e : g.getEdges()){
			linear = new Linear();
			linear.add(1, e.getU());
			linear.add(1, e.getV());
			problem.add(linear, ">=", 1);	
		}

		for(Node n : g.getNodes())
			problem.setVarType(n, Boolean.class);
		
//		System.out.println(problem);
		
		Solver solver = factory.get();
				
		Result result = solver.solve(problem);
		
		System.out.println(result);
	}

}
