import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Human> implements Serializable, Iterable<T> {
    private Node<T> root;

    public FamilyTree(T rootData) {
        root = new Node<>(rootData);
    }

    public Node<T> getRoot() {
        return root;
    }

    public int size() {
        int count = 0;
        for (T item : this) {
            count++;
        }
        return count;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T data) {
        return findNode(root, data) != null;
    }

    public void add(T parentData, T childData) {
        Node<T> parentNode = findNode(root, parentData);
        if (parentNode == null) {
            throw new IllegalArgumentException("Parent not found");
        }
        parentNode.addChild(new Node<>(childData));
    }

    public void remove(T data) {
        Node<T> nodeToRemove = findNode(root, data);
        if (nodeToRemove == null) {
            throw new IllegalArgumentException("Node not found");
        }
        if (nodeToRemove == root) {
            root = null;
        } else {
            Node<T> parent = nodeToRemove.getParent();
            parent.removeChild(nodeToRemove);
        }
    }

    public List<T> getChildren(T parentData) {
        Node<T> parentNode = findNode(root, parentData);
        if (parentNode == null) {
            throw new IllegalArgumentException("Parent not found");
        }
        List<T> children = new ArrayList<>();
        for (Node<T> childNode : parentNode.getChildren()) {
            children.add(childNode.getData());
        }
        return children;
    }

    public Iterator<T> iterator() {
        return new FamilyTreeIterator(root);
    }

    private class FamilyTreeIterator implements Iterator<T> {
        private Node<T> currentNode;
        private List<Iterator<Node<T>>> childrenIterators;

        public FamilyTreeIterator(Node<T> root) {
            currentNode = root;
            childrenIterators = new ArrayList<>();
        }

        public boolean hasNext() {
            return currentNode != null;
        }

        public T next() {
            T data = currentNode.getData();
            List<Node<T>> children = currentNode.getChildren();

            if (!children.isEmpty()) {
                childrenIterators.add(children.iterator());
            }

            if (childrenIterators.isEmpty()) {
                if (currentNode == root) {
                    currentNode = null;
                } else {
                    Node<T> parent = currentNode.getParent();
                    while (parent != null && !childrenIterators.isEmpty() && !childrenIterators.get(childrenIterators.size() - 1).hasNext()) {
                        childrenIterators.remove(childrenIterators.size() - 1);
                        currentNode = parent;
                        parent = currentNode.getParent();
                    }
                    if (parent == null) {
                        currentNode = null;
                    } else {
                        currentNode = childrenIterators.get(childrenIterators.size() - 1).next();
                    }
                }
            } else {
                currentNode = childrenIterators.get(childrenIterators.size() - 1).next();
            }

            return data;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private Node<T> findNode(Node<T> currentNode, T data) {
        if (currentNode.getData().equals(data)) {
            return currentNode;
        }
        for (Node<T> childNode : currentNode.getChildren()) {
            Node<T> foundNode


// public class FamilyTree implements Serializable, Iterable<Human> {
//     private List<Human> familyTree = new ArrayList<>();

//     public void addPeople(Human human) {
//         familyTree.add(human);
//         if (human.getMother() != null) {
//             human.getMother().addChildren(human);
//         }
//         if (human.getFather() != null) {
//             human.getFather().addChildren(human);
//         }
//     }

//     public List<Human> getFamilyTree() {
//         return familyTree;
//     }

//     public Human find(String name) {
//         for (Human human : familyTree) {
//             if (human.getName().equals(name)) {
//                 System.out.println(human);
//                 return human;
//             }

//         }
//         return null;
//     }


    // @Override
    // public String toString() {
    //     return familyTree.toString();
    // }
    // @Override
    // public Iterator<Human> iterator(){
    //     return new HumanIterator(familyTree);
    // }
    // public void sortByDate() {
    //     familyTree.sort(new DateComparator());
    // }
    // public void sortByName() {
    //     familyTree.sort(new NameComparator());
    // }
    @Override
    public String toString() {
        return familyTree.toString();
    }
    @Override
    public Iterator<T> iterator(){
        return new HumanIterator(familyTree);
    }
    public void sortByDate() {
        familyTree.sort(new DateComparator());
    }
    public void sortByName() {
        familyTree.sort(new NameComparator());
    }

}
