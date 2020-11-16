package touro.spf;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

public class SPFGraphView extends JComponent {

    Graph graph;
    private int WIDTH_HEIGHT = 50;

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
        HashSet<Node> nodes = new HashSet<>();

        for(Node node: nodes) {
            g.setColor(Color.BLACK);
            //plot nodes
            g.fillOval(getNodeX(),getNodeY(),WIDTH_HEIGHT,WIDTH_HEIGHT);

            //find node's connection and draw line between the 2 nodes
            for(Node connection : node.connections) {
                g.drawLine(getNodeX(),getNodeY(),getNodeX() + 20, getNodeY() + 20);
            }

            //if this node is the SPF, color it a diff color
            if(graph.getSPFNodes().contains(node)) {
                g.setColor(Color.CYAN);
                g.fillOval(getNodeX(),getNodeY(),WIDTH_HEIGHT,WIDTH_HEIGHT);
            }
        }
    }

    private int getNodeX() {
        int x = 50;
        //while there are still more nodes
//        while () {
//          //move the x position of that node to the right
//
//        }
        return x;
    }

    private int getNodeY() {
        int y = 50;
        return y;
    }
}
