package org.example; // Загружаем нужные библиотеки
import java.util.Scanner;

public class Main { // Создание класса Main
    private static final double radiusEarth = 6371.0; // Радиус Земли в километрах

    private static double toRadians(double num) {  // Метод для преобразования градусов в радианы
        return num * Math.PI / 180.0;
    }

    // Метод для вычисления расстояния между двумя точками по их географическим координатам
    public static double calculateDistance(double Cdt1, double Cdn1, double Cdt2, double Cdn2) {

        // Преобразование координат в радианы
        Cdt1 = toRadians(Cdt1);
        Cdn1 = toRadians(Cdn1);
        Cdt2 = toRadians(Cdt2);
        Cdn2 = toRadians(Cdn2);


        double dLat = Cdt2 - Cdt1;// Разница между широтами и долготами
        double dLon = Cdn2 - Cdn1;

        // Формула гаверсинусов для вычисления расстояния на сфере
        double i = Math.pow(Math.sin(dLat / 2), 2) + Math.cos(Cdt1) * Math.cos(Cdn2) * Math.pow(Math.sin(dLon / 2), 2);
        double n = 2 * Math.atan2(Math.sqrt(i), Math.sqrt(1 - i));

        return radiusEarth * n; // Вычисление расстояния
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Создаем объект Scanner для считывания ввода с клавиатуры

        // Ввод координат первой точки
        System.out.println("Введите широту первой точки (в градусах):");
        double Cdt1 = scanner.nextDouble();
        System.out.println("Введите долготу первой точки (в градусах):");
        double Cdn1 = scanner.nextDouble();

        // Ввод координат второй точки
        System.out.println("Введите широту второй точки (в градусах):");
        double Cdt2 = scanner.nextDouble();
        System.out.println("Введите долготу второй точки (в градусах):");
        double Cdn2 = scanner.nextDouble();

        // Вычисление расстояния
        double distance = calculateDistance(1, 1, 2, 2);
        System.out.println("Расстояние между вашими точками: " + distance + " км");

        scanner.close();
    }
}
