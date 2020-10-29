package java3;

import java.util.Arrays;
import java.util.Random;

public class Main {

    private static Random random = new Random();

    public static void main(String[] args) {
        playWithArray();
    }

    private static void playWithArray(){
        Array<Integer> data = new ArrayImpl<>(4);
        /*data.add(5);
        data.add(4);
        data.add(3);
        data.add(2);
        data.add(1);
        data.show();
        System.out.println(data.size());
        System.out.println(data.indexOf(1));
        System.out.println(data.contains(2));
        System.out.println(data.contains(3132));
        data.remove(4);
        data.show();
        System.out.println(data.isEmpty());
        data.insert(12,1);
        data.add(13);
        data.show();
        System.out.println(data.size());*/

        for (int i = 1; i < 100000; i++) {
            data.add(random.nextInt(10000));
        }
        Array<Integer> dataForSortSelect = new ArrayImpl<>();
        Array<Integer> dataForSortInsert = new ArrayImpl<>();

        data.copy(dataForSortSelect);
        data.copy(dataForSortInsert);


        long startForSortBubble = System.currentTimeMillis();
        data.sortBubble();
        System.out.println("Sort bubble: " + (System.currentTimeMillis() - startForSortBubble) + " millis");

        long startForSortSelect = System.currentTimeMillis();
        dataForSortSelect.sortSelect();
        System.out.println("Sort select: " + (System.currentTimeMillis() - startForSortSelect) + " millis");

        long startForSortInsert = System.currentTimeMillis();
        dataForSortInsert.sortInsert();
        System.out.println("Sort insert: " + (System.currentTimeMillis() - startForSortInsert) + " millis");
    }
}
