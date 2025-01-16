public class BinTreeGen<E extends Comparable<E>> implements BinTreeGenInterface<E> {
    private BinNodeGen<E> root;

    public BinTreeGen() {
    }

    public BinTreeGen(BinNodeGen<E> root) throws NullPointerException {
        if (root == null) throw new NullPointerException("root cannot be null");
        this.root = root;
    }

    @Override
    public int countNodes() {
        return countNodes(root);
    }

    /**
     * counts all nodes in a tree with given root
     *
     * @param n root of tree whose nodes are to be counted
     * @return number of nodes
     */
    private int countNodes(BinNodeGen<E> n) {
        int counter = 0;
        if (n != null) {
            counter = 1 + countNodes(n.left) + countNodes(n.right);
        }
        return counter;
    }


    @Override
    public boolean insertNode(E item) {
        if (item == null) return false;

        // in case of empty tree
        if (root == null) {
            root = new BinNodeGen<>(item);
            return true;
        }

        return insertNode(root, item);
    }

    /**
     * inserts a given item into a sorted (sub)tree with given root in a sorted manner
     * (i.e. maintaining the sorting) if the item does not already exist
     * and returns true to indicate that the insertion was successful
     * otherwise, if item does already exist, does not insert anything and returns false
     *
     * @param root of the tree
     * @param item BinNode to be inserted
     * @return true, if item was successfully inserted, false otherwise
     */
    private boolean insertNode(BinNodeGen<E> root, E item) {

        // if element that is to be inserted is smaller than the currently viewed node (root)
        if (root.data.compareTo(item) > 0) {
            if (root.left == null) {
                root.left = new BinNodeGen<>(item);
                return true;
            } else {
                return insertNode(root.left, item);
            }
        }

        // if element that is to be inserted is bigger than the currently viewed node (root)
        if (root.data.compareTo(item) < 0) {
            if (root.right == null) {
                root.right = new BinNodeGen<>(item);
                return true;
            } else {
                return insertNode(root.right, item);
            }
        }

        return false; // if root.data.compareTo(item) == 0, that means item already exists in tree
    }


    @Override
    public BinNodeGen<E> find(E item) throws NullPointerException {
        if (item == null) throw new NullPointerException("item cannot be null");
        return find(item, root);
    }


    /**
     * searches for an item in a sorted tree
     *
     * @param item an item we search for
     * @param root of the tree to be searched
     * @return node with the sought item or null if such a node does not exist
     */
    private BinNodeGen<E> find(E item, BinNodeGen<E> root) {
        if (root == null) return null;  // in case of empty tree
        if (item.compareTo(root.data) < 0) return find(item, root.left); // if sought item is smaller than currently viewed node (root)
        if (item.compareTo(root.data) > 0) return find(item, root.right); // if sought item is bigger than currently viewed node (root)
        return root;
    }

    @Override
    public String toString() {
        return toString(root);
    }

    /**
     * returns String-serialization of all nodes of the tree with given root
     *
     * @param root of the tree
     * @return String serialization of all nodes of the tree
     */
    private String toString(BinNodeGen<E> root) {
        if (root == null) return "";  // in case of empty tree
        return "(" + toString(root.left) + root.data + toString(root.right) + ")";
    }
}
