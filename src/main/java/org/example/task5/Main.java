package org.example.task5;

import java.util.*;

public class Main {

    // Задание 1
    public static int[][] adjacencyMatrixToEdges(int[][] matrix) {
        int n = matrix.length;
        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    edges.add(new int[]{i + 1, j + 1});
                }
            }
        }

        return edges.toArray(new int[0][]);
    }

    // Задание 2
    public static int[] topologicalSort(int[][] matrix) {
        int n = matrix.length;
        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    inDegree[j]++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] result = new int[n];
        int index = 0;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            result[index++] = vertex + 1;

            for (int j = 0; j < n; j++) {
                if (matrix[vertex][j] == 1) {
                    inDegree[j]--;

                    if (inDegree[j] == 0) {
                        queue.add(j);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 0}
        };

        // Задание 1
        int[][] edges = adjacencyMatrixToEdges(matrix);

        System.out.println("Список ребер:");
        for (int[] edge : edges) {
            System.out.println(edge[0] + " -> " + edge[1]);
        }

        // Задание 2
        int[] sorted = topologicalSort(matrix);

        System.out.println("\nТопологическая сортировка:");
        System.out.println(Arrays.toString(sorted));
    }
}
