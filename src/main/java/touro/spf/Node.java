package touro.spf;

import java.util.List;

public class Node {
    String name;
    List<Node> connections;
    public Node(String name, List<Node> connections) {
        this.name = name;
        this.connections = connections;
    }
}
