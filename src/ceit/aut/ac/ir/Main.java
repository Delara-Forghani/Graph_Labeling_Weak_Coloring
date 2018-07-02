package ceit.aut.ac.ir;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        ConstructGraph graph = new ConstructGraph();
        PaintingNodes painting = new PaintingNodes(graph.getAdjacencyList());
        painting.weakColoring();
        System.out.println("***********");
        System.out.println("Colors of the nodes by WeakColoring: ");
        for (int i = 0; i < graph.getAdjacencyList().size(); i++) {
            System.out.println(graph.getAdjacencyList().get(i).getNodeNum() + " " + ":" + " " +graph.getAdjacencyList().get(i).getNodeColor());
        }
        WriteToFile writer=new WriteToFile();
        writer.WriteToFile(graph);


    }
}
