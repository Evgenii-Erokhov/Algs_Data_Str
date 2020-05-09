package lesson3.HW.deque;

import lesson3.stack.Stack;
import lesson3.stack.StackImpl;

public class Main_HW {
    public static void main(String[] args) {

        String str = "qwerty";
        Stack<Character> stack = new StackImpl<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();
        if (true) {
            return;
        }

        Deque<Integer> deq = new DequeImpl<>(6);

        insertRight(deq, 1);
        insertRight(deq, 2);
        insertRight(deq, 3);
        insertRight(deq, 4);
        insertLeft(deq, 5);
        insertLeft(deq, 6);

        removeLeft(deq);
        removeRight(deq);

        displayLeftToRight(deq);
        displayRightToLeft(deq);
    }

    private static <E> void insertRight(Deque<E> deq, E value) {
        if (!deq.isFull()) {
            deq.insertRight(value);
        }
    }

    private static <E> void insertLeft(Deque<E> deq, E value) {
        if (!deq.isFull()) {
            deq.insertLeft(value);
        }
    }

    private static <E> void removeRight(Deque<E> deq) {
        if (!deq.isEmpty()) {
            deq.removeRight();
        }
    }

    private static <E> void removeLeft(Deque<E> deq) {
        if (!deq.isEmpty()) {
            deq.removeLeft();
        }
    }

    private static <E> void displayRightToLeft(Deque<E> deq) {
        while (!deq.isEmpty()) {
            System.out.println(deq.removeRight());
        }
    }

    private static <E> void displayLeftToRight(Deque<E> deq) {
        while (!deq.isEmpty()) {
            System.out.println(deq.removeLeft());
        }
    }
}
