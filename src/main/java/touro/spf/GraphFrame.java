package touro.spf;

import javax.swing.*;
import java.awt.*;

public class GraphFrame extends JFrame {
    private Graph graph;
    private SPFGraphView view;

    public GraphFrame(SPFGraphView view, Graph graph) {
        this.view = view;
        this.graph = graph;

        setSize(420, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("SPF Graph");
        setLayout(new BorderLayout());

        add(view);
    }
}
