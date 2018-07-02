package ceit.aut.ac.ir;

/**
 * The class GraphEdge is to keep features of the edges of the graph like their vertices
 */
public class GraphEdge {
    private Node vertex1;
    private Node vertex2;

    public GraphEdge(Node firstVertex, Node secondVertex) {
        vertex1 = firstVertex;
        vertex2 = secondVertex;
    }
    public Node getVertex1(){
        return vertex1;
    }
    public Node getVertex2(){
        return vertex2;
    }
}
