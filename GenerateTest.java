package Semestr2;

import java.io.FileWriter;
import java.io.IOException;

public class GenerateTest {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("text.txt");
        int countStroke = 10; // количество строк
        int countValues = 100; // количество значений в каждой строке

        int leftLimit = -10000;
        int rightLimin = 10000; // диапазон случайных чисел, которые
// будут в файле
        for(int i = 0; i < countStroke; i++) {
            for(int j = 0; j < countValues; j++) {
                fw.write(getRandomInteger(leftLimit,rightLimin)+" ");
            }
            if(i != countStroke - 1) fw.write("\n"); // Если не последняя строка,
// то вставляем символ перевода строки
        }
        fw.close();
    }
    public static int getRandomInteger(int a, int b) {
        return (int)(Math.random()*(b-a+1))+a;
    }
}