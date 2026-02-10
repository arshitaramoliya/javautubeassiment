// Singly Linked List — manual implementation
public class LinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; this.next = null; }
    }

    private Node head;

    public void add(int data) {
        Node node = new Node(data);
        if (head == null) { head = node; return; }
        Node cur = head;
        while (cur.next != null) cur = cur.next;
        cur.next = node;
    }

    public void remove(int data) {
        if (head == null) return;
        if (head.data == data) { head = head.next; return; }
        Node cur = head;
        while (cur.next != null && cur.next.data != data) cur = cur.next;
        if (cur.next != null) cur.next = cur.next.next;
    }

    public void print() {
        Node cur = head;
        while (cur != null) { System.out.print(cur.data + " -> "); cur = cur.next; }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(10); list.add(20); list.add(30);
        list.print(); // 10 -> 20 -> 30 -> null
        list.remove(20);
        list.print(); // 10 -> 30 -> null
    }
}
