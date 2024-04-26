package org.example;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Prisoner prisoner = enterPrisonerData();
        Guard guard = enterGuardData();

        // Вывод информации о заключенном и охраннике
        System.out.println("Информация о заключенном:");
        printPersonInfo(prisoner);
        System.out.println("\nИнформация об охраннике:");
        printPersonInfo(guard);
    }

    // Функция для ввода данных о заключенном
    public static Prisoner enterPrisonerData() {
        Prisoner prisoner = new Prisoner();

        System.out.println("Введите номер камеры:");
        int cellNumber = scanner.nextInt();
        prisoner.setCellNumber(cellNumber);

        System.out.println("Введите срок заключения в месяцах:");
        int monthsInPrison = scanner.nextInt();
        prisoner.setMonthsInPrison(monthsInPrison);

        System.out.println("Опасный ли заключенный? (true/false):");
        boolean isDangerous = scanner.nextBoolean();
        prisoner.setDangerous(isDangerous);

        System.out.println("Введите имя заключенного:");
        String name = scanner.next();
        prisoner.setName(name);

        System.out.println("Введите возраст заключенного:");
        int age = scanner.nextInt();
        prisoner.setAge(age);

        // Дополнительно вычисляем общий срок заключения и категорию заключенного
        int totalSentence = prisoner.getMonthsInPrison();
        String category = prisonerCategory(totalSentence);

        prisoner.setTotalSentence(totalSentence);
        prisoner.setCategory(category);

        System.out.println("Агрессивный ли заключенный? (true/false):");
        boolean isAggressive = scanner.nextBoolean();
        prisoner.setAggressive(isAggressive);

        System.out.println("Является ли заключенный рецидивистом? (true/false):");
        boolean isRecidivist = scanner.nextBoolean();
        prisoner.setRecidivist(isRecidivist);

        int daysUntilRelease = daysUntilRelease(prisoner.getTotalSentence());
        prisoner.setDaysUntilRelease(daysUntilRelease);

        return prisoner;
    }

    // Функция для ввода данных об охраннике
    public static Guard enterGuardData() {
        Guard guard = new Guard();

        System.out.println("Введите имя охранника:");
        String name = scanner.next();
        guard.setName(name);

        System.out.println("Введите возраст охранника:");
        int age = scanner.nextInt();
        guard.setAge(age);

        System.out.println("Введите звание охранника:");
        String rank = scanner.next();
        guard.setRank(rank);

        return guard;
    }

    // Функция для определения категории заключенного по сроку
    public static String prisonerCategory(int months) {
        if (months < 12) {
            return "Легкий режим";
        } else if (months >= 12 && months < 60) {
            return "Средний режим";
        } else {
            return "Строгий режим";
        }
    }

    // Функция для вычисления времени до освобождения заключенного в днях
    public static int daysUntilRelease(int remainingMonths) {
        return remainingMonths * 30; // Предполагаем, что в месяце 30 дней
    }

    // Функция для вывода информации о персоне (заключенном или охраннике)
    public static void printPersonInfo(Person person) {
        System.out.println("Имя: " + person.getName());
        System.out.println("Возраст: " + person.getAge());
        System.out.println("Тип: " + person.getType());
    }
}

abstract class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Абстрактный метод, возвращающий тип персоны
    public abstract String getType();
}

class Prisoner extends Person {
    private int cellNumber;
    private int monthsInPrison;
    private boolean dangerous;
    private int totalSentence;
    private String category;
    private boolean aggressive;
    private boolean recidivist;
    private int daysUntilRelease;

    public int getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(int cellNumber) {
        this.cellNumber = cellNumber;
    }

    public int getMonthsInPrison() {
        return monthsInPrison;
    }

    public void setMonthsInPrison(int monthsInPrison) {
        this.monthsInPrison = monthsInPrison;
    }

    public boolean isDangerous() {
        return dangerous;
    }

    public void setDangerous(boolean dangerous) {
        this.dangerous = dangerous;
    }

    public int getTotalSentence() {
        return totalSentence;
    }

    public void setTotalSentence(int totalSentence) {
        this.totalSentence = totalSentence;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAggressive() {
        return aggressive;
    }

    public void setAggressive(boolean aggressive) {
        this.aggressive = aggressive;
    }

    public boolean isRecidivist() {
        return recidivist;
    }

    public void setRecidivist(boolean recidivist) {
        this.recidivist = recidivist;
    }

    public int getDaysUntilRelease() {
        return daysUntilRelease;
    }

    public void setDaysUntilRelease(int daysUntilRelease) {
        this.daysUntilRelease = daysUntilRelease;
    }

    @Override
    public String getType() {
        return "Заключенный";
    }
}

class Guard extends Person {
    private String rank;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String getType() {
        return "Охранник";
    }
}
