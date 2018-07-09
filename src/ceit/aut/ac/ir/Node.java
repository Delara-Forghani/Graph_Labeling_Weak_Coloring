package ceit.aut.ac.ir;

import java.util.ArrayList;

/**
 * This class with its getter and setter methods is to keep and manipulate
 * features of a vertex like its name , color and level in the BFS tree
 */
public class Node {
    private int nodeNum;
    private int nodeColor;
    public int level;
    public ArrayList<Node> adjacentNodes;

    public Node(int number) {
        nodeNum = number;
        nodeColor = 0;
        level = 0;
        adjacentNodes = new ArrayList<>();
    }


    public void setLevel(int level) {
        this.level = level;
    }

    public void setNodeColor(int color) {
        nodeColor = color;
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

    public int getLevel() {
        return level;
    }
}
