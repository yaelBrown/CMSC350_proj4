/**
 * Filename: Vertex.java
 * Author: Yael Brown
 * Date: 8/9/2020
 * Brief Purpose of the Program: Create a Directed Graph
 * and create hierarchial and parenthesized representation
 * of the graph. Also, indicate if there are unreachable
 * verticies.
 */

import java.util.ArrayList;

/**
 * Class defines Verticies within the graph.
 * Holds an Arraylist of adjacent Verticies.
 */
public class Vertex {
    public Vertex(String n) { this.name = n; }
    private String name;
    public String getName() { return name; }
    private ArrayList<String> adjList = new ArrayList<>();
    public ArrayList<String> getAdjList() { return adjList; }
}