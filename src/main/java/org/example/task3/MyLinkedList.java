package org.example.task3;

import java.util.Objects;

public class MyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public static class Node<T> {
        private T value;
        private Node<T> prev;
        private Node<T> next;

        private Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    public void addLast(T value) {
        Node<T> newNode = new Node<>(value);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public void insertBefore(Node<T> node, T value) {
        checkNode(node);

        Node<T> newNode = new Node<>(value);

        newNode.next = node;
        newNode.prev = node.prev;

        if (node.prev != null) {
            node.prev.next = newNode;
        } else {
            head = newNode;
        }

        node.prev = newNode;

        size++;
    }

    public void insertAfter(Node<T> node, T value) {
        checkNode(node);

        Node<T> newNode = new Node<>(value);

        newNode.prev = node;
        newNode.next = node.next;

        if (node.next != null) {
            node.next.prev = newNode;
        } else {
            tail = newNode;
        }

        node.next = newNode;

        size++;
    }

    public boolean contains(T value) {
        Node<T> current = head;

        while (current != null) {
            if (Objects.equals(current.value, value)) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public Node<T> find(T value) {
        Node<T> current = head;

        while (current != null) {
            if (Objects.equals(current.value, value)) {
                return current;
            }

            current = current.next;
        }

        return null;
    }

    public int indexOf(T value) {
        Node<T> current = head;
        int index = 0;

        while (current != null) {
            if (Objects.equals(current.value, value)) {
                return index;
            }

            current = current.next;
            index++;
        }

        return -1;
    }

    public T removeFirst() {
        if (head == null) {
            throw new IllegalStateException("Список пуст");
        }

        T value = head.value;

        head = head.next;

        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }

        size--;

        return value;
    }

    public T removeLast() {
        if (tail == null) {
            throw new IllegalStateException("Список пуст");
        }

        T value = tail.value;

        tail = tail.prev;

        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }

        size--;

        return value;
    }

    public T remove(Node<T> node) {
        checkNode(node);

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }

        T value = node.value;

        node.prev = null;
        node.next = null;

        size--;

        return value;
    }

    public T get(Node<T> node) {
        checkNode(node);

        return node.value;
    }

    public void set(Node<T> node, T value) {
        checkNode(node);

        node.value = value;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void checkNode(Node<T> node) {
        if (node == null) {
            throw new IllegalArgumentException(
                    "Node не может быть null"
            );
        }
    }
}