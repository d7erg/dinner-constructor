package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    System.out.println("Введите тип блюда:");
                    String dishType = scanner.nextLine();
                    System.out.println("Введите название блюда:");
                    String dishName = scanner.nextLine();
                    dc.addNewDish(dishType, dishName);
                    break;
                case "2":
                    if (!dc.dishesByType.isEmpty()) {
                        System.out.println("Начинаем конструировать обед...");
                        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
                        int numberOfCombos = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
                        String nextItem = scanner.nextLine();
                        ArrayList<String> dishesType = new ArrayList<>();
                        while (!nextItem.isEmpty()) {
                            if (dc.checkType(nextItem)) {
                                dishesType.add(nextItem);
                            } else {
                                System.out.println("Тип блюда не существует, введите другой тип");
                            }
                            nextItem = scanner.nextLine();
                        }
                        dc.generateDishCombo(numberOfCombos, dishesType);
                    } else {
                        System.out.println("Список пуст.");
                    }
                    break;
                case "3":
                    System.out.println("Программа завершилась.");
                    return;
                default:
                    System.out.println("Команды не существует!");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }
}
