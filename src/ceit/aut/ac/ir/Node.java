package ceit.aut.ac.ir;

import java.util.ArrayList;

/**
 * This class with its getter and setter methods is to keep and manipulate
 * features of a vertex like its name and color
 */
public class Node {
    private int nodeNum;
    private int nodeColor;
    public ArrayList<Node> adjacentNodes;

    public Node(int number, int color) {
        nodeNum = number;
        nodeColor = color;
        adjacentNodes = new ArrayList<>();
    }

    public void setNodeColor(int color) {
        nodeColor=color;
    }

    public void neighborAdding(Node newNode) {
        adjacentNodes.add(newNode);
    }

    public int getNodeNum() {
        return nodeNum;
    }

    public int getNodeColor() {
        return nodeColor;
    }
}
