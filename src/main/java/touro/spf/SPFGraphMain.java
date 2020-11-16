package touro.spf;

import java.io.FileNotFoundException;

public class SPFGraphMain {
    public static void main(String[] args) throws FileNotFoundException {
        if(args.length < 1) {
            throw new FileNotFoundException("Error: No input file found.");
        }
        Graph graph = new Graph();
        InputManager inputManager = new InputManager(args[0], graph);
        SPFGraphView view = new SPFGraphView(graph);
        new GraphFrame(view,graph).setVisible(true);

        System.out.println(graph.findSPF());
    }
}
