public interface DFSActions<E> {
    void cycleDetected();
    void processVertex(Vertex v);
    void descend(Vertex v);
    void ascend(Vertex v);
}