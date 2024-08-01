package dsa.linkedLists;

public class DLL {

    private Node head;
    private int size;

    public DLL(){
        this.size = 0;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head != null){
            head.prev = node;
        }
        head = node;
        size++;
    }

    public void insertLast(int val){
        if(head == null){
            insertFirst(val);
            return;
        }
        Node last = get(size - 1);
        Node node = new Node(val, null, last);
        last.next = node;
        size++;
    }

    public void insert(int after, int val){
        Node p = find(after);
        if(p == null){
            System.out.println("Doesn't exist!");
            return;
        }
        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if(node.next != null){
            node.next.prev = node;
        }

    }

    private Node find(int val){
        Node temp = head;
        while(temp != null){
            if(temp.val == val){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    private Node get(int index){
        Node temp = head;
        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
    private class Node{
        int val;
        Node next;
        Node prev;

        private Node(int val){
            this.val = val;
        }

        private Node(int val, Node next, Node prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
