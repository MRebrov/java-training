package Advantum;

import java.util.HashSet;

public class SixthTask {

    public static void main(String[] args) {
        Node node1 = new Node();
        node1.value = "node1";
        Node node2 = new Node();
        node2.value = "node2";
        Node node3 = new Node();
        node3.value = "node3";
        Node node4 = new Node();
        node4.value = "node4";
        node1.linkedNodes = new HashSet<>();
        node1.linkedNodes.add(node2);
        node1.linkedNodes.add(node3);
        node2.linkedNodes = new HashSet<>();
        node2.linkedNodes.add(node1);
        node3.linkedNodes = new HashSet<>();
        node3.linkedNodes.add(node1);
        node3.linkedNodes.add(node4);
        node4.linkedNodes = new HashSet<>();
        node4.linkedNodes.add(node3);
        Node node1Copied = node1.copyGraph(node1);
        System.out.println(node1.equals(node1Copied.copiedFrom));
        node1Copied.linkedNodes.forEach(System.out::println);
        node1Copied.linkedNodes.forEach(x -> x.linkedNodes.forEach(System.out::println));
    }

}
