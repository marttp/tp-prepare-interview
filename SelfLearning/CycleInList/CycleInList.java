// 1 First approach. You can use scan and mark

public class CycleInList {

    private class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    boolean hasCycle(Node head) {
        if (head == null) return false;
        Node fast = head;
        Node slow = head;

        while (fast != null && slow != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = fast.next;
        }

        return false;
    }

}