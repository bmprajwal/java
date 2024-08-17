package dsa.trees.SegmentTree;

import dsa.trees.BST.BinarySearchTree;

public class SegmentTree {
    private class Node{
        int data;
        int startInt;
        int endInt;
        Node left;
        Node right;
        public Node(int startInt, int endInt){
            this.startInt = startInt;
            this.endInt = endInt;
        }
    }
    private Node root;
    public SegmentTree(int[] arr){
        this.root = constructTree(arr,0, arr.length-1);
    }
    private Node constructTree(int[] arr, int start, int end){
        if(start == end){
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }
        Node node = new Node(start, end);
        int mid = (start + end) / 2;
        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid+1, end);
        node.data = node.left.data + node.right.data;
        return node;
    }

    public int query(int qsi, int qei){
        return query(root, qsi, qei);
    }

    private int query(Node node, int qsi,int qei){
        if(node.startInt >= qsi && node.endInt <= qei){
            return node.data;
        } else if(node.startInt > qei || node.endInt < qsi){
            return 0;
        } else {
            return query(node.left, qsi, qei) + query(node.right, qsi, qei);
        }
    }

    public void update(int index, int val){
        root.data = update(root, index, val);
    }
    private int update(Node node, int index, int val){
        if(node.startInt <= index && node.endInt >= index){
            if(node.startInt == index && node.endInt == index){
                node.data = val;
            } else {
                int leftAns = update(node.left,index, val);
                int rightAns = update(node.right, index, val);
                node.data = leftAns + rightAns;
            }
            return node.data;
        }
        return node.data;
    }

    public void display(){
        display(root, 0);
    }
    private void display(Node node, int level){
        if(node == null) return;
        display(node.right, level+1);
        if(level != 0){
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|----->" + node.data + "[" + node.startInt+","+node.endInt + "]");
        } else {
            System.out.println(node.data + "[" + node.startInt+","+node.endInt + "]");
        }
        display(node.left, level+1);
    }

    public static void main(String[] args) {
        int[] arr = {3,8,7,6,-2,-8,4,9};
        SegmentTree tree = new SegmentTree(arr);
        tree.display();
        System.out.println(tree.query(2,6));
        tree.update(3, 14);
        tree.display();
        System.out.println(tree.query(2,6));
    }
}
