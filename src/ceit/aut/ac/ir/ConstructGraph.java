package ceit.aut.ac.ir;

import java.io.*;
import java.util.ArrayList;


public class ConstructGraph {
    File input = new File("C:\\Users\\Delara Forghani\\Desktop\\Input.txt");
    ArrayList<GraphEdge> graph = new ArrayList<>();
    ArrayList<Node> adjacencyList = new ArrayList<>();

    /**
     * The constructor of this class is to construct the graph from CSV file ; it gets all the edges ,
     * add the nodes with their adjacent nodes to the adjacent list.
     * @throws IOException
     */
    public ConstructGraph() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(input));
        String line;
        while ((line = reader.readLine()) != null) {
            String vertices[] = line.split(" ");
            Node vertex1 = new Node(Integer.parseInt(vertices[0]), 0);
            Node vertex2 = new Node(Integer.parseInt(vertices[1]), 0);
            GraphEdge graphEdge = new GraphEdge(vertex1, vertex2);
            graph.add(graphEdge);
            ArrayList<Integer> checkExistance = checkExistance(graphEdge);
            adjacencyList.get(checkExistance.get(0)).neighborAdding(adjacencyList.get(checkExistance.get(1)));
            adjacencyList.get(checkExistance.get(1)).neighborAdding(adjacencyList.get(checkExistance.get(0)));
        }
        boolean[] isolationCheck = new boolean[adjacencyList.size() + 1];
        for (int i = 0; i < adjacencyList.size(); i++) {
            if (adjacencyList.get(i).getNodeNum() < isolationCheck.length) {
                isolationCheck[adjacencyList.get(i).getNodeNum()] = true;
            }
        }
        for (int i = 1; i < isolationCheck.length; i++) {
            if (!isolationCheck[i]) {
                Node isolateNode = new Node(i, 1);
                adjacencyList.add(isolateNode);
            }
        }
        System.out.println("All nodes with their adjacent nodes: ");
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.print(adjacencyList.get(i).getNodeNum() + ":" + " ");

            for (int j = 0; j < adjacencyList.get(i).adjacentNodes.size(); j++) {
                System.out.print(adjacencyList.get(i).adjacentNodes.get(j).getNodeNum() + " ");
            }
            System.out.println();
        }
    }

    /**
     * This method checks each of the two vertices of an edge to find out whether the vertices had been in the list before or not;
     * If yes it returns the index of the vertex in list if not adds the vertex to the list and returns its index
     * @param edge
     * @return
     */
    public ArrayList<Integer> checkExistance(GraphEdge edge) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean firstVertexCheck = false;
        boolean secondVertexCheck = false;
        int firstVertexPlace = 0;
        int secondVertexPlace = 0;
        result.add(0, -1);
        result.add(1, -1);
        for (int i = 0; i < adjacencyList.size(); i++) {
            if (adjacencyList.get(i).getNodeNum() == edge.getVertex1().getNodeNum()) {
                firstVertexPlace = i;
                firstVertexCheck = true;
            } else if (adjacencyList.get(i).getNodeNum() == edge.getVertex2().getNodeNum()) {
                secondVertexPlace = i;
                secondVertexCheck = true;
            }
        }
        if (firstVertexCheck) {
            result.set(0, firstVertexPlace);
        } else if (!firstVertexCheck) {
            adjacencyList.add(edge.getVertex1());
            result.set(0, adjacencyList.indexOf(edge.getVertex1()));
        }
        if (secondVertexCheck) {
            result.set(1, secondVertexPlace);
        } else if (!secondVertexCheck) {
            adjacencyList.add(edge.getVertex2());
            result.set(1, adjacencyList.indexOf(edge.getVertex2()));
        }
        return result;
    }

    public ArrayList<Node> getAdjacencyList() {
        return adjacencyList;
    }


}
