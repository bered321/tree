package service;

import tree.Tree;

import java.io.IOException;

public interface Service<T> {
    Tree<T> get(int n, String st) throws ClassNotFoundException, IOException;
}
