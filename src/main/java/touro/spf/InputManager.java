package touro.spf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Creates Node instances using data from input file. Passes
 * the Nodes to graph.
 */

public class InputManager {

    private final Scanner scanner;
    private Graph graph;
    private HashSet<Node> nodes = new HashSet<>();

    public InputManager(String fileName, Graph graph) throws FileNotFoundException {
        scanner = new Scanner(new FileInputStream(fileName));
        this.graph = graph;
        readFile();
    }

    private void readFile() {
//        while (scanner.hasNextLine()) {
        String next = scanner.nextLine();
        while (!next.equals("0")) {
            Node node, connection;

            //an array of number chars and of length two
            String[] strNumNode = next.split(" ");

            //TODO: input validation. make sure only two numbers per line.

            //check if node is in hash already
            if (nodeIsInHashSet(strNumNode[0])) {
                node = getNodeFromHashSet(strNumNode[0]);
            } else {
                //make new node, add to hash
                node = new Node(strNumNode[0], new ArrayList<>());
                nodes.add(node);
            }

            //check if connection is in hash already
            if (nodeIsInHashSet(strNumNode[1])) {
                connection = getNodeFromHashSet(strNumNode[1]);
            } else {
                connection = new Node(strNumNode[1], new ArrayList<>());
                nodes.add(connection);
            }

            //check that node and connection are not connections of one
            // another already
            if(!node.isConnection(connection)){
                node.addConnection(connection);
            }
            if(!connection.isConnection(node)){
                connection.addConnection(node);
            }
            next = scanner.nextLine();
        }
//            eachLine.clear();
//            nodes.clear();
//        }
        graph.buildGraph(nodes);
    }

    private Node getNodeFromHashSet(String nodeName) {

        for (Node node : nodes) {
            if (node.name.equals(nodeName)) {
                return node;
            }
        } return null;
    }

    /**
     * given
     * @param nodeName - String name of node
     * @return boolean if node exists in Hashset of nodes.
     */
    private boolean nodeIsInHashSet(String nodeName) {
        for (Node node : nodes) {
            if (node.name.equals(nodeName)) {
                return true;
            }
        }
        return false;
    }
}