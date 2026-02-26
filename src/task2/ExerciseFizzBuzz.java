package task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ExerciseFizzBuzz {
    private final int n;
    private int current = 1;
    private final BlockingQueue<String> out = new LinkedBlockingQueue<>();

    public ExerciseFizzBuzz(int n) {
        this.n = n;
    }

    public synchronized void fizz() throws InterruptedException {
        while (current <= n) {
            while (current <=n && !(current % 3 == 0 && current % 5 != 0)) {
                wait();
            }
            if (current > n) break;
                out.put("fizz");
                current++;
                notifyAll();
            }
        }

    public synchronized void buzz() throws InterruptedException {
        while (current <= n) {
            while (current <= n && !(current % 5 == 0 && current % 3 != 0)) {
                wait();
            }
            if (current > n) break;
            out.put("Buzz");
            current++;
            notifyAll();
        }
    }

    public synchronized void fizzbuzz() throws InterruptedException{
        while (current <= n) {
            while (current <= n && !(current % 3 == 0 && current % 5 == 0)) {
                wait();
            }
            if (current > n) break;
                out.put("FizzBuzz");
                current++;
                notifyAll();
            }
        }

    public synchronized void numbers() throws InterruptedException {
            while (current <= n) {
                while (current <= n && !(current % 3 != 0 && current % 5 != 0)) {
                    wait();
                }
                if (current > n) break;
                    out.put(String.valueOf(current));
                    current++;
                    notifyAll();
                }
        }

    public void printAll() throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            String value = out.take();
            if (i < n) System.out.print(value + " ");
            else System.out.print(value);
        }
            System.out.println();
        }
    }

