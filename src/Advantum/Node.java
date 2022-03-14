package Advantum;

import java.util.*;

public class Node {
    String value;
    Set<Node> linkedNodes;
    Node copiedFrom;

    Node copyGraph(Node someNodeOfOriginalGraph) {
        Map<Node, Node> isomorphism = new HashMap<>();
        for (Node n : someNodeOfOriginalGraph.linkedNodes) {
            someNodeOfOriginalGraph.deepCopy(isomorphism);
        }
        return isomorphism.get(someNodeOfOriginalGraph);
    }

    Node deepCopy(Map<Node, Node> isomorphism) {
        Node copy = isomorphism.get(this);
        if (copy == null) {
            copy = new Node();
            copy.value = this.value;
            copy.copiedFrom = this;
            copy.linkedNodes = new HashSet<>();
            isomorphism.put(this, copy);
            for (Node n : linkedNodes) {
                copy.linkedNodes.add(n.deepCopy(isomorphism));
            }
        }
        return copy;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + '\'' +
                ", copiedFrom=" + copiedFrom +
                '}';
    }
}
