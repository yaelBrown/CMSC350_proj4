/**
 * Filename: ParenthesizedList.java
 * Author: Yael Brown
 * Date: 8/9/2020
 * Brief Purpose of the Program: Create a Directed Graph
 * and create hierarchial and parenthesized representation
 * of the graph. Also, indicate if there are unreachable
 * verticies.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Generates Parenthesized list from representation of graph.
 * @param <E>
 */
class ParenthesizedList<E> implements DFSActions<E>{

    @Override
    public void cycleDetected() {
        r.add("*");
    }

    @Override
    public void processVertex(Vertex v) {
        r.add(v.getName());
    }

    @Override
    public void descend(Vertex v) {
        r.add("(");
    }

    @Override
    public void ascend(Vertex v) {
        r.add(")");
    }

    @Override
    public String toString() {
        return printParenthesizedList();
    }

    Queue<String> r = new LinkedList<>();

    /**
     * Generates Parenthesized List for toString() method.
     * @return
     */
    public String printParenthesizedList() {
        String out = "";
        out += "( ";

        while (this.r.size() > 0) {
            out += r.peek() + " ";
            r.remove();
        }
        out += ")\n";

        System.out.println(out);
        return out;
    }
}
