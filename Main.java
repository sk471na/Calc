package Calc;

import java.util.Scanner;

public class Main {

    public static String calculate(String input) throws Exception {
        // Разделяем строку на две части: число и операцию
        String[] parts = input.split(" ");
        if (parts.length != 2) {
            throw new Exception("Неверная строка ввода");
        }

        // Получаем числа в арабских или римских цифрах
        int a = getNumber(parts[0]);
        int b = getNumber(parts[1]);

        // Выполняем арифметическую операцию
        int result = 0;
        switch (parts[2]) {
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
        }

        // Преобразуем результат в нужный формат
        return formatNumber(result);
    }

    private static int getNumber(String number) throws Exception {
        if (number.matches("[0-9]+")) {
            // Арабские цифры
            return Integer.parseInt(number);
        } else if (number.matches("[IVXLCDM]+")) {
            // Римские цифры
            return RomanNumerals.toArabic(number);
        } else {
            throw new Exception("Неверное число");
        }
    }

    private static String formatNumber(int number) throws Exception {
        if (number <= 10) {
            // Число в пределах от 1 до 10
            return String.valueOf(number);
        } else {
            // Число больше 10
            return RomanNumerals.toRoman(number);
        }
    }

}
