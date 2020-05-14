package lesson5.HW5;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {

        List<Item> items = new ArrayList<>();
        items.add(new Item("Книга",   1, 600));
        items.add(new Item("Бинокль", 2, 5000));
        items.add(new Item("Аптечка", 4, 1500));
        items.add(new Item("Ноутбук", 2, 40000));
        items.add(new Item("Котелок", 1, 500));


        Backpack backpack = new Backpack(5);
        backpack.calcBestSet(items);

        for (Item item : backpack.getBestSet()) {
            System.out.println(item.getName() + " " + item.getPrice());
        }

        System.out.println("Total best price is " + backpack.getBestPrice());
    }

}
