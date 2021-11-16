public class Tour {
    private Node start;         // node containing starting point
    private int count = 0;      // total number of points in tour

    private class Node {
        private Point p;        // point stored in the node
        private Node next;      // following node

        // initializes a Node object
        private Node(Point p) {
            this.p = p;
            next = null;
        }
    }

    // creates an empty tour
    public Tour() {

    }

    // creates the 4-point tour a->b->c->d->a (for debugging)
    public Tour(Point a, Point b, Point c, Point d) {
        Node nodeA = new Node(a);
        count++;

        Node nodeB = new Node(b);
        count++;
        nodeA.next = nodeB;

        Node nodeC = new Node(c);
        count++;
        nodeB.next = nodeC;

        Node nodeD = new Node(d);
        count++;
        nodeC.next = nodeD;
        nodeD.next = nodeA;

        start = nodeA;
    }

    // returns the number of points in this tour
    public int size() {
        return count;
    }

    // returns the length of this tour
    public double length() {
        double length = 0.0;
        Node current = start;

        do {
            length += current.p.distanceTo(current.next.p);
            current = current.next;
        } while (current != start);

        return length;
    }

    // returns a string representation of this tour
    public String toString() {
        StringBuilder statement = new StringBuilder();
        Node current = start;

        do {
            statement.append(current.p.toString() + "\n");
            current = current.next;
        } while (current != start);

        return statement.toString();
    }

    // draws this tour to standard drawing
    public void draw() {
        Node current = start;

        do {
            current.p.drawTo(current.next.p);
            current = current.next;
        } while (current != start);
    }

    // inserts p using the nearest neighbor heuristic
    public void insertNearest(Point p) {

    }

    // inserts p using the smallest increase heuristic
    public void insertSmallest(Point p) {

    }


    public static void main(String[] args) {
        StdDraw.setXscale(0, 600);
        StdDraw.setYscale(0, 600);

        // define 4 points that are the corners of a square
        Point a = new Point(100.0, 100.0);
        Point b = new Point(500.0, 100.0);
        Point c = new Point(500.0, 500.0);
        Point d = new Point(100.0, 500.0);

        // create the tour a -> b -> c -> d -> a
        Tour squareTour = new Tour(a, b, c, d);

        // print the size to standard output
        int size = squareTour.size();
        double length = squareTour.length();
        StdOut.println("Number of points = " + size);
        StdOut.println("Length = " + length);
        StdOut.println(squareTour);

        squareTour.draw();
    }
}
