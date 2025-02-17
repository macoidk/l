public class HashTableLevel2 {
    protected Square[] table;
    protected int size;
    private static final double A = (Math.sqrt(5) - 1) / 2;

    public HashTableLevel2(int size) {
        this.size = size;
        this.table = new Square[size];
    }

    private int hash(double key) {
        double temp = key * A;
        double frac = temp - Math.floor(temp);
        return (int) (size * frac);
    }

    // Insert with quadratic probing
    public boolean insert(Square square) {
        int initialIndex = hash(square.getArea());
        int index = initialIndex;
        int i = 0;

        int searchIndex = initialIndex;
        int searchAttempt = 0;
        
        while (table[searchIndex] != null) {
            if (Math.abs(table[searchIndex].getArea() - square.getArea()) < 0.0001 &&
                Math.abs(table[searchIndex].getPerimeter() - square.getPerimeter()) < 0.0001) {
                return false; // Елемент вже існує
            }
            
            searchAttempt++;
            searchIndex = (initialIndex + searchAttempt * searchAttempt) % size;
            
            if (searchAttempt >= size) {
                break;
            }
        }

        while (table[index] != null) {
            i++;
            index = (initialIndex + i * i) % size; // Quadratic probing

            if (i >= size) {
                return false; // Table is full or can't resolve collision
            }
        }

        table[index] = square;
        return true;
    }

    public void display() {
        System.out.println("\nHash Table Contents (with quadratic probing):");
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
