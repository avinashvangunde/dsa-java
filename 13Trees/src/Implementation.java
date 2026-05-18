import java.awt.event.MouseAdapter;

public class Implementation {

    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }

    static void disp(Node root){
        if(root == null) return;

        System.out.print(root.val+"--> ");
        if(root.left != null)
            System.out.print(root.left.val+" ");
        if(root.right != null)
            System.out.println(root.right.val+" ");

        disp(root.left);
        disp(root.right);
        System.out.println();
    }

    static int max(Node root){
        if(root == null) return Integer.MIN_VALUE;

        int left = max(root.left);
        int right = max(root.right);

        return Math.max(root.val,Math.max(left,right));
    }

    static int sum(Node root){
        if(root == null) return 0;

        int left = sum(root.left);
        int right = sum(root.right);

        return left+right+root.val;
    }

    static int size(Node root){
        if(root == null) return 0;

        int left = size(root.left);
        int right = size(root.right);

        return left+right+1;
    }



    public static void main(String[] args) {
        /*
                   1  // root node
                2      3  // intermediate nodes
             4    5  6   7   // leaf nodes

         */

        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        root.left = a;
        root.right = b;

        Node c = new Node(4);
        Node d = new Node(5);
        a.left = c;
        a.right = d;

        Node e = new Node(6);
        Node f = new Node(7);

        b.left = e;
        b.right = f;


        disp(root);

        // find max in tree
        System.out.println(max(root));

        // find sum of tree nodes
        System.out.println(sum(root));

        // size of tree
        System.out.println(size(root));

    }
}