package vertexcover;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GraphFactory {

	public static Graph buildRandomGraph(int nodes, int edges) throws Exception {

		int maxEdges = nodes * (nodes - 1) / 2 ;
		if ( maxEdges < edges ) {
			throw new Exception(String.format("Well obviously I cannot create an undirected graph with %d nodes and %d edges since the maximum of edges is %d. Moron.",nodes,edges,maxEdges));
		}
		
		Graph newGraph = new Graph();
		Random r = new Random();

		for (int i = 0; i < nodes; i++) {
			Node n = new Node(i);
			newGraph.addNode(n);
		}

		while (edges > 0) {
			int i = randInt(r, nodes - 1);
			Node u = newGraph.getNodes().get(i);
			Node v = newGraph.getNodes().get(randInt(r, nodes - 1, i));

			Edge e = new Edge(u, v);
			if (!newGraph.getEdges().contains(e)) {
				newGraph.addEdge(e);
				edges--;
			}

		}

		return newGraph;
	}

	public static Graph buildNearCompleteGraph(int nodes, double skip) {

		Graph newGraph = new Graph();
		Random r = new Random();

		for (int i = 0; i < nodes; i++) {
			Node n = new Node(i);
			newGraph.addNode(n);
		}

		int randVal = new Double(skip * 100).intValue() - 1;

		for (int i = 0; i < nodes; i++) {
			for (int j = i; j < nodes; j++) {
				if (i == j || r.nextInt(100) < randVal) {
					continue;
				}
				Node u = newGraph.getNodes().get(i);
				Node v = newGraph.getNodes().get(j);

				Edge e = new Edge(u, v);
				newGraph.addEdge(e);
			}
		}

		return newGraph;
	}

	public static Graph buildNearSparseGraph(int nodes, double skip) {

		Graph newGraph = new Graph();
		Random r = new Random();

		for (int i = 0; i < nodes; i++) {
			Node n = new Node(i);
			newGraph.addNode(n);
		}

		int randVal = new Double(skip * 100).intValue() - 1;

		for (int i = 0; i < nodes; i++) {
			for (int j = i; j < nodes; j++) {
				if (i == j || r.nextInt(100) > randVal) {
					continue;
				}
				Node u = newGraph.getNodes().get(i);
				Node v = newGraph.getNodes().get(j);

				Edge e = new Edge(u, v);
				newGraph.addEdge(e);
			}
		}

		return newGraph;
	}

	public static int randInt(Random r, int max) {
		return randInt(r, max, -1);
	}

	public static int randInt(Random r, int max, int exclude) {

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum;
		while ((randomNum = r.nextInt(max + 1)) == exclude)
			;

		return randomNum;
	}

	public static Graph buildGraphFromFile(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		Graph newGraph = new Graph();
		try {
			String[] firstLine = br.readLine().split(" ");
			// newGraph.setMinCover(Integer.parseInt(firstLine[2]));
			int edges = Integer.parseInt(firstLine[3]);
			int nodes = Integer.parseInt(firstLine[2]);
			for (int i = 1; i <= nodes; i++) {
				Node n = new Node(i);
				newGraph.addNode(n);
			}

			String[] line;
			for (int i = 0; i < edges; i++) {
				line = br.readLine().split(" ");
				Node u = new Node(Integer.parseInt(line[1]));
				Node v = new Node(Integer.parseInt(line[2]));
				Edge newEdge = new Edge(u, v);
				newGraph.addEdge(newEdge);
			}
		} finally {
			br.close();
		}
		return newGraph;
	}

	public static void main(String[] args) {

		System.out.println(buildNearCompleteGraph(3, 0.1));
		System.out.println(buildNearSparseGraph(3, 0.1));
	}

}
