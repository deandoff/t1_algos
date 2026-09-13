package org.example.algos_1;

public class Main {
    public static void main(String[] args) {
        return;
    }

    private static void connect(Node a, Node b, int bandwidth, int loss) {
        a.connect(b, bandwidth, loss);
        b.connect(a, bandwidth, loss);
    }

    public static Edge[][] matrixNet() {
        Edge[][] graph = new Edge[6][];
        graph[0] = new Edge[]{
                new Edge(1,1500,90),
                new Edge(2,2000,10),
                new Edge(3,1000,50)
        };
        graph[1] = new Edge[]{
                new Edge(0,1500,90),
                new Edge(5,1500,60)
        };
        graph[2] = new Edge[]{
                new Edge(0,2000,10),
                new Edge(4,900,5),
                new Edge(5,500,20)
        };
        graph[3] = new Edge[]{
                new Edge(0,1000,50),
                new Edge(4,2500,1)
        };
        graph[4] = new Edge[]{
                new Edge(2,900,5),
                new Edge(3,2500,1),
                new Edge(5,300,85)
        };
        graph[5] = new Edge[]{
                new Edge(1,1500,60),
                new Edge(2,500,20),
                new Edge(4,300,85)
        };
        return graph;
    }

    public static Node nodesNet() {
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");

        connect(A,B,1500,90);
        connect(A,C,2000,10);
        connect(A,D,1000,50);

        connect(B,F,1500,60);

        connect(C,F,500,20);
        connect(C,E,900,5);

        connect(D,E,2500,1);

        connect(E,F,300,85);

        return A;
    }
}
