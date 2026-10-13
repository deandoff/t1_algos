package org.example.task9;

import java.util.function.Consumer;

public class Printer implements Consumer<Model> {
    @Override
    public void accept(Model model) {
        System.out.println(model.x + model.op + model.y + "=" + model.res);
    }
}
