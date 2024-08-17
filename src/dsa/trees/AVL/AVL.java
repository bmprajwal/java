package dsa.trees.AVL;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class AVL {
    public static class Node{
        int val;
        Node left;
        Node right;
        int height;
        public Node(int val){
            this.val = val;
        }
        public int getVal(){
            return this.val;
        }
    }
    public AVL(){

    }
    private Node root;
    public int height(){
        return height(root);
    }
    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }
    public boolean isEmpty(){
        return root == null;
    }

    public void insert(int val){
        root = insert(root, val);
    }

    private Node insert(Node node, int val){
        if(node == null){
            return new Node(val);
        }
        if(val < node.val){
            node .left = insert(node.left, val);
        } else {
            node.right = insert(node.right, val);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
    }
    private Node rotate(Node node){
        // left heavy
        if(height(node.left) - height(node.right) > 1){
            // left left
            if(height(node.left.left) - height(node.left.right) > 0){
                return rightRotate(node);
            }
            // left right
            if(height(node.left.left)-height(node.left.right) < 0 ){
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        // right heavy
        if(height(node.left) - height(node.right) < -1){
            // right right
            if(height(node.right.left) - height(node.right.right) < 0){
                return leftRotate(node);
            }
            // right left
            if(height(node.right.left) - height(node.right.right) > 0){
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node rightRotate(Node p){
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right))+1;
        c.height = Math.max(height(c.left), height(c.right))+1;
        return c;
    }

    private Node leftRotate(Node c){
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;
        c.height = Math.max(height(c.left), height(c.right))+1;
        p.height = Math.max(height(p.left), height(p.right))+1;

        return p;
    }

    public void insert(int[] nums){
        for (int num : nums) {
            insert(num);
        }
    }
    public boolean isBalanced(){
        return isBalanced(root);
    }
    private boolean isBalanced(Node node){
        if(node == null) return true;
        return Math.abs(height(node.left) - height(node.right)) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }

    public void display(){
        display(root, 0);
    }
    private void display(Node node,int level){
        if(node == null) return;
        display(node.right, level+1);
        if(level != 0){
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|----->" + node.val);
        } else {
            System.out.println(node.val);
        }
        display(node.left, level+1);
    }

    public void preOrder(){
        preOrder(root);
        System.out.println();
    }
    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public void postOrder(){
        postOrder(root);
        System.out.println();
    }
    private void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }
    public void inOrder(){
        inOrder(root);
        System.out.println();
    }
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    public void bfs(){
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.addLast(root);
        while(!q.isEmpty()){
            Node popped = q.removeFirst();
            System.out.print(popped.val + " ");
            if(popped.left != null){
                q.addLast(popped.left);
            }
            if(popped.right != null){
                q.addLast(popped.right);
            }

        }
    }


    public static void main(String[] args) {
        AVL tree = new AVL();
        int[] nums = {1,2,3,4,5,6};
        for(int i = 0; i < 20; i++){
            tree.insert(i);
        }
        tree.display();
        System.out.println(tree.isBalanced());
        System.out.println(tree.height());
        tree.inOrder();
        tree.bfs();
    }
}
