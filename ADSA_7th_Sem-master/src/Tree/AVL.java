package Tree;

public class AVL{

    public Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        int balance = balanceFactor(root);

        // Left Left Case
        if (balance > 1 && data < root.left.data)
            return rightRotate(root);

        // Right Right Case
        if (balance < -1 && data > root.right.data)
            return leftRotate(root);

        // Left Right Case
        if (balance > 1 && data > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left Case
        if (balance < -1 && data < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }


    static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }



    int balanceFactor(Node root){
        if(root==null){
            return 0;
        }
        return height(root.left) - height(root.right);
    }



    void preOrderdisplay(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderdisplay(root.left);
        preOrderdisplay(root.right);
    }

static Node rightRotate(Node y) {
    Node x = y.left;
    Node T2 = x.right;

    x.right = y;
    y.left = T2;

    return x;
}

static Node leftRotate(Node x) {
    Node y = x.right;
    Node T2 = y.left;

    y.left = x;
    x.right = T2;

    return y;
}

    public static void main(String[] args) {
        AVL tree = new AVL();
        Node root = null;
        root = tree.insert(root, 10);
        root = tree.insert(root, 20);
        root = tree.insert(root, 30);
        root = tree.insert(root, 40);
        root = tree.insert(root, 50);
//        root = tree.insert(root, 12);
//        root = tree.insert(root, 17);
//        root = tree.insert(root, 20);
        tree.preOrderdisplay(root);
        System.out.println();
        System.out.println(height(root));
        System.out.println(tree.balanceFactor(root));


    }
}
