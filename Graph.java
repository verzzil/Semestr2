package Semestr2;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {

    private ArrayList<Vertex> vertices;

    Graph() {
        vertices = new ArrayList<>();
    }

    public void putVertex(Vertex v) {
        vertices.add(v);
    }
    public <T> void putVertices(Vertex<T>[] v) {
        vertices.addAll(Arrays.asList(v));
    }
    public <T> void putVertex(T v) {
        Vertex<T> vertex = new Vertex<>(v);
        vertices.add(vertex);
    }
    public <T> void putVertices(T... v) {
        for(T ver : v) {
            Vertex<T> vertex = new Vertex<>(ver);
            vertices.add(vertex);
        }
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }
    public void clear() {
        vertices = new ArrayList<>();
    }

}