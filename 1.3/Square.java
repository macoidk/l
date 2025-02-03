import java.util.Arrays;

public class Square {
    private Point[] vertices;  // Array of 4 vertices

    // Constructor that takes 4 points
    public Square(Point p1, Point p2, Point p3, Point p4) {
        vertices = new Point[]{p1, p2, p3, p4};
        if (!isValidSquare()) {
            throw new IllegalArgumentException("Points do not form a valid square");
        }
    }

    // Method to validate if points form a square
    private boolean isValidSquare() {
        if (vertices == null || vertices.length != 4) {
            return false;
        }

        // Calculate all distances between points
        double[] distances = new double[6];
        int idx = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                distances[idx++] = distance(vertices[i], vertices[j]);
            }
        }

        // Sort distances
        Arrays.sort(distances);

        // In a square:
        // - First 4 distances should be equal (sides)
        // - Last 2 distances should be equal (diagonals)
        // - Diagonals should be longer than sides
        // Add small epsilon for floating point comparison
        double epsilon = 1e-10;
        return Math.abs(distances[0] - distances[1]) < epsilon &&
                Math.abs(distances[1] - distances[2]) < epsilon &&
                Math.abs(distances[2] - distances[3]) < epsilon &&
                Math.abs(distances[4] - distances[5]) < epsilon &&
                distances[3] < distances[4];
    }

    // Calculate distance between two points
    private double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }

    // Calculate area
    public double getArea() {
        // Area is side length squared
        return Math.pow(distance(vertices[0], vertices[1]), 2);
    }

    // Calculate perimeter
    public double getPerimeter() {
        return 4 * distance(vertices[0], vertices[1]);
    }

    @Override
    public String toString() {
        return String.format("Square[vertices=(%,.2f,%,.2f),(%,.2f,%,.2f),(%,.2f,%,.2f),(%,.2f,%,.2f)]",
                vertices[0].x, vertices[0].y,
                vertices[1].x, vertices[1].y,
                vertices[2].x, vertices[2].y,
                vertices[3].x, vertices[3].y);
    }
}