import java.util.LinkedList;
import java.util.Queue;

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

    Queue<String> r = new LinkedList<>();

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
