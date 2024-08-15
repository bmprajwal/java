package dsa.trees.BT;

import java.util.Scanner;

public class BinaryTree {
    public BinaryTree(){

    }
    private class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }
    private Node root;
    public void populate(Scanner input){
        System.out.println("Enter root value: ");
        int val = input.nextInt();
        root = new Node(val);
        populate(input, root);
    }
    private void populate(Scanner input, Node node){
        System.out.println("Do you want to enter left of " + node.val);
        boolean left = input.nextBoolean();
        if(left){
            System.out.println("Enter the value of left of " + node.val);
            int val = input.nextInt();
            node.left = new Node(val);
            populate(input, node.left);
        }
        System.out.println("Do you want to enter right of " + node.val);
        boolean right = input.nextBoolean();
        if(right){
            System.out.println("Enter the value of right of " + node.val);
            int val = input.nextInt();
            node.right = new Node(val);
            populate(input, node.right);
        }
    }

    public void display(){
        display(this.root, 0);
    }
    private void display(Node node, int level){
        if(node == null) return;
        display(node.right, level+1);
        if(level != 0){
            for(int i =0 ; i<level -1; i++){
                System.out.print("|\t\t");
            }
            System.out.println("|----->" + node.val);
        } else {
            System.out.println(node.val);
        }
        display(node.left, level+1);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.populate(new Scanner(System.in));
        tree.display();
    }
}
