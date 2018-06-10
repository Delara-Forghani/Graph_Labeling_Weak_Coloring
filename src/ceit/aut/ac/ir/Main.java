package ceit.aut.ac.ir;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Graph graph = new Graph();
//        InputFileReader fileReader=new InputFileReader("C:\\Users\\Delara Forghani\\Desktop\\Input.txt");
//        Graph graph=fileReader.getGraph();
        PaintingNodes painting = new PaintingNodes(graph.getAdjacencyList());
        painting.weakColoring();
        System.out.println("***********");
        for (int i = 0; i < graph.getAdjacencyList().size(); i++) {
            System.out.println(graph.getAdjacencyList().get(i).getNodeNum() + " " + ":" + " " +graph.getAdjacencyList().get(i).getNodeColor());
        }
        //    File input = new File("C:\\Users\\Delara Forghani\\Desktop\\Input.txt");
        //    BufferedReader reader = new BufferedReader(new FileReader(input));
        //    String line;
        //    while ((line=reader.readLine()) != null) {
        //        System.out.print(line);

        //  }

    }
}
