package org.example.task9;

public class Start {
    public static void main(String[] args) {
        Container container = new Container();

        container.register(DataReader.class, new DataReader());
        container.register(Printer.class, new Printer());
        container.register(PlusOperation.class, new PlusOperation());
        container.register(MinusOperation.class, new MinusOperation());

        OperationMaker maker = new OperationMaker(container);

        maker.make();
    }
}
