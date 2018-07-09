package ceit.aut.ac.ir;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        ConstructGraph graph = new ConstructGraph();
        BreathFirstSearch bfs = new BreathFirstSearch(graph.adjacencyList);
        System.out.println("Nodes and their Levels in the tree after BreathFirstSearch ");
        for (int i = 0; i < graph.adjacencyList.size(); i++) {
            System.out.println(graph.adjacencyList.get(i).getNodeNum() + " " + graph.adjacencyList.get(i).getLevel());
        }
        PaintingNodes paintingNodes=new PaintingNodes(graph.adjacencyList);
        paintingNodes.sortList();
        System.out.println("List of nodes after sorting based on their level");
        for (int i = 0; i < graph.adjacencyList.size(); i++) {
            System.out.println(graph.adjacencyList.get(i).getNodeNum() + " " + graph.adjacencyList.get(i).getLevel());
        }
        paintingNodes.weakColoring(3);
        System.out.println("Nodes and their colors after painting");
        for (int i = 0; i < graph.adjacencyList.size(); i++) {
            System.out.println(graph.adjacencyList.get(i).getNodeNum() + " " + graph.adjacencyList.get(i).getNodeColor());
        }

         WriteToFile writer=new WriteToFile();
         writer.WriteToFile(graph);


    }
}
