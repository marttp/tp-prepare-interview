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
        if (head == null || head.next == null)
            return false;

        Node fast = head;
        Node slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

}