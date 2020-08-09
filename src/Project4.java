/**
 * Filename: Project4.java
 * Author: Yael Brown
 * Date: 8/9/2020
 * Brief Purpose of the Program: Create a Directed Graph
 * and create hierarchial and parenthesized representation
 * of the graph. Also, indicate if there are unreachable
 * verticies.
 */

import javax.swing.*;
import java.io.File;

public class Project4 {

    public static void main(String[] args) {
        // Create DirectedGraph
        DirectedGraph dg = createDirectedGraph();

        // Complete DepthFirstSearch
        dg.depthFirstSearch();

        // Print Hierarchy list
        dg.hierarchy.toString();

        // Print Parenthesized list
        dg.parenthesizedList.toString();

        // Display unreachable verticies if there are any
        dg.displayUnreachableVerticies();

    }

    /**
     * Creates directed graph from file
     * @return
     */
    public static DirectedGraph createDirectedGraph() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        Integer response = chooser.showOpenDialog(null);

        DirectedGraph out = null;

        if (response == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            try {
                if (f.isFile()) {
                    return new DirectedGraph(f);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return out;
    }
}