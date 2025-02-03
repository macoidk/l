public class LinkedList {
    private Node head;

    private class Node {
        String data;
        Node next; //pointer to the next element

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(String data) {
        if (!BinaryValidator.isValidBinary(data)) {
            throw new IllegalArgumentException("Invalid binary number");
        }

        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }


    public void insert(int index, String data) {
        if (!BinaryValidator.isValidBinary(data)) {
            throw new IllegalArgumentException("Invalid binary number");
        }

        Node newNode = new Node(data);

        // If inserting at the beginning
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        // Find the position to insert
        Node current = head;
        int currentIndex = 0;

        while (current != null && currentIndex < index - 1) {
            current = current.next;
            currentIndex++;
        }

        // Check if index is out of bounds
        if (current == null) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }

        // Insert the new node
        newNode.next = current.next;
        current.next = newNode;
    }


    public void remove(String data) {
        if (head == null) return;

        if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("Список порожній");
            return;
        }

        System.out.print("Вміст списку: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void processAndFillQueue(ArrayQueue queue) {
        if (head == null) return;

        while (head != null && isEven(head.data)) {
            head = head.next;
        }

        if (head == null) return;

        Node current = head;
        while (current.next != null) {
            if (isEven(current.next.data)) {

                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        current = head;
        while (current != null) {
            int decimal = BinaryValidator.binaryToDecimal(current.data);
            queue.enqueue(decimal);
            current = current.next;
        }
    }

    private boolean isEven(String binaryNumber) {
        int decimal = BinaryValidator.binaryToDecimal(binaryNumber);
        return decimal % 2 == 0;
    }
}

