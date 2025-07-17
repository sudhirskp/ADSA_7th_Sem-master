package Tree;


class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class BST {

    public Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    int height(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }


    void Inorderdisplay(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        Inorderdisplay(root.left);
        Inorderdisplay(root.right);
    }

    public static void main(String[] args) {
        BST tree = new BST();
        Node root = null;
        root = tree.insert(root, 10);
        root = tree.insert(root, 5);
        root = tree.insert(root, 15);
        root = tree.insert(root, 3);
        root = tree.insert(root, 7);
        root = tree.insert(root, 12);
        root = tree.insert(root, 17);
        root = tree.insert(root, 20);
        tree.Inorderdisplay(root);
        System.out.println();
        System.out.println("Height of BST is: " + tree.height(root));

    }
}
