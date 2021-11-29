import java.util.concurrent.atomic.LongAdder;

public class Adder extends Thread {
    LongAdder stat;
    int[] ints;

    public Adder(LongAdder stat, int[] ints) {
        this.stat = stat;
        this.ints = ints;
    }

    @Override
    public void run() {
        for (int i : ints) {
            stat.add(i);
        }
    }
}
