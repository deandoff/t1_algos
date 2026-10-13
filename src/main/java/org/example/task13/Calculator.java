package org.example.task13;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;

// MODEL
class CalculatorModel {
    private final Map<String, BiFunction<Integer, Integer, Integer>> operations =
            new HashMap<>();

    public CalculatorModel() {
        operations.put("+", Integer::sum);
        operations.put("-", (a, b) -> a - b);
        operations.put("*", (a, b) -> a * b);
        operations.put("/", (a, b) -> {
            if (b == 0) {
                throw new ArithmeticException("Деление на ноль");
            }
            return a / b;
        });
    }

    public int calculate(int a, int b, String operation) {
        BiFunction<Integer, Integer, Integer> function =
                operations.get(operation);

        if (function == null) {
            throw new IllegalArgumentException(
                    "Неизвестная операция: " + operation);
        }

        return function.apply(a, b);
    }
}

// VIEWMODEL
class CalculatorViewModel {
    private final CalculatorModel model;
    private Consumer<String> resultListener = result -> {};

    public CalculatorViewModel(CalculatorModel model) {
        this.model = model;
    }

    public void setResultListener(Consumer<String> listener) {
        this.resultListener = listener;
    }

    public void calculate(int a, int b, String operation) {
        try {
            int result = model.calculate(a, b, operation);
            resultListener.accept("Результат: " + result);
        } catch (RuntimeException e) {
            resultListener.accept("Ошибка: " + e.getMessage());
        }
    }
}

// VIEW
class CalculatorView {
    private final Consumer<String> commandSender;

    public CalculatorView(Consumer<String> commandSender) {
        this.commandSender = commandSender;
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int a = scanner.nextInt();

        System.out.print("Введите операцию (+, -, *, /): ");
        String operation = scanner.next();

        System.out.print("Введите второе число: ");
        int b = scanner.nextInt();

        commandSender.accept(a + ";" + operation + ";" + b);
    }
}

public class Calculator {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorViewModel viewModel =
                new CalculatorViewModel(model);

        CalculatorView view = new CalculatorView(command -> {
            String[] parts = command.split(";");
            int a = Integer.parseInt(parts[0]);
            String operation = parts[1];
            int b = Integer.parseInt(parts[2]);

            viewModel.calculate(a, b, operation);
        });

        viewModel.setResultListener(view::showMessage);

        view.start();
    }
}
