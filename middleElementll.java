public class middleElementll {
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Node middleNode() {
        return helper(head, head);
    }

    private Node helper(Node slow, Node fast) {
        if (fast == null || fast.next == null) {
            return slow;
        }
        return helper(slow.next, fast.next.next);
    }


    public void printFromMiddleToEnd() {
        Node middle = middleNode();
        Node current = middle;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        middleElementll list = new middleElementll();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.print("Linked List: ");
        list.printList();

        Node middle = list.middleNode();
        System.out.println("Middle Element: " + middle.data);

        System.out.print("List from Middle to End: ");
        list.printFromMiddleToEnd();
        
    }
}
