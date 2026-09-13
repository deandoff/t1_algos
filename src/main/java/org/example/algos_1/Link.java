package org.example.algos_1;

public class Link {
    Node target;
    int brandwidth;
    int loss;

    Link next;

    Link(Node target, int brandwidth, int loss) {
        this.target = target;
        this.brandwidth = brandwidth;
        this.loss = loss;
    }
}
