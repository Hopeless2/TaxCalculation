import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class Main {
    public static void main(String[] args) {
        int[] array1 = fillArray();
        int[] array2 = fillArray();
        int[] array3 = fillArray();

        LongAdder stat = new LongAdder();

        Thread adder1 = new Adder(stat, array1);
        adder1.start();
        Thread adder2 = new Adder(stat, array2);
        adder2.start();
        Thread adder3 = new Adder(stat, array3);
        adder3.start();

        try {
            adder1.join();
            adder2.join();
            adder3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Результат " + stat.sum());
    }

    public static int[] fillArray() {
        int[] ints = new int[10000];
        Random random = new Random();
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(100);
        }
        return ints;
    }
}
