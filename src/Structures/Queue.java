//package Structures;
//
//import algorithms.mazeGenerators.Position;
//
//public class Queue {
//    private Node<Position> front;
//    private Node<Position> rear;
//    private int size;
//
//    public Queue() {
//        this.front = null;
//        this.rear = null;
//        this.size = 0;
//    }
//
//    public boolean isEmpty() {
//        return front == null;
//    }
//
//    public int size() {
//        return size;
//    }
//
//    public void enqueue(Position position) {
//        Node<Position> newNode = new Node<>(position);
//        if (isEmpty()) {
//            front = newNode;
//            rear = front;
//        } else {
//            rear.next = newNode;
//            rear = newNode;
//        }
//        size++;
//    }
//
//    public Position dequeue() {
//        if (isEmpty()) {
//            throw new RuntimeException("Queue is empty");
//        }
//        Position data = front.data;
//        front = front.next;
//        if (front == null) {
//            rear = null;
//        }
//        size--;
//        return data;
//    }
//
//    public Position peek() {
//        if (isEmpty()) {
//            throw new RuntimeException("Queue is empty");
//        }
//        return front.data;
//    }
//}
//
