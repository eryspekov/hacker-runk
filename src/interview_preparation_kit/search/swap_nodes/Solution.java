package interview_preparation_kit.search.swap_nodes;

import java.io.*;
import java.util.*;

public class Solution {

    static int[][] swapNodes(int[][] indexes, int[] queries) {
        int numberNodes = indexes.length;
        int numberQueries = queries.length;
        int[][] res = new int[numberQueries][numberNodes];

        Node[] nodes = new Node[numberNodes + 1];
        for (int i = 1; i <= numberNodes; i++)
            nodes[i] = new Node(i);

        for (int i = 1; i <= numberNodes; i++) {
            int left = indexes[i - 1][0];
            int right = indexes[i - 1][1];
            nodes[i].left = (-1 == left) ? null : nodes[left];
            nodes[i].right = (-1 == right) ? null : nodes[right];
        }
        for (int i = 0; i < numberQueries; i++) {
            swap(queries[i], nodes[1], 1);
            initInOrder(nodes[1], res[i], 0);
        }
        return res;
    }

    static void swap(int k, Node node, int depth) {
        if (Objects.isNull(node))
            return;

        swap(k, node.left, depth + 1);
        swap(k, node.right, depth + 1);

        if (depth % k != 0)
            return;
        Node tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }

    static int initInOrder(Node node, int[] res, int i) {
        if (Objects.isNull(node))
            return i;
        i = initInOrder(node.left, res, i);
        res[i++] = node.value;
        i = initInOrder(node.right, res, i);
        return i;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}