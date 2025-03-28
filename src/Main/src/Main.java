package Main.src;

import java.util.Scanner;

class Main {
    public static String calc(String input) {
        try {
            String[] tokens = input.split(" ");
            if (tokens.length != 3) {
                throw new IllegalArgumentException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }

            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[2]);
            String operation = tokens[1];

            if (a < 1 || a > 10 || b < 1 || b > 10) {
                throw new IllegalArgumentException("Числа могут быть только от 1 до 10 включительно");
            }

            int result;
            switch (operation) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    result = a / b;
                    break;
                default:
                    throw new IllegalArgumentException("Неверная операция");
            }

            return String.valueOf(result);

        } catch (NumberFormatException e) {
            return "Ошибка: Строка не является математической операцией";
        } catch (IllegalArgumentException e) {
            return "Ошибка: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение (например, 1 + 9):");

        while (true) {
            String input = scanner.nextLine();
            String result = calc(input);
            System.out.println("Результат: " + result);

            if (result.startsWith("Ошибка")) {
                break;
            }
        }

        scanner.close();
        System.out.println("Завершение работы.");
    }
}
