package touro.spf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;

public class InputManager {

    private final Scanner scanner;
    private ArrayList<String> eachLine = new ArrayList<>();
    private HashSet<String> nodeNameNotYetSeen = new HashSet<>();
    private ArrayList<Node> nodes = new ArrayList<>();

    public InputManager(String fileName) throws FileNotFoundException {
        scanner = new Scanner(new FileInputStream(fileName));
        readFile();
    }

    private void readFile() {
        while (scanner.hasNextLine()) {
            String next = scanner.nextLine();
            while (!next.equals("0")) {
                eachLine.add(next);
                next = scanner.nextLine();
            }
            for (String strLine : eachLine) {
                String[] strNum = strLine.split(" ");
                for (String str : strNum) {
                    nodeNameNotYetSeen.add(str);
                }
            }
            setNodesBuildGraph();
            eachLine.clear();
            nodeNameNotYetSeen.clear();
            nodes.clear();
        }
    }

    private void setNodesBuildGraph() {
            for (String strNodeNum : nodeNameNotYetSeen) {
                nodes.add(new Node(strNodeNum, new ArrayList<>()));
            }
            for (Node node : nodes){
                for (String eachLine: eachLine){
                    if (eachLine.contains(node.name))
                    {
                        //retrieve node number from eachLine string that it corresponds to
                        String[] strNum = eachLine.split(" ");
                        for (String str : strNum) {
                            if(!str.equals(node.name)){
                                //and add it node's connections
                                for (Node connection : nodes){
                                    if(node.name.contains(str)){
                                        node.addConnection(connection);
                                    }
                                }
                            }
                        }
                    }
                }
            }
    }

    private void setNodeChildren() {
        for (Node node : nodes) {

        }
    }
}

/*
                String next = scanner.nextLine();
                String[] tmp = next.split(" ");
                ArrayList<Node> nodes = new ArrayList<>();
                Hashtable<String, Integer> seenNodes = new Hashtable<>();
                for (int i = 0; i < tmp.length; i++) {
                    if (!seenNodes.contains(tmp[i])) {
                        seenNodes.put(tmp[i], Integer.parseInt(tmp[i + 1]));
                        if (i + 1 == tmp.length) {
                            break;
                        }
                    }else if (){

                    }
                }

 */