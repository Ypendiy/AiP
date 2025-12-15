class Node {
    int data;
    Node left, right;
    
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class FullBinaryTree {
    
    Node buildFullTree() {
        Node root = new Node(1);    
        
        root.left = new Node(2);    
        root.right = new Node(3);
        
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        return root;
    }
    
    boolean isFull(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        
        if ((root.left != null && root.right == null) || 
            (root.left == null && root.right != null)) {
            return false;
        }
        
        return isFull(root.left) && isFull(root.right);
    }
    
    void Preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            Preorder(root.left);
            Preorder(root.right);
        }
    }
    
    public static void main(String[] args) {
        FullBinaryTree tree = new FullBinaryTree();
        
        Node root = tree.buildFullTree();
        
        System.out.println("Дерево: ");
        tree.Preorder(root);
        System.out.println("\n");
        System.out.println("Дерево полное?: " + tree.isFull(root));
    }
}
