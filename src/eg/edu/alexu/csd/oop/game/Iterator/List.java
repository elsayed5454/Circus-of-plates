package eg.edu.alexu.csd.oop.game.Iterator;

import eg.edu.alexu.csd.oop.game.GameObject;

import java.util.LinkedList;

public class List implements IList {
    private  java.util.List<GameObject> List = new LinkedList<>();

    public List(java.util.List<GameObject> List){
        this.List=List;
    }

    @Override
    public IIterator createIterator() {
        return new Iterator(List);
    }
}