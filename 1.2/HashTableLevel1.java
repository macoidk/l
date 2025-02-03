public class HashTableLevel1 {
    private Square[] table;
    private int size;
    private static final double A = (Math.sqrt(5) - 1) / 2; // Constant for multiplication method

    public HashTableLevel1(int size) {
        this.size = size;
        this.table = new Square[size];
    }

    // Multiplication method hash function
    private int hash(double key) {
        double temp = key * A;
        double frac = temp - Math.floor(temp);
        return (int) (size * frac);
    }

    // Insert element into hash table
    public boolean insert(Square square) {
        int index = hash(square.getArea());

        if (table[index] != null) {
            return false; // Position is occupied
        }

        table[index] = square;
        return true;
    }

    // Display hash table
    public void display() {
        System.out.println("\nHash Table Contents:");
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                System.out.printf("%d: Area=%.2f, Perimeter=%.2f, %s%n",
                        i,
                        table[i].getArea(),
                        table[i].getPerimeter(),
                        table[i].toString());
            } else {
                System.out.printf("%d: Empty%n", i);
            }
        }
    }
}