import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> array = new MyArrayList<Integer>();
        array.add(0);
        array.add(13);
        array.add(11);
        array.add(10);
        array.add(12);
        array.sort();
        System.out.println(array.get(0));
        System.out.println(array.get(1));
        System.out.println(array.get(2));
        System.out.println(array.get(3));

    }
}