package io;

import java.io.*;

import human.Human;
import tree.FamilyTree;
import tree.Tree;

public class FileHandlerSaver<T> implements DataSave<T> {
    private void saveSer(Tree<T> familyTree) throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("familyTree.ser"));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
    }


    @Override
            public void saveData(Tree<T> familyTree) throws IOException, ClassNotFoundException{
            saveSer(familyTree);
            System.out.println("Файл сериализации создан");
    }

}



