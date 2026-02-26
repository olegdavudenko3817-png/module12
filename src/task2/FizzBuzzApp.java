package task2;

public class FizzBuzzApp {
    static void main(String[] args) throws InterruptedException {
        ExerciseFizzBuzz fb = new ExerciseFizzBuzz(15);

        Thread[] workers = {
                new Thread(() -> {try {fb.fizz();} catch (InterruptedException e) {}}),
                new Thread(() -> {try {fb.buzz();} catch (InterruptedException e) {}}),
                new Thread(() -> {try {fb.fizzbuzz();} catch (InterruptedException e) {}}),
                new Thread(() -> {try {fb.numbers();} catch (InterruptedException e) {}})
};

        for (Thread worker : workers)
            worker.start();
        fb.printAll();
        for (Thread worker : workers)
            worker.join();
    }
}