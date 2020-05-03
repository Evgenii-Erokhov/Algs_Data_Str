package lesson2.HW;

import lesson2.Array;
import lesson2.ArrayImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class Sorts {

    private static final int ARRAY_CAPACITY = 10_000;
    private static final int MAX_VALUE = 10_000;

    public static void main(String[] args) {
        Supplier<Array<Integer>> constructor = ArrayImpl::new;

        Array<Integer> arr1 = createArray(constructor);
        Array<Integer> arr2 = createArray(constructor);
        Array<Integer> arr3 = createArray(constructor);

        randomInitialize(arr1, arr2, arr3);

        Thread thread1 = new Thread(arr1::sortInsert);
        Thread thread2 = new Thread(arr2::sortSelect);
        Thread thread3 = new Thread(arr3::sortBubble);

        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }

        List<Runnable> tasks = new ArrayList<>();
                tasks.add(measureTime(arr1::sortInsert, "Sort Insert"));
                tasks.add(measureTime(arr2::sortSelect, "Sort Select"));
                tasks.add(measureTime(arr3::sortBubble, "Sort Bubble"));

        tasks.forEach(Runnable::run);
    }

    @SafeVarargs
    private static void randomInitialize(Array<Integer>... arrays) {
        Random random = new Random();
        for (int i = 0; i < ARRAY_CAPACITY; i++) {
            int value = random.nextInt(MAX_VALUE);
            for (Array<Integer> array : arrays) {
                array.add(value);
            }
        }
    }

    private static Runnable measureTime(Runnable action, String methodName) {
        return () -> {
            long startTime = System.nanoTime();
            action.run();
            long finishTime = System.nanoTime();
            long duration = finishTime - startTime;

            System.out.printf("%s took time: %d micros.%n", methodName, TimeUnit.NANOSECONDS.toMicros(duration));
        };
    }

    private static Array<Integer> createArray(Supplier<Array<Integer>> factory) {
        return factory.get();
    }

}
