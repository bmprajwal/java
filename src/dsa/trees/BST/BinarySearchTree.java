package dsa.trees.BST;

public class BinarySearchTree {
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
    public BinarySearchTree(){

    }
    private Node root;
    public int height(){
        if(root == null){
            return -1;
        }
        return root.height;
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
        return node;
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
            System.out.println("|----->" + node.val + "(" + node.height + ")");
        } else {
            System.out.println(node.val+ "(" + node.height + ")");
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

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] nums = {1,2,3,4,5,6};
        tree.insert(nums);
        tree.display();
        System.out.println(tree.isBalanced());
        System.out.println(tree.height());
    }
}
