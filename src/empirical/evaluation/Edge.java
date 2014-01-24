package empirical.evaluation;

public class Edge implements Comparable<Edge> {
	
	private Node u;
	private Node v;
	
	public Edge(Node u, Node v){
		this.setV(v);
		this.setU(u);
	}

	public Node getV() {
		return v;
	}

	public void setV(Node v) {
		this.v = v;
	}

	public Node getU() {
		return u;
	}

	public void setU(Node u) {
		this.u = u;
	}
	
	@Override
	public int compareTo(Edge otherEdge){
		
		if (otherEdge.u.equals(this.u) && otherEdge.v.equals(this.v) || otherEdge.v.equals(this.u) && otherEdge.u.equals(this.v) ){
			return 0;
		}
		return -1;
		
	}
	
	public String toString(){
		return "(u:"+u.getId()+", v:"+v.getId()+")"
;	}

}
