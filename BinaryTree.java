import java.util.*;
class Node {
    int data;
    Node left, right;
    
    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class BinaryTree {

    void inOrder(Node node, ArrayList<Integer> res) {
        if (node == null) return;
        inOrder(node.left, res); 
        res.add(node.data); 
        inOrder(node.right, res); 
    }
    
    void preOrder(Node node, ArrayList<Integer> res) {
        if (node == null) return;
        res.add(node.data); 
        preOrder(node.left, res); 
        preOrder(node.right, res); 
    }
    
    void postOrder(Node node, ArrayList<Integer> res) {
        if (node == null) return;
        postOrder(node.left, res);   
        postOrder(node.right, res);  
        res.add(node.data); 
    }
    
        ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                Node curr = q.poll(); 
                level.add(curr.data); 
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            res.add(level);
        }
        return res;
    }
    
    int height(Node root) {
        if (root == null) return -1; 
        int leftHeight = height(root.left); 
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1; 
    }
    
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        
        ArrayList<Integer> result = new ArrayList<>();
        
        System.out.print("Inorder: ");
        tree.inOrder(root, result);
        System.out.println(result);
        
        result.clear();
        System.out.print("Preorder: ");
        tree.preOrder(root, result);
        System.out.println(result);
        
        result.clear();
        System.out.print("Postorder: ");
        tree.postOrder(root, result);
        System.out.println(result);
        
        System.out.print("Level Order: ");
        ArrayList<ArrayList<Integer>> levelResult = tree.levelOrder(root);
        System.out.println(levelResult);
        
        System.out.println("Height: " + tree.height(root));
    }
}