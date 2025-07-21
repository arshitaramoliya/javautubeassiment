/**
 * Queue — FIFO data structure using circular array
 * Time complexity: enqueue O(1), dequeue O(1), peek O(1)
 */
public class Queue {
    private int[] data;
    private int front, rear, size, capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full — cannot enqueue " + value);
            return;
        }
        rear = (rear + 1) % capacity; // circular wrap
        data[rear] = value;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        int value = data[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    public int peek()      { if (isEmpty()) throw new RuntimeException("Empty"); return data[front]; }
    public boolean isEmpty() { return size == 0; }
    public boolean isFull()  { return size == capacity; }
    public int size()        { return size; }

    public void display() {
        System.out.print("Queue (front→rear): ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue q = new Queue(4);
        q.enqueue(10); q.enqueue(20); q.enqueue(30);
        q.display();
        System.out.println("Dequeue: " + q.dequeue());
        q.enqueue(40); q.enqueue(50);
        q.display();
    }
}
