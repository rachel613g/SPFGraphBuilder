package touro.spf;

import java.util.List;

public class Node {
    private String name;
    private List<Node> connections;

    public Node(String name, List<Node> connections) {
        this.name = name;
        this.connections = connections;
    }

    public String getName() {
        return name;
    }

    public List<Node> getConnections() {
        return connections;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addConnection(Node connection) {
        this.connections.add(connection);
    }

    public boolean isConnection(Node connection){
        return connections.contains(connection);
    }
}
