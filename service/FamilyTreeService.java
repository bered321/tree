package service;

import java.io.IOException;

import io.DataLoad;
import io.DataSave;
import human.Human;
import io.FileHandlerLoad;
import io.FileHandlerSaver;
import tree.FamilyTree;
import tree.Sorts;
import tree.Tree;

public class FamilyTreeService<T extends Human> implements Service<T> {

    @Override
    public Tree<T> get(int n, String st) throws ClassNotFoundException, IOException {

        Tree<T> family = new FamilyTree<>();

        Sorts<T> sorts = new Sorts<>(family);
        switch (n) {
            case 1:
                T human = family.find(st);
                if (human == null) {
                    System.out.printf("Человек по имени %s не найден.\n", st);
                } else {
                    System.out.println(human);
                }
                return family;
            case 2:
                System.out.println("Список, отсортированный по имени:");
                sorts.sortByName();
                return family;
            case 3:
                System.out.println("Список, отсортированный по дате смерти:");
                sorts.sortByDate();
                return family;
            default:
                return family;
        }
    }
}