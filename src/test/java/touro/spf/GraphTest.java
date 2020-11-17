package touro.spf;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GraphTest {

    @Test
    public void findSPF_withSPF() {
        //given
        Graph graph = new Graph();

        List<Node> n1c = new ArrayList<>();
        List<Node> n2c = new ArrayList<>();
        List<Node> n3c = new ArrayList<>();
        List<Node> n4c = new ArrayList<>();

        Node n1 = new Node("1", n1c);
        Node n2 = new Node("2", n2c);
        Node n3 = new Node("3", n3c);
        Node n4 = new Node("4", n4c);

        n1c.add(n2);
        n1c.add(n3);

        n2c.add(n1);
        n2c.add(n3);

        n3c.add(n1);
        n3c.add(n2);
        n3c.add(n4);

        n4c.add(n3);

        n1.connections = n1c;
        n2.connections = n2c;
        n3.connections = n3c;
        n4.connections = n4c;

        HashSet<Node> nodes = new HashSet<>();
        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        nodes.add(n4);

        graph.buildGraph(nodes);

        //when
        String spf = graph.getSPFString();

        //then
        assertEquals(spf, "SPF 3 leaves 2 subgraphs\n");
    }

    @Test
    public void findSPF_withoutSPF() {
        //given
        Graph graph = new Graph();

        List<Node> n1c = new ArrayList<>();
        List<Node> n2c = new ArrayList<>();
        List<Node> n3c = new ArrayList<>();
        List<Node> n4c = new ArrayList<>();

        Node n1 = new Node("1", n1c);
        Node n2 = new Node("2", n2c);
        Node n3 = new Node("3", n3c);
        Node n4 = new Node("4", n4c);

        n1c.add(n2);
        n2c.add(n1);

        n2c.add(n3);
        n3c.add(n2);

        n3c.add(n4);
        n4c.add(n3);

        n4c.add(n1);
        n1c.add(n4);

        n1.connections = n1c;
        n2.connections = n2c;
        n3.connections = n3c;
        n4.connections = n4c;

        HashSet<Node> nodes = new HashSet<>();
        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        nodes.add(n4);

        graph.buildGraph(nodes);

        //when
        String spf = graph.getSPFString();

        //then
        assertEquals(spf, "No SPF Nodes");
    }
}
