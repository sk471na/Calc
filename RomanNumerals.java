package Calc;

import java.util.Collection;
import java.util.TreeMap;

class RomanNumerals {

    private static final TreeMap<Character, Integer> romanNumerals = new TreeMap<>();

    static {
        romanNumerals.put('I', 1);
        romanNumerals.put('V', 5);
        romanNumerals.put('X', 10);
        romanNumerals.put('L', 50);
        romanNumerals.put('C', 100);
        romanNumerals.put('D', 500);
        romanNumerals.put('M', 1000);
    }

    public static int toArabic(String romanNumber) {
        int result = 0;
        for (int i = 0; i < romanNumber.length(); i++) {
            int currentValue = romanNumerals.get(romanNumber.charAt(i));

            // Если предыдущая цифра больше текущей, то вычитаем её
            if (i > 0 && romanNumerals.get(romanNumber.charAt(i - 1)) > currentValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
        }

        return result;
    }

    public static Collection<Integer> values() {
        return romanNumerals.values();
    }

    public class Value {

        private int value;

        public Value(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public String toRoman() {
            if (value <= 10) {
                return String.valueOf(value);
            } else {
                try {
                    return RomanNumerals.toRoman(value);
                } catch (IllegalArgumentException e) {
                    // обработка исключения, если необходимо
                    return "Invalid input";
                }
            }
        }

        public String toArabic() {
            return String.valueOf(value);
        }
    }

    public static String toRoman(int arabicNumber) {
        if (arabicNumber <= 0) {
            throw new IllegalArgumentException("Неверное число");
        }

        StringBuilder romanNumber = new StringBuilder();

        for (int i = 0; arabicNumber > 0; i++) {
            int currentValue = RomanNumerals.romanNumerals.keySet().toArray(new Character[0])[i];

            // Если число больше текущего значения, то добавляем его
            while (arabicNumber >= currentValue) {
                romanNumber.append(RomanNumerals.romanNumerals.keySet().toArray(new Character[0])[i]);
                arabicNumber -= currentValue;
            }
        }

        return romanNumber.toString();
    }
}
