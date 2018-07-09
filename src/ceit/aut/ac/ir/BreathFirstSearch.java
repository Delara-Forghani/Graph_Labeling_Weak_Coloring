package ceit.aut.ac.ir;

import java.util.ArrayList;
import java.util.LinkedList;

public class BreathFirstSearch {
    ArrayList<Node> adjacencyList = new ArrayList<>();

    /**
     * gets adjacency matrix and calls BFS method
     * @param list
     */

    public BreathFirstSearch(ArrayList<Node> list) {
        adjacencyList = list;
        BFS(adjacencyList.get(0));
    }

    /**
     * BFS traversal in the graph starting from root
     * Assigning a level to each node
     * @param root
     */
    public void BFS(Node root) {
        boolean visited[] = new boolean[adjacencyList.size() + 1];
        LinkedList<Node> queue = new LinkedList<>();
        visited[root.getNodeNum()] = true;
        queue.add(root);

        System.out.println("*******");
        while (queue.size() != 0) {
            root = queue.poll();
            System.out.print(root.getNodeNum() + " " + root.getLevel() + "\n");
            for (int i = 0; i < adjacencyList.size(); i++) {
                if (adjacencyList.get(i).getNodeNum() == root.getNodeNum()) {
                    for (int j = 0; j < root.adjacentNodes.size(); j++) {
                        if (!visited[root.adjacentNodes.get(j).getNodeNum()]) {
                            visited[root.adjacentNodes.get(j).getNodeNum()] = true;
                            root.adjacentNodes.get(j).setLevel(root.getLevel() + 1);
                            queue.add(root.adjacentNodes.get(j));
                        }
                    }
                }
            }
        }

    }

}
