package tree;

import human.Comparators.DateComparator;
import human.Comparators.NameComparator;
import human.Human;

public class Sorts<T extends Human> {
    private final Tree<T> familyTree;

    public Sorts(Tree<T> familyTree) {
        this.familyTree = familyTree;
    }

    public void sortByDate() {
        familyTree.getFamilyTree().sort(new DateComparator<T>());
    }

    public void sortByName() {
        familyTree.getFamilyTree().sort(new NameComparator<T>());
    }
}