package csc316project3;

/*
 * Bag.java was taken from the site
 * 	http://www.cs.princeton.edu/algs4/13stacks/Bag.java.html
 * 	Copyright   2002 2010, Robert Sedgewick and Kevin Wayne. 
 * This class was minimally modified to work with the project specifications
 * for Project 3 of Dr. Stallmanns Fall 2010 CSC 316 class (NCSU)
 */
/*************************************************************************
 *  Compilation:  javac Bag.java
 *  Execution:    java Bag
 *
 *  A generic bag or multiset, implemented using a linked list.
 *
 *************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  The <tt>Bag</tt> class represents a bag (or multiset) of 
 *  generic items. It supports insertion and iterating over the 
 *  items in arbitrary order.
 *  <p>
 *  The <em>add</em>, <em>isEmpty</em>, and <em>size</em>  operation 
 *  take constant time. Iteration takes time proportional to the number of items.
 *  <p>
 *  For additional documentation, see <a href="/algs4/13stacks">Section 1.3</a> of
 *  <i>Algorithms in Java, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 */
public class Bag<Item> implements Iterable<Item> {
    private int N;         // number of elements in bag
    private Node first;    // beginning of bag

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

   /**
     * Create an empty stack.
     */
    public Bag() {
        first = null;
        N = 0;
    }

   /**
     * Is the BAG empty?
     */
    public boolean isEmpty() {
        return first == null;
    }

   /**
     * Return the number of items in the bag.
     */
    public int size() {
        return N;
    }

   /**
     * Add the item to the bag.
     */
    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }


   /**
     * Return an iterator that iterates over the items in the bag.
     */
    public Iterator<Item> iterator()  {
        return new LIFOIterator();  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class LIFOIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }


   /**
     * A test client.
     */
    public static void main(String[] args) {

       /***********************************************
        *  A bag of strings
        ***********************************************/
        Bag<String> bag = new Bag<String>();
        bag.add("Vertigo");
        bag.add("Just Lose It");
        bag.add("Pieces of Me");
        bag.add("Drop It Like It's Hot");
        for (String s : bag) {
            System.out.println(s);
        }
    }
}

