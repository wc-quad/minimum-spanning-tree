package csc316project3;

/*
 * Bag.java was taken from the site
 * 	http://www.cs.princeton.edu/algs4/43mst/Edge.java.html
 * 	Copyright   2002 2010, Robert Sedgewick and Kevin Wayne. 
 * This class was minimally modified to work with the project specifications
 * for Project 3 of Dr. Stallmanns Fall 2010 CSC 316 class (NCSU)
 */
/*************************************************************************
 *  Compilation:  javac Edge.java
 *  Execution:    java Edge
 *
 *  Immutable weighted edge.
 *
 *************************************************************************/

/**
 *  The <tt>Edge</tt> class represents a weighted edge in an undirected graph.
 *  <p>
 *  For additional documentation, see <a href="/algs4/43mst">Section 4.3</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 */
public class Edge { 

    private final int v;
    private final int w;
    private final int weight;

   /**
     * Create an edge between v and w with given weight.
     */
    public Edge(int v, int w, int weight) {
        this.v = v-1;
        this.w = w-1;
        this.weight = weight;
    }

   /**
     * Return the weight of this edge.
     */
    public double weight() {
        return weight;
    }

   /**
     * Return either endpoint of this edge.
     */
    public int either() {
        return v;
    }

   /**
     * Return the endpoint of this edge that is different from the given vertex
     * (unless a self-loop).
     */
    public int other(int vertex) {
        if      (vertex == v) return w;
        else if (vertex == w) return v;
        else throw new RuntimeException("Illegal endpoint");
    }

   /**
     * Return a string representation of this edge.
     */
    public String toString() {
        return String.format("e %d %d %d", v+1, w+1, weight);
    }


   /**
     * Test client.
     */
    public static void main(String[] args) {
        Edge e = new Edge(12, 23, 3);
        StdOut.println(e);
    }
}
