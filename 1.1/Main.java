public class Main {
    public static void main(String[] args) {
        // Level 1
        System.out.println("first level");
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.display();

        System.out.println("Видаляємо два елементи:");
        queue.dequeue();
        queue.dequeue();
        queue.display();

        // Level 2
        System.out.println("\n second level:");
        LinkedList list = new LinkedList();
        list.add("1010"); // 10
        list.add("1011"); // 11
        list.insert(2,"1100"); // 12
        list.insert(3,"1101"); // 13
        list.display();

        System.out.println("Видаляємо елемент");
        list.remove("1010");
        list.display();

        // Level 3
        System.out.println("\n third level:");
        LinkedList sourceList = new LinkedList();
        ArrayQueue resultQueue = new ArrayQueue();

        sourceList.add("1010");
        sourceList.add("1011");
        sourceList.add("1100");
        sourceList.add("1101");

        System.out.println("Початковий список:");
        sourceList.display();

        TaskProcessor.processLists(sourceList, resultQueue);

        System.out.println("Результуюча черга (непарні числа в десятковій системі):");
        resultQueue.display();
    }
}
