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

    /**
     * This method runs the main process; It colorize the graph with WeakColoring algorithm
     */
    public void weakColoring() {
        boolean allColored = false;
        boolean[] tmpArray = new boolean[graphNodes.size()];
        while (!allColored) {
            for (int i = 0; i < graphNodes.size(); i++) {
                if (graphNodes.get(i).getNodeColor() == 0) {
                    for (int j = 0; j < tmpArray.length; j++) {
                        tmpArray[j] = false;
                    }
                    for (int j = 0; j < graphNodes.get(i).adjacentNodes.size(); j++) {
                        if (graphNodes.get(i).adjacentNodes.get(j).getNodeColor() != 0) {
                            tmpArray[graphNodes.get(i).adjacentNodes.get(j).getNodeColor() - 1] = true;
                        }
                    }
                    for (int j = 0; j < tmpArray.length; j++) {
                        if (!tmpArray[j]) {
                            graphNodes.get(i).setNodeColor(j + 1);
                            break;
                        }
                    }
                }
            }
            allColored=checkAllcolored();
        }
    }

    /**
     * Yhis method checks whether all the nodes are colorized or not
     * @return
     */
    public boolean checkAllcolored() {
        for (int i = 0; i < graphNodes.size(); i++) {
            if(graphNodes.get(i).getNodeColor()==0){
                return false;
            }
        }
        return true;
    }
}
