package Semestr2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {
    static int currentOperation = 0;
    public static void main(String[] args) throws FileNotFoundException {

        FileReader fr = new FileReader("text.txt");
        Scanner scan= new Scanner(fr);

        int countStroke = 10; // количество строк
        int countValues = 100; // количество значений в каждой строке
        String[][] data = new String[countStroke][countValues];
        int i = 0;
        while(scan.hasNextLine()) {
            data[i] = scan.nextLine().split(" ");
            i++;
        }

        Graph graph = new Graph();
        Vertex[][] vertices = new Vertex[countStroke][countValues];
        for(i = 0; i < countStroke; i++) {
            for(int j = 0; j < countValues; j++) {
                vertices[i][j] = new Vertex<>(data[i][j]);
            }
        }
        i = 0;
        while(i < 100) {
            vertices[getRandomInteger(0,countStroke-1)][getRandomInteger(0,countValues-1)].
                    addChild(vertices[getRandomInteger(0,countStroke-1)][getRandomInteger(0,countValues-1)]);
            i++;
        }

        long medianTime = 0;
        int medianOperation = 0;
        for(int j = 0; j < countStroke; j++) {
            graph.putVertices(vertices[j]);
            currentOperation = 0;
            long currentTime = System.nanoTime();
            Stack<Vertex> result = topologicalSort(graph);
            while(!result.empty()) {
                System.out.println( result.pop().getValue() );
            }
            medianOperation += currentOperation / countStroke;
            medianTime = (medianTime + (System.nanoTime()-currentTime))/countStroke;
            System.out.println("==============");

            graph.clear();

        }

        System.out.println("Median time: "+medianTime);
        System.out.println("Median operation: "+medianOperation);


    }

    public static Stack<Vertex> topologicalSort(Graph graph) {
        Stack<Vertex> stack = new Stack<>();
        HashSet<Vertex> visited = new HashSet<>();

        for(Vertex vertex : graph.getVertices()) {
            if(visited.contains(vertex)) continue;
            childsTopSort(vertex,stack,visited);
            currentOperation++;
        }
        return stack;
    }
    public static void childsTopSort(Vertex vertex, Stack<Vertex> stack, HashSet<Vertex> visited){
        visited.add(vertex);
        for(Object ver : vertex.getChilds()) {
            if(visited.contains(ver)) continue;
            currentOperation++;
            childsTopSort((Vertex)ver, stack,visited);
        }
        stack.add(vertex);
    }
    public static int getRandomInteger(int a, int b) {
        return (int)(Math.random()*(b-a+1))+a;
    }
}
