public class HashTableLevel3 extends HashTableLevel2 {
    public HashTableLevel3(int size) {
        super(size);
    }

    // Remove elements with area greater than specified value
    public void removeElementsWithAreaGreaterThan(double threshold) {
        System.out.printf("\nRemoving elements with area greater than %.2f%n", threshold);
        for (int i = 0; i < getSize(); i++) {
            Square square = getSquareAt(i);
            if (square != null && square.getArea() > threshold) {
                removeAt(i);
            }
        }
    }

    protected Square getSquareAt(int index) {
        return super.table[index];
    }

    protected void removeAt(int index) {
        super.table[index] = null;
    }

    protected int getSize() {
        return super.size;
    }
}