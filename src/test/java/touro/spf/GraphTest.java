package touro.spf;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GraphTest {

    @Test
    public void findSPF() {
        //given
        Graph graph = new Graph();

        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();

        List<Node> n1c = new ArrayList<>();
        n1c.add(n2);
        n1c.add(n3);

        List<Node> n2c = new ArrayList<>();
        n2c.add(n1);
        n2c.add(n3);

        List<Node> n3c = new ArrayList<>();
        n3c.add(n1);
        n3c.add(n2);
        n3c.add(n4);

        List<Node> n4c = new ArrayList<>();
        n4c.add(n3);

        n1.name = "1";
        n1.connections = n1c;
        n2.name = "2";
        n2.connections = n2c;
        n3.name = "3";
        n3.connections = n3c;
        n4.name = "4";
        n4.connections = n4c;

        HashSet<Node> nodes = new HashSet<>();
        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        nodes.add(n4);

        graph.buildGraph(nodes);

        //when
        String spf = graph.findSPF();

        //then
        assertEquals(spf, "SPF 3 leaves 2 subgraphs\n");
    }
}
