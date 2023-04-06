public class Node<T extends Human> {
    private T data;
    private Node<T> parent;
    private List<Node<T>> children;

    public Node(T data) {
        this.data = data;
        this.parent = null;
        this.children = new ArrayList<>();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public void addChild(Node<T> child) {
        children.add(child);
        child.setParent(this);
    }

    public void removeChild(Node<T> child) {
        children.remove(child);
        child.setParent(null);
    }
}
