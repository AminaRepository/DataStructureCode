public class Node<Key extends Comparable<Key>, Value> {
    private Key key;
    private Value value;
    private Node<Key, Value> left;
    private Node<Key, Value> right;
    private boolean isRed;
    public enum Color {
        RED,
        BLACK
    }
    public Node(Key key, Value value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
        this.isRed = true;
    }
    public Value getValue() {
        return this.value;
    }
    public Key getKey() {
        return this.key;
    }
    public Node<Key,Value> getLeft() {
        return this.left;
    }
    public Node<Key,Value> getRight() {
        return this.right;
    }
    public void setRed(boolean b) {
        this.isRed = b;
    }
    public void setLeft(Node<Key, Value> insert) {
        this.left = insert;
    }
    public void setRight(Node<Key, Value> insert) {
        this.right = insert;
    }
    public void setValue(Value value) {
        this.value = value;
    }
    public boolean isRed() {
        return this.isRed;
    }

    public void setColor(RedBlackTree.Color red) {
    }

    public RedBlackTree.Color getColor() {
        return null;
    }
}