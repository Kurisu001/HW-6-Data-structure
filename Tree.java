
// This Tree needs to inherit BTreePrinter
public class Tree extends BTreePrinter { // Fix this
    Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Tree() {
    } // Dummy constructor (No need to edit)

    public void printTree() {
        if (root != null)
            super.printTree(root);
        else
            System.out.println("Empty tree!!!");
    }

    public static void printNode(Node node) {
        if (node != null)
            System.out.print(node.key);
        else
            System.out.println("Node not found!!!");
    }

    public Node findKey(int search_key) {
        return findKey(root, search_key); // Call the recursive version
    }

    public static Node findKey(Node node, int search_key) {
        // this function should be recursive
        // You should check null in this function
        if (node != null) {
            if (node.key == search_key)
                return node;
            else if (search_key < node.key)
                return findKey(node.left, search_key);
            else
                return findKey(node.right, search_key);
        }
        // printNode(node);
        return node;
    }

    public Node findMin() {
        return findMin(root); // Call the recursive version
    }

    public static Node findMin(Node node) {
        // this function should be recursive
        if (node.left != null) {
            return findMin(node.left);
        }
        return node;
    }

    public Node findMax() {
        return findMax(root); // Call the recursive version
    }

    public static Node findMax(Node node) {
        // this function should be recursive
        if (node.right != null) {
            return findMax(node.right);
        }
        return node;
    }

    public Node findClosestLeaf(int search_key) {
        return findClosestLeaf(root, search_key); // Call the recursive version
    }

    public static Node findClosestLeaf(Node node, int search_key) {
        // this function should be recursive
        if (search_key < node.key && node.left != null)
            return findClosestLeaf(node.left, search_key);
        if (search_key > node.key && node.right != null)
            return findClosestLeaf(node.right, search_key);
        return node;
    }

    public Node findClosest(int search_key) {
        // Please use while loop to implement this function
        // Try not to use recursion
        Node current, closest;
        closest = current = root;
        int min_diff = Integer.MAX_VALUE;

        // Use while loop to traverse from root to the closest leaf
        while (Math.abs(search_key - current.key) < min_diff) {
            min_diff = Math.abs(search_key - current.key);
            closest = current;
            if (search_key < current.key && current.left != null) {
                current = current.left;
            }
            if (search_key > current.key && current.right != null) {
                current = current.right;
            }
        }
        return closest;
    }

    // Implement this function using the findClosestLeaf technique
    // Do not implement the recursive function
    public void insertKey(int key) {
        // Implement insertKey() using the non-recursive version
        // This function should call findClosestLeaf()
        if (root != null) {
            Node current = findClosestLeaf(root, key);
            if (key == current.key) {
                System.out.println("Duplicated key!!!");
                return;
            } else if (key > current.key) {
                current.right = new Node(key);
                current.right.parent = current;
            } else {
                current.left = new Node(key);
                current.left.parent = current;
            }
        } else {
            root = new Node(key);
        }

    }

    public void printPreOrderDFT() {
        System.out.print("PreOrder DFT node sequence [ ");
        // Call the recursive version
        printPreOrderDFT(root);
        System.out.println("]");
    }

    public static void printPreOrderDFT(Node node) {
        // this function should be recursive
        System.out.println(node.key + " ");
        if (node.left != null)
            printPreOrderDFT(node.left);
        if (node.right != null)
            printPreOrderDFT(node.right);
    }

    public void printInOrderDFT() {
        System.out.print("InOrder DFT node sequence [ ");
        // Call the recursive version
        printInOrderDFT(root);
        System.out.println("]");
    }

    public static void printInOrderDFT(Node node) {
        // this function should be recursive
        if (node.left != null)
            printInOrderDFT(node.left);
        System.out.print(node.key + " ");
        if (node.right != null)
            printInOrderDFT(node.right);
    }

    public void printPostOrderDFT() {
        System.out.print("PostOrder DFT node sequence [ ");
        // Call the recursive version
        printPostOrderDFT(root);
        System.out.println("]");
    }

    public static void printPostOrderDFT(Node node) {
        // this function should be recursive
        if (node.left != null)
            printPostOrderDFT(node.left);
        if (node.right != null)
            printPostOrderDFT(node.right);
        System.out.print(node.key + " ");
    }

    public static int height(Node node) {
        // Use recursion to implement this function
        // height = length(path{node->deepest child})
        if (node != null) {
            return 1 + Math.max(height(node.left), height(node.right));
        }
        return 0;
    }

    public static int size(Node node) {
        // Use recursion to implement this function
        // size = #children + 1(itself)
        if (node != null) {
            return 1 + size(node.left) + size(node.right);
        }
        return 0;
    }

    public static int depth(Node root, Node node) {
        // Use recursion to implement this function
        // Similar to height() but start from node, go up to root
        // depth = length(path{node->root})
        if (root != node) {
            return depth(root, node.parent) + 1;
        }
        return -1;
    }

    public int treeHeight() { // Tree height
        // Hint: call the static function
        if (root == null)
            return -1;
        return height(root);
    }

    public int treeSize() { // Tree size
        // Hint: call the static function
        if (root == null)
            return 0;
        return size(root);
    }

    public int treeDepth() { // Tree depth
        // Hint: call the static function
        if (root == null)
            return -1;
        return height(root);
    }

    public Node findKthSmallest(int k) {
        return null; // Call the recursive version
    }

    public static Node findKthSmallest(Node node, int k) {
        // this function should be recursive
        if (node != null) {
            int l = size(node.left);
            if (k == l + 1)
                return node;
            if (k < l + 1)
                return findKthSmallest(node.left, k);
            if (k > l + 1)
                return findKthSmallest(node.right, k - 1 - l);
        }
        return null;
    }

    public static Node findNext(Node node) {
        // this function should call other functions
        return null;
    }

    public static Node leftDescendant(Node node) {// Case 1 (findMin)
        // this function should be recursive
        return null;
    }

    public static Node rightAncestor(Node node) {// Case 1 (first right parent)
        // this function should be recursive
        return null;
    }

    public List rangeSearch(int x, int y) {
        // This function utilizes findCloest() and findNext()
        // Use List list append(node) to add node to the list
        // List is the static Array
        return new List(100);
    }

    // This function is for deleting the root node
    // If the node is not the root, please call the recursive version
    public void deleteKey(int key) {
        // There should be 6 cases here
        // Non-root nodes should be forwarded to the static function
        if (root == null) {
            System.out.println("Empty Tree!!!");
            return;
        }
        Node current = findKey(key);
        if (current == null) {
            System.out.println("Key not found!!!");
            return;
        } else if (root == current) {
            // ไม่มีลูก
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            // มีลูกข้างเดียว
            if (root.left == null)
                root = root.right;
            else if (root.right == null)
                root = root.left;
            else {
                Node successor = findMin(root.right);
                root.key = successor.key;
                deleteKey(successor);
            }

        } else {
            deleteKey(current);
        }
    }

    // Use this function to delete non-root nodes
    public static void deleteKey(Node node) {
        // There should be 7 cases here
        Node current = node;
        // Chaeck this is the leaf node?

        // Node without Child case
        if (current.left == null && current.right == null) {
            if (current == current.parent.left)
                current.parent.left = null;
            else if (current == current.parent.right)
                current.parent.right = null;
            return;
        }
        // Node have a child
        if (current.left == null) {
            if (current == current.parent.left) {
                current.right.parent = current.parent;
                current.parent.left = current.right;
            }else if (current == current.parent.right) {
                current.right.parent = current.parent;
                current.parent.right = current.right;
            }
            return;
        }
        if (current.right == null) {
            if (current == current.parent.left) {
                current.left.parent = current.parent;
                current.parent.left = current.left;
            }else if (current == current.parent.right) {
                current.left.parent = current.parent;
                current.parent.right = current.left;
            }
            return;
        }

        Node successor = findMin(current.right);
        current.key = successor.key;
        deleteKey(successor);
    }
}
