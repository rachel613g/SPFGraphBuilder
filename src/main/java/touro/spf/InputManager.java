package touro.spf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;

public class InputManager {

    private final Scanner scanner;
    private ArrayList<String> eachLine = new ArrayList<>();
    private HashSet<String> nodeNameNotYetSeen = new HashSet<>();
    private HashSet<Node> nodes = new HashSet<>();

    public InputManager(String fileName) throws FileNotFoundException {
        scanner = new Scanner(new FileInputStream(fileName));
        readFile();
    }

    private void readFile() {
//        while (scanner.hasNextLine()) {
        String next = scanner.nextLine();
        while (!next.equals("0")) {
            Node node, connection;
            //an array of 2 number chars
            String[] strNumNode = next.split(" ");

            //make sure to check if already a connection

            if (nodeIsInHashSet(strNumNode[0])) {
                node = getNodeFromHashSet(strNumNode[0]);
            } else {
                node = new Node(strNumNode[0], new ArrayList<>());
                nodes.add(node);
            }
            if (nodeIsInHashSet(strNumNode[1])) {
                connection = getNodeFromHashSet(strNumNode[1]);
            } else {
                connection = new Node(strNumNode[1], new ArrayList<>());
                nodes.add(connection);
            }

            node.addConnection(connection);
            connection.addConnection(node);

            next = scanner.nextLine();
        }
//            eachLine.clear();
//            nodes.clear();
//        }
    }


    private Node getNodeFromHashSet(String nodeName) {
        Node returnNode = null;
        for (Node node : nodes) {
            if (node.name.equals(nodeName)) {
                returnNode = node;
            }
        }
        return returnNode;
    }

    /**
     * given
     *
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