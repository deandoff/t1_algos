package org.example.task9;


import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class OperationMaker {
    Supplier<Model> datareader;
    Consumer<Model> printer;
    Map<String, BinaryOperator<Integer>> operations = new HashMap<>();

    public OperationMaker(Container container) {
        datareader = container.get(DataReader.class);
        printer = container.get(Printer.class);

        operations.put("+", container.get(PlusOperation.class));
        operations.put("-", container.get(MinusOperation.class));
    }

    public void make() {
        Model model = datareader.get();

        model.res = operations
                .get(model.op)
                .apply(model.x, model.y);

        printer.accept(model);
    }
}