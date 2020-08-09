import java.io.File;
import java.io.IOException;
import java.util.*;

public class DirectedGraph<Vertex> {

    static class Vertex {
        public Vertex(String n) { this.name = n; }
        private String name;
        public String getName() { return name; }
    }

    public DirectedGraph(File f) throws IOException {
        createDirectedGraph(f);
        displayGraph();
    }

    @Override
    public String toString() {
        return "DirectedGraph{" +
                "adj=" + adj +
                '}';
    }

    private void createDirectedGraph(File f) throws IOException {
        HashMap<Vertex, ArrayList<Vertex>> temp = new HashMap<Vertex, ArrayList<Vertex>>();

        try {
            Scanner file_in = new Scanner(f);
            while (file_in.hasNextLine()) {
                String tempStr = file_in.nextLine();
                String[] vertexStrArr = tempStr.split(" ");
                ArrayList<Vertex> tempArrL = new ArrayList<>();

                for (int i = 1; i < vertexStrArr.length; i++) {
                    tempArrL.add((Vertex) new DirectedGraph.Vertex(vertexStrArr[i]));
                }

                temp.put((Vertex) new DirectedGraph.Vertex(vertexStrArr[0]), tempArrL);
            }
            this.adj = temp;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Map<Vertex, ArrayList<Vertex>> adj = new HashMap<>();

//    public Vertex root = null;
    boolean cycle;

    Heirarchy<DirectedGraph.Vertex> h = new Heirarchy<>();
    ParenthesizedList<DirectedGraph.Vertex> p = new ParenthesizedList<>();

    HashSet<Vertex> discoveredVertex = new HashSet<>();
    HashSet<Vertex> visitedNodes = new HashSet<>();

    ParenthesizedList parenthesizedList = new ParenthesizedList();
    Heirarchy heirarchy = new Heirarchy();

    Map<String, DirectedGraph.Vertex> vertices = new HashMap<String, DirectedGraph.Vertex>();

    public void depthFirstSearch() {
        cycle = false;
        dfsHelper(adj.get(0));
    }

    private void dfsHelper(Vertex v) {
        if (discoveredVertex.contains(v)) {
            cycle = true;
            h.cycleDetected();
            p.cycleDetected();
            return;
        }

        h.processVertex((DirectedGraph.Vertex) v);
        p.processVertex((DirectedGraph.Vertex) v);

        visitedNodes.add(v);
        discoveredVertex.add(v);

        ArrayList<Vertex> l = adj.get(v);
        if (l != null) { for (Vertex vx : l) dfsHelper(vx); }

        h.ascend((DirectedGraph.Vertex) v);
        p.ascend((DirectedGraph.Vertex) v);
        discoveredVertex.remove(v);

//        resetVisitedNodes();
    }

    public void displayUnreachableVertices() {
        for (Map.Entry<Vertex, ArrayList<Vertex>> vi : adj.entrySet()) {
            if (vi.getValue().size() != 0) {
                if (!visitedNodes.contains(vi.getKey())) {
                    System.out.println(vi.getKey() + " is unreachable!");
                }
                for (Vertex vii : vi.getValue()) {
                    System.out.println(vii + " is unreachable!");
                    visitedNodes.add(vii);
                }
            }
        }
//        resetVisitedNodes();
    }

    public void addVertex(String vtex) {
        vertices.put(vtex, new DirectedGraph.Vertex(vtex));

    }

    public void addEdge(String vtx, String edge) {
        for (Map.Entry<Vertex, ArrayList<Vertex>> entry : this.adj.entrySet()) {
            if (entry.getKey().toString().equals(vtx)) {
                entry.getValue().add((Vertex) new DirectedGraph.Vertex(edge));
            }
        }
        System.out.println("Added edge: " + edge + ", to vertex: " + vtx);


    }

    private void resetVisitedNodes() {
        this.visitedNodes = new HashSet<>();
    }

    private void displayGraph() {
//        for (int i = 0; i < adj.size(); i++) {
//            System.out.println("adj[" + i + "]: " + adj.get(i));
//        }
    }

}
