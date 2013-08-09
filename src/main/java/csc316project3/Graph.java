package csc316project3;

import java.util.Iterator;

public class Graph extends EdgeWeightedGraph {
	
	/**
	 * Creates a new enpty graph with v vertices
	 * @param v number of vertices in the graph
	 */
	public Graph(int v) {
		super(v);
	}
	
	/**
	 * Setter for the number of edges the graph has
	 * @param e number of edges
	 */
	public void setNumEdges(int e){
		this.E = e;
	}

    /**
     * Returns a string representation of the graph
     */
    public String toString() {
        String s = "";
        s = "g " + this.V() + " " + this.E() + "\n";
        for(int i=0; i < adj.length; i++){
            Iterator<Edge> itr = adj[i].iterator();
            while(itr.hasNext()) {
            	Edge element = itr.next();
                s += element.toString();
                s += "\n";
            }
        }
        return s;
    }

    /**
     * A testing main to ensure everything works
     * @param args
     */
    public static void main(String[] args) {
        Graph G = new Graph(5);
        Edge e;
        e = new Edge(1, 2, 20);
        G.addEdge(e);
        e = new Edge(1, 3, 14);
        G.addEdge(e);
        e = new Edge(2, 5, 24);
        G.addEdge(e);
        e = new Edge(2, 4, 18);
        G.addEdge(e);
        e = new Edge(4, 5, 16);
        G.addEdge(e);
        e = new Edge(3, 2, 17);
        G.addEdge(e);
        e = new Edge(3, 4, 3);
        G.addEdge(e);
        e = new Edge(1, 5, 10);
        G.addEdge(e);

        System.out.println(G);		// print out graph

    }

}
