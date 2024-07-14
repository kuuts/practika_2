import java.util.Scanner;
import java.lang.Math;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите операцию: ");
            System.out.println("1. Сложение");
            System.out.println("2. Вычитание");
            System.out.println("3. Умножение");
            System.out.println("4. Деление");
            System.out.println("5. Квадратный корень");
            System.out.println("6. Возведение в степень");
            System.out.println("7. Синус");
            System.out.println("8. Косинус");
            System.out.println("9. Тангенс");
            System.out.println("10. Выход");

            int choice = scanner.nextInt();
            if (choice == 10) {
                System.out.println("Выход из программы.");
                break;
            }

            double num1 = 0, num2 = 0;
            if (choice >= 1 && choice <= 4 || choice == 6) {
                System.out.println("Введите первое число: ");
                num1 = scanner.nextDouble();
                System.out.println("Введите второе число: ");
                num2 = scanner.nextDouble();
            } else if (choice == 5 || choice >= 7 && choice <= 9) {
                System.out.println("Введите число: ");
                num1 = scanner.nextDouble();
            }

            switch (choice) {
                case 1:
                    System.out.println("Результат: " + (num1 + num2));
                    break;
                case 2:
                    System.out.println("Результат: " + (num1 - num2));
                    break;
                case 3:
                    System.out.println("Результат: " + (num1 * num2));
                    break;
                case 4:
                    if (num2 != 0) {
                        System.out.println("Результат: " + (num1 / num2));
                    } else {
                        System.out.println("Ошибка: деление на ноль.");
                    }
                    break;
                case 5:
                    if (num1 >= 0) {
                        System.out.println("Результат: " + Math.sqrt(num1));
                    } else {
                        System.out.println("Ошибка: отрицательное число.");
                    }
                    break;
                case 6:
                    System.out.println("Результат: " + Math.pow(num1, num2));
                    break;
                case 7:
                    System.out.println("Результат: " + Math.sin(num1));
                    break;
                case 8:
                    System.out.println("Результат: " + Math.cos(num1));
                    break;
                case 9:
                    System.out.println("Результат: " + Math.tan(num1));
                    break;
                default:
                    System.out.println("Ошибка: неверный выбор.");
            }
        }
        scanner.close();
    }
}
