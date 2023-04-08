package io;

import java.io.IOException;

import tree.Tree;

public interface DataSave<T> {
    void saveData(Tree<T> familyTree) throws IOException, ClassNotFoundException;
}
