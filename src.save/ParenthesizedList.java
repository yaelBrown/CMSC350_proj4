import java.util.LinkedList;
import java.util.Queue;

public class ParenthesizedList<E> implements DFSActions<DirectedGraph.Vertex> {

    Queue<String> r = new LinkedList<>();

    @Override
    public void cycleDetected() { r.add("*"); }

    @Override
    public void processVertex(DirectedGraph.Vertex ele) { r.add(ele.getName()); }

    @Override
    public void descend(DirectedGraph.Vertex ele) { r.add("("); }

    @Override
    public void ascend(DirectedGraph.Vertex ele) { r.add(")"); }

    @Override
    public String toString() {
        String out = "";
        out = out.concat("( ");
        while (r.size() > 0) {
            String next = r.peek();
            r.remove();

            if (next.equals("(")) {
                if (r.peek().equals("*")) {
                    out = out.concat(r.peek() + " ");
                    r.remove();
                    r.remove();
                    continue;
                } else if (next.equals(")")) {
                    r.remove();
                    continue;
                }
            }
            out = out.concat(next + " ");
        }
        return out + ")\n";
    }
}
