public interface DFSActions<E> {
    void cycleDetected();
    void processVertex(DirectedGraph.Vertex ele);
    void descend(DirectedGraph.Vertex ele);
    void ascend(DirectedGraph.Vertex ele);
}
