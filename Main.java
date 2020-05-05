package Semestr2;

import java.util.HashSet;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        Vertex<String> A = new Vertex<>("A");
        Vertex<String> B = new Vertex<>("B");
        Vertex<String> C = new Vertex<>("C");
        Vertex<String> D = new Vertex<>("D");
        Vertex<String> E = new Vertex<>("E");
        Vertex<String> F = new Vertex<>("F");
        Vertex<String> G = new Vertex<>("G");

        A.addChilds(C);
        B.addChilds(C,E);
        C.addChilds(D);
        D.addChilds(F);
        E.addChilds(F);
        F.addChilds(G);


        graph.putVertices(A,B,C,D,E,F,G);


        Stack<Vertex> result = topologicalSort(graph);
        while(!result.empty()) {
            System.out.println( result.pop().getValue() );
        }

    }

    public static Stack<Vertex> topologicalSort(Graph graph) {
        Stack<Vertex> stack = new Stack<>();
        HashSet<Vertex> visited = new HashSet<>();

        for(Vertex vertex : graph.getVertices()) {
            if(visited.contains(vertex)) continue;
            childsTopSort(vertex,stack,visited);

        }
        return stack;
    }
    public static void childsTopSort(Vertex vertex, Stack<Vertex> stack, HashSet<Vertex> visited){
        visited.add(vertex);
        for(Object ver : vertex.getChilds()) {
            if(visited.contains(ver)) continue;
            childsTopSort((Vertex)ver, stack,visited);
        }
        stack.add(vertex);
    }
}
