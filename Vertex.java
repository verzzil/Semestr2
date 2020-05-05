package Semestr2;

import java.util.ArrayList;

public class Vertex<T> {

    private T value;
    private ArrayList<Vertex<T>> childs;

    Vertex(T value){
        this.value = value;
        this.childs = new ArrayList<>();
    }

    public void addChild(Vertex<T> child) {
        this.childs.add(child);
    }
    public void addChild(T chi) {
        Vertex<T> child = new Vertex<>(chi);
        this.childs.add(child);
    }
    public void addChilds(Vertex<T>... v) {
        for(Vertex<T> ver : v) {
            this.addChild(ver);
        }
    }
    public void addChilds(T... v) {
        for(T ver : v) {
            this.addChild(ver);
        }
    }

    public T getValue() {
        return value;
    }

    public ArrayList<Vertex<T>> getChilds() {
        return childs;
    }

}