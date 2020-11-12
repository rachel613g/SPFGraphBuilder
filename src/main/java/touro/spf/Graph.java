package touro.spf;

import java.util.HashSet;

public class Graph {
    private HashSet<Node> nodes = new HashSet<>();

    public String findSPF() {
        StringBuilder solution = new StringBuilder();
        for (Node currentSuspect : nodes) {
            int subgraphs = getNodesSubgraphs(currentSuspect);
            if (subgraphs > 1) {
                solution.append("SPF " + currentSuspect + " leaves " + subgraphs + " subgraphs\n");
            }
        }

        return solution.length() == 0 ? "No SPF Nodes" : solution.toString();
    }

    private int getNodesSubgraphs(Node currentSuspect) {
        //make a hashset of all nodes except the one we are currently testing for SPF
        HashSet<Node> notYetSeen = new HashSet<>(nodes);
        notYetSeen.remove(currentSuspect);

        int subgraphs = 0;
        while (!notYetSeen.isEmpty()) {
            //arbitrary node taken to start our subgraph search
            Node starter = notYetSeen.iterator().next();
            notYetSeen.remove(starter);

            checkChildren(starter, notYetSeen);
            subgraphs++;
        }

        return subgraphs;
    }

    private void checkChildren(Node node, HashSet<Node> notYetSeen) {
        //TODO: potentially getConnections
        for (Node connection : node.connections) {
            if (notYetSeen.contains(connection)) {
                notYetSeen.remove(connection);
                checkChildren(connection, notYetSeen);
            }
        }
    }
}
