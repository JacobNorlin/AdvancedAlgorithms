package vertexcover;

import java.io.IOException;
import java.util.ArrayList;

public class Test {
	
	public static void main(String args[]) throws IOException{
		Graph g = GraphFactory.buildGraphFromFile("C:\\Users\\jacobna\\workspace\\Advanced Algorithms\\frb30-15-mis\\frb30-15-1.mis");
//		System.out.println(g);
		
		VertexCover vc = new VertexCover();
		
		ArrayList<Node> s = vc.greedy(g);
//		
//		for(Node n : s){
//			System.out.println(n.getId());
//		}
		
//		Node n1 = new Node(1);
//		Node n2 = new Node(1);
//		System.out.println(n1.equals(n2));
//		System.out.println(g.getNodes().get(2));
//		for(Edge e : g.getNodes().get(g.getNodes().indexOf(new Node(17))).getEdges())
//			System.out.println(e);
//		
		System.out.println(s.size());
//		
		
		
		
	}
	

}
