package org.example; // Загружаем нужные библиотеки
import java.util.Scanner;

public class Main { // Создание класса Main
    private static final double radiusEarth = 6371.0; // Радиус Земли в километрах

    private static double toRadians(double num) {  // Метод для преобразования градусов в радианы
        return num * Math.PI / 180.0;
    }

    // Метод для вычисления расстояния между двумя точками по их географическим координатам
    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {

        // Преобразование координат в радианы
        lat1 = toRadians(lat1);
        lon1 = toRadians(lon1);
        lat2 = toRadians(lat2);
        lon2 = toRadians(lon2);

        double dLat = lat2 - lat1; // Разница между широтами и долготами
        double dLon = lon2 - lon1;

        // Формула гаверсинусов для вычисления расстояния на сфере
        double i = Math.pow(Math.sin(dLat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dLon / 2), 2);
        double n = 2 * Math.atan2(Math.sqrt(i), Math.sqrt(1 - i));

        return radiusEarth * n; // Вычисление расстояния
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Создаем объект Scanner для считывания ввода с клавиатуры

        // Ввод координат первой точки
        System.out.println("Введите широту первой точки (в градусах):");
        double lat1 = scanner.nextDouble();
        System.out.println("Введите долготу первой точки (в градусах):");
        double lon1 = scanner.nextDouble();

        // Ввод координат второй точки
        System.out.println("Введите широту второй точки (в градусах):");
        double lat2 = scanner.nextDouble();
        System.out.println("Введите долготу второй точки (в градусах):");
        double lon2 = scanner.nextDouble();

        // Вычисление расстояния
        double distance = calculateDistance(lat1, lon1, lat2, lon2);
        System.out.println("Расстояние между вашими точками: " + distance + " км");

        scanner.close();
    }
}
