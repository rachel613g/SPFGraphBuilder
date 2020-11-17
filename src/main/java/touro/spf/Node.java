package touro.spf;

import java.util.List;
import java.util.Objects;

public class Node {
    String name;
    List<Node> connections;
    public Node(String name, List<Node> connections) {
        this.name = name;
        this.connections = connections;
    }

    public void addConnection(Node connection) {
        this.connections.add(connection);
    }

    public boolean isConnection(Node connection){
        return connections.contains(connection);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return name.equals(node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
