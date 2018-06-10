package ceit.aut.ac.ir;

import java.util.ArrayList;

public class PaintingNodes {
    ArrayList<Node> graphNodes;

    public PaintingNodes(ArrayList<Node> nodes) {
        graphNodes = nodes;

    }

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

    public boolean checkAllcolored() {
        for (int i = 0; i < graphNodes.size(); i++) {
            if(graphNodes.get(i).getNodeColor()==0){
                return false;
            }
        }
        return true;
    }
}
