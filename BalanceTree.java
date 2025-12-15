class Node {
    int data;
    Node left, right;
    
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BalanceTree {
    
    Node BalTree(int[] arr, int start, int end) {
        if (start > end) return null;
        
        int mid = start + (end - start) / 2;
        Node root = new Node(arr[mid]);
        
        root.left = BalTree(arr, start, mid - 1);
        
        root.right = BalTree(arr, mid + 1, end);
        
        return root;
    }
    
    Node buildBalanceTree(int[] arr) {
        return BalTree(arr, 0, arr.length - 1);
    }
    
    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    
    public static void main(String[] args) {
        BalanceTree tree = new BalanceTree();
        int[] arr = {1, 2, 3, 4, 5};
        
        Node root = tree.buildBalanceTree(arr);
        
        System.out.println("Сбалансированное дерево:");
        tree.preorder(root);
    }
}
