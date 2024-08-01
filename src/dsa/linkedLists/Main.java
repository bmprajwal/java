package dsa.linkedLists;

public class Main {
    public static void main(String[] args) {
//        LL list = new LL();
//        list.insertFirst(20);
//        list.insertFirst(4);
//        list.insertLast(38);
//        list.insertLast(2);
//        list.insert(299, 3);
//        list.display();
//        System.out.println(list.deleteFirst());;
//        list.display();
//        System.out.println(list.deleteLast());;
//        list.display();
//        System.out.println(list.deleteAt(1));
//        list.display();
//        System.out.println(list.find(299));
//
//        System.out.println(list.getSize());

//        DLL list = new DLL();
//        list.insertLast(1);
//        list.insertFirst(19);
//        list.insertFirst(38);
//        list.insertFirst(21);
//        list.insertLast(29);
//        list.insert(38, 100);
//        list.display();

        LL list = new LL();
        list.insertFirst(20);
        list.insertFirst(4);
        list.insertLast(38);
        list.insertLast(2);
        list.insert(299, 3);
        list.display();
        list.insertRec(3, 100);
        list.display();
        list.bubbleSort();
        list.display();
    }
}
