/**
 * Filename: DFSActions.java
 * Author: Yael Brown
 * Date: 8/9/2020
 * Brief Purpose of the Program: Create a Directed Graph
 * and create hierarchial and parenthesized representation
 * of the graph. Also, indicate if there are unreachable
 * verticies.
 */

/**
 * Interface for ParenthesizedList.java and Hierarchy.java
 * @param <E>
 */
public interface DFSActions<E> {
    void cycleDetected();
    void processVertex(Vertex v);
    void descend(Vertex v);
    void ascend(Vertex v);
}