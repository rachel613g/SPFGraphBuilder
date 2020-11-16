package touro.spf;

import java.util.List;

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
        for(Node check: connections){
            if(check.equals(connection)){
                return true;
            }
        } return false;
    }
}
