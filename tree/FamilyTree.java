package tree;


import human.Comparators.HumanIterator;
import human.Human;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FamilyTree<T extends Human> implements Serializable, Tree<T> {
    private List<T> familyTree;
    public FamilyTree(ArrayList<T> familyTree) {
        this.familyTree = familyTree;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public List<T> getFamilyTree() {
        return familyTree;
    }

    public void addHuman(T human) {
        familyTree.add(human);
        if (human.getMother() != null) {
            human.getMother().addChildren(human);
        }
        if (human.getFather() != null) {
            human.getFather().addChildren(human);
        }
    }



    public T find(String name) {
        for (T human : familyTree) {
            if (human.getName().equalsIgnoreCase(name)) {
                System.out.println(human);
                return human;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(this.familyTree);
        return str.toString();
    }
    @Override
    public Iterator<T> iterator(){
        return new HumanIterator<T>(familyTree);
    }

}
