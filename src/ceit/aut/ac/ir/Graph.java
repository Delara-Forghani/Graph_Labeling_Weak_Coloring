package ceit.aut.ac.ir;

import java.io.*;
import java.util.ArrayList;


public class Graph {
    File input = new File("C:\\Users\\Delara Forghani\\Desktop\\Input.txt");
    ArrayList<GraphEdge> graph = new ArrayList<>();
    ArrayList<Node> adjacencyList = new ArrayList<>();


    public Graph() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(input));
        String line;
        while ((line = reader.readLine()) != null) {
            String vertices[] = line.split(" ");
            Node vertex1 = new Node(Integer.parseInt(vertices[0]), 0);
            Node vertex2 = new Node(Integer.parseInt(vertices[1]), 0);
            GraphEdge graphEdge = new GraphEdge(vertex1, vertex2);
            graph.add(graphEdge);
            ArrayList<Integer> checkExistance = checkExistance(graphEdge);
            for (int i = 0; i < adjacencyList.size(); i++) {
                if (adjacencyList.get(i).getNodeNum() == graphEdge.getVertex1().getNodeNum()) {
                    if (checkExistance.get(1) == -1) {
                        //int index = adjacencyList.indexOf(graphEdge.getVertex2());
                        adjacencyList.get(i).neighborAdding(graphEdge.getVertex2());
                    } else {
                        adjacencyList.get(i).neighborAdding(adjacencyList.get(checkExistance.get(1)));
                    }
                } else if (adjacencyList.get(i).getNodeNum() == graphEdge.getVertex2().getNodeNum()) {
                    if (checkExistance.get(0) == -1) {
                        //int index = adjacencyList.indexOf(graphEdge.getVertex1());
                        adjacencyList.get(i).neighborAdding(graphEdge.getVertex1());
                    } else {
                        adjacencyList.get(i).neighborAdding(adjacencyList.get(checkExistance.get(0)));
                    }
                }
            }
        }
//        for (int i = 0; i < graph.size(); i++) {
//            System.out.println(graph.get(i).getVertex1() + " " + graph.get(i).getVertex2());
//        }
            for (int i = 0; i < adjacencyList.size(); i++) {
                System.out.print(adjacencyList.get(i).getNodeNum() + ":" + " ");

                for (int j = 0; j < adjacencyList.get(i).adjacentNodes.size(); j++) {
                    System.out.print(adjacencyList.get(i).adjacentNodes.get(j).getNodeNum() + " ");
                }
                System.out.println();
            }
        }


        public ArrayList<Integer> checkExistance (GraphEdge edge){
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
                adjacencyList.add( edge.getVertex1());
            }
            if (secondVertexCheck) {
                result.set(1, secondVertexPlace);
            } else if (!secondVertexCheck) {
                adjacencyList.add (edge.getVertex2());
            }
            return result;
        }

        public ArrayList<Node> getAdjacencyList () {
            return adjacencyList;
        }


    }
