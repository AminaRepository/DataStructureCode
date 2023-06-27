public class RedBlackTree<Key extends Comparable<Key>, Value> {
    private Node<Key, Value> root;
    private Color color;

    // Other methods and constructors

    public Node<Key, Value> insert(Node<Key, Value> node, Key key, Value value) {
        // Perform a regular BST insert
        if (node == null) {
            Node<Key, Value> newNode = new Node<>(key, value);
            newNode.setColor(Color.RED); // New node is always inserted as a red node
            return newNode;
        }

        int cmp = key.compareTo(node.getKey());
        if (cmp < 0) {
            node.setLeft(insert(node.getLeft(), key, value));
        } else if (cmp > 0) {
            node.setRight(insert(node.getRight(), key, value));
        } else {
            // Key already exists, update the value or handle accordingly
            node.setValue(value);
            return node;
        }

        // Perform the necessary rotations and color flips to maintain the red-black tree properties
        if (isRed(node.getRight()) && !isRed(node.getLeft())) {
            node = rotateLeft(node);
        }
        if (isRed(node.getLeft()) && isRed(node.getLeft().getLeft())) {
            node = rotateRight(node);
        }
        if (isRed(node.getLeft()) && isRed(node.getRight())) {
            flipColors(node);
        }

        return node;
    }
    public enum Color {
        RED,
        BLACK
    }
    public void setRoot(Node<Key, Value> root) {
        this.root = root;
    }

    private Node<Key, Value> rotateLeft(Node<Key, Value> node) {
        Node<Key, Value> x = node.getRight();
        node.setRight(x.getLeft());
        x.setLeft(node);
        x.setColor(node.getColor());
        node.setColor(Color.RED);
        return x;
    }

    private Node<Key, Value> rotateRight(Node<Key, Value> node) {
        Node<Key, Value> x = node.getLeft();
        node.setLeft(x.getRight());
        x.setRight(node);
        x.setColor(node.getColor());
        node.setColor(Color.RED);
        return x;
    }

    private void flipColors(Node<Key, Value> node) {
        node.setColor(Color.RED);
        node.getLeft().setColor(Color.BLACK);
        node.getRight().setColor(Color.BLACK);
    }

    private boolean isRed(Node<Key, Value> node) {
        if (node == null) {
            return false;
        }
        return node.getColor() == Color.RED;
    }
}
