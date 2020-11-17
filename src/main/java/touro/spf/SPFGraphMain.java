package touro.spf;

import java.io.FileNotFoundException;

public class SPFGraphMain {
    public static void main(String[] args) {
        try {
            Graph graph = new Graph();
            InputManager inputManager = new InputManager(args[0], graph);

            SPFGraphView view = new SPFGraphView(graph);
            new GraphFrame(view,graph).setVisible(true);

            System.out.println(graph.getSPFString());
        } catch (FileNotFoundException e) {
            System.out.println("Error: No input file found.");
        }
    }
}
