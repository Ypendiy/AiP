class Node {
    int data;
    Node left, right;
    
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BST {
    
    Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        
        return root;
    }
    
    Node buildBST(int[] arr) {
        Node root = null;
        for (int num : arr) {
            root = insert(root, num);
        }
        return root;
    }
    
    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    
    public static void main(String[] args) {
        BST tree = new BST();
        int[] arr = {8, 3, 10, 1, 6, 9, 14};
        
        Node root = tree.buildBST(arr);
        
        System.out.println("BST из последовательности:");
        tree.preorder(root);
        System.out.println();
    }
}
