package touro.spf;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class SPFGraphView extends JComponent {

    Graph graph;
    private static final int WIDTH_HEIGHT = 20;
    private int x;
    private static final int y = 250;

    public SPFGraphView(Graph graph) {
        this.graph = graph;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintGraph(g);
    }

    private void paintGraph(Graphics g) {
        //will need the graph or all nodes from Graph class
        HashSet<Node> nodes = graph.getAllNodes();
        HashMap<Node, Integer> nodeMap = new HashMap<>();
        HashSet<Node> spfs = graph.getSPFNodes();

        for (Node node : nodes) {
            //increment x value of each node
            x += 50;
            //save x value to use it for drawing the arc
            nodeMap.put(node, x);
            //plot nodes
            g.setColor(Color.BLACK);
            g.fillOval(x, y, WIDTH_HEIGHT, WIDTH_HEIGHT);
            g.drawString(node.getName(), x, y);

            //drawArc between each point
            for (Node connection : node.getConnections()) {
                if(nodeMap.containsKey(connection)) {
                    int goalX = nodeMap.get(connection);
                    g.drawArc(goalX + ((WIDTH_HEIGHT)/2), y - 2*WIDTH_HEIGHT, x - goalX,100,0, 180);
                }
            }

            //if this node is the SPF, color it a diff color
            if (spfs.contains(node)) {
                g.setColor(Color.CYAN);
                g.fillOval(x, y, WIDTH_HEIGHT, WIDTH_HEIGHT);
            }
        }
    }
}
