package ceit.aut.ac.ir;

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
