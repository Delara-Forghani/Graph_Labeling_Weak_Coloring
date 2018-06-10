package ceit.aut.ac.ir;

import java.io.*;

public class InputFileReader {
    Graph graph = new Graph();
    public InputFileReader(String pathname) throws IOException {
        File input = new File(pathname);
        BufferedReader reader = new BufferedReader(new FileReader(input));
        String line;
        while ((line = reader.readLine()) != null) {
        //    graph.creatingGraph(line);
        }
    }
    public Graph getGraph(){
        return graph;
    }
}
