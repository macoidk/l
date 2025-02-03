public class ArrayQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private static final int DEFAULT_CAPACITY = 2;

    public ArrayQueue() {
        queue = new int[DEFAULT_CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int element) {
        if (isFull()) {
            resize();
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = element;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int element = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public int size() {
        return size;
    }

    private void resize() {
        int[] temp = new int[queue.length * 2];
        for (int i = 0; i < size; i++) {
            temp[i] = queue[(front + i) % queue.length];
        }
        queue = temp;
        front = 0;
        rear = size - 1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Черга порожня");
            return;
        }
        System.out.print("Вміст черги: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % queue.length] + " ");
        }
        System.out.println();
    }
}