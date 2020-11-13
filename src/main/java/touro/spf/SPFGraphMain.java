package touro.spf;

public class SPFGraphMain {
    public static void main(String[] args) {
        Graph graph = new Graph();
        SPFGraphView view = new SPFGraphView(graph);
        new GraphFrame(view,graph).setVisible(true);
    }
}
