package queue_interfaces_problems;

public class CircularBuffer {
    private int[] buffer;
    private int size, front, rear, count;

    public CircularBuffer(int size) {
        this.size = size;
        buffer = new int[size];
        front = 0;
        rear = -1;
        count = 0;
    }

    // Insert an element (overwrites oldest if full)
    public void insert(int value) {
        rear = (rear + 1) % size;
        buffer[rear] = value;

        if (count < size) {
            count++;
        } else {
            front = (front + 1) % size; // Overwrite the oldest
        }
    }

    // Retrieve buffer contents
    public void display() {
        System.out.print("Buffer: [");
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[(front + i) % size] + (i < count - 1 ? ", " : ""));
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);

        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.display(); // Output: [1, 2, 3]

        cb.insert(4); // Overwrites 1
        cb.display(); // Output: [2, 3, 4]

        cb.insert(5); // Overwrites 2
        cb.display(); // Output: [3, 4, 5]
    }
}
