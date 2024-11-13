class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;

            while (true) {
                parent = current;
                if (data < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public Node search(int data) {
        Node current = root;
        System.out.print("Visiting elements: ");

        while (current != null && current.data != data) {
            System.out.print(current.data + " ");
            if (data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return current;
    }

    public void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    public void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] array = {27, 14, 35, 10, 19, 31, 42};

        for (int value : array) {
            bst.insert(value);
        }

        // Searching for elements
        int elementToSearch = 31;
        Node result = bst.search(elementToSearch);
        if (result != null) {
            System.out.println("\n[" + result.data + "] Element found.");
        } else {
            System.out.println("\n[ x ] Element not found (" + elementToSearch + ").");
        }

        elementToSearch = 15;
        result = bst.search(elementToSearch);
        if (result != null) {
            System.out.println("\n[" + result.data + "] Element found.");
        } else {
            System.out.println("\n[ x ] Element not found (" + elementToSearch + ").");
        }

        // Traversals
        System.out.print("\nPreorder traversal: ");
        bst.preOrderTraversal(bst.root);

        System.out.print("\nInorder traversal: ");
        bst.inorderTraversal(bst.root);

        System.out.print("\nPost order traversal: ");
        bst.postOrderTraversal(bst.root);
    }
}