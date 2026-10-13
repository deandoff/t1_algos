package org.example.task10;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        Map<String, List<String>> result = Files.lines(Path.of("input.txt"))
                .parallel()
                .map(String::trim)
                .filter(line -> line.matches(".+\\s+\\d+"))
                .map(line -> line.split("\\s+"))
                .collect(Collectors.groupingBy(
                        parts -> parts[1],
                        Collectors.mapping(
                                parts -> {
                                    String name = parts[0].toLowerCase();
                                    return name.substring(0, 1).toUpperCase()
                                            + name.substring(1);
                                },
                                Collectors.toList()
                        )
                ));

        System.out.println(result);
    }
}
