package tree;

import java.util.List;

public interface Tree<T> extends Iterable<T> {
    void addHuman(T human);

    T find(String str);

    List<T> getFamilyTree();
}