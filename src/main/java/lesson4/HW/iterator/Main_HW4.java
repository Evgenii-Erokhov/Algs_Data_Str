package lesson4.HW.iterator;

import lesson4.HW.LinkedList;
import lesson4.HW.SimpleLinkedListImpl;

public class Main_HW4 {

    public static void main(String[] args) {
        LinkedList<Integer> list = new SimpleLinkedListImpl<>();
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);

        displayAll(list);

        System.out.println("-----------");

        ListIterator<Integer> iterator = (ListIterator<Integer>) list.iterator();
        iterator.reset();
        iterator.insertAfter(10);
        iterator.next();
        iterator.remove();
        iterator.insertBefore(-5);

        displayAll(list);
        System.out.println("-----------");

        iterator = (ListIterator<Integer>) list.iterator();
        while (iterator.hasNext()) {
            iterator.remove();
            System.out.println("-----------");
            displayAll(list);
        }

    }

    private static void displayAll(LinkedList<Integer> list) {
        for (Integer value : list) {
            System.out.println(value);
        }
    }
}
