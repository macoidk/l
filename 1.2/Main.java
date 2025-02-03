import java.util.Random;

public class Main {
    private static final Random random = new Random();

    // Generate random point within range
    private static Point generateRandomPoint(double minX, double maxX, double minY, double maxY) {
        return new Point(
                minX + random.nextDouble() * (maxX - minX),
                minY + random.nextDouble() * (maxY - minY)
        );
    }

    // Generate valid square with random points
    private static Square generateRandomSquare() {
        // Generate base point (bottom-left corner)
        Point p1 = generateRandomPoint(0, 5, 0, 5);

        // Generate side length between 1 and 3
        double sideLength = 1 + random.nextDouble() * 2;

        // Calculate other points in clockwise order to form a perfect square
        // p2 - bottom-right
        // p3 - top-right
        // p4 - top-left
        Point p2 = new Point(p1.x + sideLength, p1.y);
        Point p3 = new Point(p1.x + sideLength, p1.y + sideLength);
        Point p4 = new Point(p1.x, p1.y + sideLength);

        // Create square and validate
        try {
            return new Square(p1, p2, p3, p4);
        } catch (IllegalArgumentException e) {
            // If validation fails, try again with simpler coordinates
            p1 = new Point(0, 0);
            p2 = new Point(sideLength, 0);
            p3 = new Point(sideLength, sideLength);
            p4 = new Point(0, sideLength);
            return new Square(p1, p2, p3, p4);
        }
    }

    public static void main(String[] args) {
        // Level 1 demonstration
        System.out.println("=== Level 1 Demonstration ===");
        HashTableLevel1 hashTable1 = new HashTableLevel1(10);

        // Insert squares without collisions
        for (int i = 0; i < 9; i++) {
            Square square;
            int attempts = 0;
            boolean inserted = false;

            while (!inserted && attempts < 10) {
                square = generateRandomSquare();
                inserted = hashTable1.insert(square);
                attempts++;
            }

            if (!inserted) {
                System.out.printf(" ", i + 1, attempts);
            }
        }
        hashTable1.display();

        // Level 2 demonstration
        System.out.println("\n=== Level 2 Demonstration ===");
        HashTableLevel2 hashTable2 = new HashTableLevel2(10);

        // Insert squares with possible collisions
        for (int i = 0; i < 9; i++) {
            Square square = generateRandomSquare();
            boolean inserted = hashTable2.insert(square);
            if (!inserted) {
                System.out.printf("Failed to insert square %d due to unresolved collision%n", i + 1);
            }
        }
        hashTable2.display();

        // Level 3 demonstration
        System.out.println("\n=== Level 3 Demonstration ===");
        HashTableLevel3 hashTable3 = new HashTableLevel3(10);

        // Insert squares
        for (int i = 0; i < 9; i++) {
            Square square = generateRandomSquare();
            hashTable3.insert(square);
        }

        System.out.println("Initial hash table:");
        hashTable3.display();


        hashTable3.removeElementsWithAreaGreaterThan(5.0);
        System.out.println("\nAfter removing elements with area > 5:");
        hashTable3.display();
    }
}