import javax.swing.*;
import java.io.File;

public class Project4 {

    public static void main(String[] args) {
        DirectedGraph dg = createDirectedGraph();

        dg.depthFirstSearch();

        dg.hierarchy.printHierarchy();

        dg.parenthesizedList.printParenthesizedList();

        dg.displayUnreachableVerticies();

    }

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







// Make better test cases 
// Prepare doc file