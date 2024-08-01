package dsa.linkedLists;

public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL(){
        this.size = 0;
    }

    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }
        size++;
    }

    public void insertLast(int value){
        if(tail == null){
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int value, int index){
        if(index == 0){
            insertFirst(value);
            return;
        }
        if(index == size){
            insertLast(value);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(value, temp.next);
        temp.next = node;
        size++;
    }

    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return val;
    }

    public int deleteLast(){
        if(size <= 1){
            return deleteFirst();
        }
        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    public int deleteAt(int index){
        if(index == 0){
            return deleteFirst();
        }
        if(index == size -1){
            return deleteLast();
        }
        Node prev = get(index - 1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    public void insertRec(int index, int val){
        head = insertRec(index, val, head);
    }

    private Node insertRec(int index, int val, Node node){
        if(index == 0){
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(index-1, val, node.next);
        return node;
    }

    public void bubbleSort(){
        bubbleSort(size - 1, 0);
    }

    private void bubbleSort(int row, int col){
        if(row == 0){
            return;
        }

        if(col < row){
            Node first = get(col);
            Node second = get(col+1);
            if(first.value > second.value){
                //swap
                if(first == head){
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if(second == tail){
                    Node prev = get(col -1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;

                } else {
                    Node prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }

            }
            bubbleSort(row, col+1);
        } else {
            bubbleSort(row - 1, 0);
        }
    }

    public void reverse(){
        if(head == null){
            return;
        }
        Node prev = null;
        Node present = head;
        Node next = present.next;

        while (present != null){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null){
                next = next.next;
            }
        }
        head = prev;
    }

    private Node find(int value){
        Node temp = head;
        while(temp != null){
            if(temp.value == value){
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

    public int getSize(){
        return size;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
