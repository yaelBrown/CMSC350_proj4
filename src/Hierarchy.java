import java.util.LinkedList;
import java.util.Queue;

class Hierarchy<E> implements DFSActions<E> {

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

    public Queue<String> r = new LinkedList<>();

    public String printHierarchy() {
        int tempSize = r.size();
        StringBuilder out = new StringBuilder();

        int size = 0;

        while (r.size() > 0) {
            String next = r.peek();
            r.remove();

            if (next == "(") {
                if (r.peek().equals(")")) {
                    r.remove();
                    continue;
                } else if (r.peek().equals("*")) {
                    out = new StringBuilder(out.toString().concat(r.peek() + " "));
                    r.remove();
                    r.remove();
                    continue;
                }
            }

            if (next.equals("(")) { size++; }
            else if (next.equals(")")) { size--; }

            if (next.equals("(") || next.equals(")")) { continue; }
            if (next != "*") { out.append("\n"); }
            for (int i = 0; i < size; i++) { out.append("\t"); }

            out.append(next).append(" ");
        }
        out.append("\n");

        System.out.println(out);

        return out.toString();
    }


}
