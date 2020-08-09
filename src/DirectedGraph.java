import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class DirectedGraph {

    public DirectedGraph(File f) throws IOException {
        ArrayList<Vertex> temp = new ArrayList<>();

        try {
            Scanner file_in = new Scanner(f);
            while (file_in.hasNextLine()) {
                String tempStr = file_in.nextLine();
                String[] vertexStrArr = tempStr.split(" ");

                Vertex vtemp = new Vertex(vertexStrArr[0]);

                System.out.println("Vertex: " + vertexStrArr[0]);

                for (int i = 1; i < vertexStrArr.length; i++) {
                    vtemp.getAdjList().add(vertexStrArr[i]);
                    System.out.println("\tAdding: " + vertexStrArr[i]);
                }
                System.out.println("\n");

                temp.add(vtemp);
            }
            this.graph = temp;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ArrayList<Vertex> graph = null;

    Set<String> visitedVertices = new LinkedHashSet<>();
    ArrayList<String> discoveredVertices = new ArrayList<>();

    boolean cycle = false;
    ParenthesizedList parenthesizedList = new ParenthesizedList();
    Hierarchy hierarchy = new Hierarchy();

    public void depthFirstSearch() {
        dfsHelper(graph.get(0).getName());
        hierarchy.toString();
    }

    private void dfsHelper(String v) {
        if (discoveredVertices.contains(v)) {
            cycle = true;
            parenthesizedList.cycleDetected();
            hierarchy.cycleDetected();
            return;
        }

        Vertex tempVertex = findVertex(v);
        if (tempVertex == null) {
            tempVertex = new Vertex(v);
        }

        parenthesizedList.processVertex(tempVertex);
        hierarchy.processVertex(tempVertex);

        parenthesizedList.descend(tempVertex);
        hierarchy.descend(tempVertex);

        discoveredVertices.add(v);
        visitedVertices.add(v);

        if (tempVertex.getAdjList() != null) {
            for (String vx : tempVertex.getAdjList()) {
                dfsHelper(vx);
            }
        }

        hierarchy.ascend(tempVertex);
        parenthesizedList.ascend(tempVertex);

        discoveredVertices.remove(v);
    }

    private Vertex findVertex(String vName) {
        Vertex out = null;

        for (Vertex t : this.graph) {
            if (t.getName().equals(vName)) {
                return t;
            }
        }

        return out;
    }

    public void displayUnreachableVerticies() {
        for (Vertex vt : graph) {
            if (visitedVertices.contains(vt.getName())) {
                continue;
            } else {
                System.out.println(vt.getName() + " is unreachable!!!");
            }
        }
    }


}
