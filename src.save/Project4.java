import javax.swing.*;
import java.io.*;

public class Project4 {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        Integer response = chooser.showOpenDialog(null);

        if (response == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            try {
                if (f.isFile()) {
                    DirectedGraph dg = new DirectedGraph(f);

                    // Add vertex and edge to graph
//                    dg.addVertex("ClassY");
//                    dg.addEdge("ClassY", "ClassZ");

                    // Depth First Search
                    dg.depthFirstSearch();

                    // Representation
                    dg.heirarchy.toString();
                    dg.parenthesizedList.toString();

                    // Display the unreachables
                    dg.displayUnreachableVertices();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
