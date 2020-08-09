import java.util.ArrayList;

public class Vertex {
    public Vertex(String n) { this.name = n; }
    private String name;
    public String getName() { return name; }
    private ArrayList<String> adjList = new ArrayList<>();
    public ArrayList<String> getAdjList() { return adjList; }
}