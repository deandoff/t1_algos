package org.example.algos_1;

public class Node {
    String name;
    Link first;

    Node(String name) {
        this.name = name;
    }

    void connect(Node target, int brandwidth, int loss){
        Link link = new Link(target, brandwidth, loss);

        link.next = first;
        first = link;
    }
}
