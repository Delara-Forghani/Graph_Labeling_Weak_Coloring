package ceit.aut.ac.ir;

import java.util.ArrayList;

/**
 * This class is to colorize the graph with WeakColoring algorithm
 */
public class PaintingNodes {
    ArrayList<Node> graphNodes;


    public PaintingNodes(ArrayList<Node> nodes) {
        graphNodes = nodes;

    }

    public void sortList() {
        for (int i = 0; i < graphNodes.size(); ++i) {
            Node temp=graphNodes.get(i);
            int key = graphNodes.get(i).getLevel();
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && graphNodes.get(j).getLevel() > key) {
                graphNodes.set(j + 1, graphNodes.get(j));
                j = j - 1;
            }
            graphNodes.set(j + 1, temp);

        }
    }

    /**
     * This method runs the main process; It colorize the graph with WeakColoring algorithm
     * checks the number of existing colors against the levels of the tree in order to decide how to colorize it
     */
    public void weakColoring(int numberOfColors) {
        int colorAssign = 0;
        int maxLevel = graphNodes.get(graphNodes.size() - 1).getLevel() + 1;
        if (numberOfColors < maxLevel) {
            int start = 0;
            int thisLevel;
            while (start < graphNodes.size()) {
                int count = 0;
                thisLevel = graphNodes.get(start).getLevel();
                while (thisLevel == graphNodes.get(start + count).getLevel()) {
                    graphNodes.get(start + count).setNodeColor(colorAssign);
                    count++;
                    if (start + count > graphNodes.size() - 1) {
                        break;
                    }
                }
                colorAssign++;
                if (colorAssign >= numberOfColors) {
                    colorAssign = 0;
                }
                start = start + count;

                //while (graphNodes.get(start).getLevel() )
            }
        } else {
            int start = 0;
            int thisLevel;
            while (start < graphNodes.size()) {
                int count = 0;
                thisLevel = graphNodes.get(start).getLevel();
                while (thisLevel == graphNodes.get(start + count).getLevel()) {
                    graphNodes.get(start + count).setNodeColor(colorAssign);
                    count++;
                    if (start + count > graphNodes.size() - 1) {
                        break;
                    }
                }
                colorAssign++;
                start = start + count;
            }
        }
    }
}
