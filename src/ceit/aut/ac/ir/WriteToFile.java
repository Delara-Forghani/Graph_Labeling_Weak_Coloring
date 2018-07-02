package ceit.aut.ac.ir;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class is to write the result in  a txt file
 */
public class WriteToFile {
    private StringBuilder str=new StringBuilder();

    public void WriteToFile(ConstructGraph graph) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("out.txt"));
        for (int i = 0; i < graph.getAdjacencyList().size(); i++) {
            str.append(graph.getAdjacencyList().get(i).getNodeNum() + " " + ":" + " " + graph.getAdjacencyList().get(i).getNodeColor() + "\n");
        }
        writer.write(str.toString());
        writer.close();
    }
}
