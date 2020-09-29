
package ru.convert;

import java.util.List;

/**
 * Класс ConvertString создан для конвертации из числа указанного прописью в число указанное цифраци.
 * для вызва функционала надо вызвать метод numberToString.
 * Например: входящее значение - "сто", исходящее - 100
 *         ConvertString num = new ConvertString();
 *         int result = num.numberToString("сто");
 */

public class ConvertString {

    public int stringToNumber(String num)  {
        List<String> listNum = List.of(num.split(" "));

        if (listNum.size() == 1) {
            return oneWord(listNum.get(0));
        } else if (listNum.size() == 2) {
            return twoWord(listNum.get(0), listNum.get(1));
        } else if (listNum.size() == 3) {
            return threeWord(listNum.get(0), listNum.get(1), listNum.get(2));
        } else {
            throw new IllegalArgumentException("Input number is not right. The number must be between 0 and 999.");
        }
    }

    private int oneWord(String first) {
        int result = -1;

        if (first.length() == 0) {
            throw new NullPointerException("input number is empty. The number must be between 0 and 999.");
        }

        result = toNumberLessTen(first);

        if (result == -1) {
            result = toNumberLessHundred(first);
            if (result == -1) {
                result = toNumberLessThousand(first);
            }
        }

        if (result == -1) {
            throw new IllegalArgumentException("Input number is not right. The number must be between 0 and 999.");
        }

        return result;
    }

    private int twoWord(String first, String second) {

        if (first.length() == 0 || second.length() == 0) {
            throw new NullPointerException("input number is empty. The number must be between 0 and 999.");
        }


        int thousand = toNumberLessThousand(first);
        int hundred = toNumberLessHundred(second);
        int ten = -1;

        if (thousand != -1 && hundred != -1) {
            return thousand + hundred;
        } else {
            thousand = toNumberLessThousand(first);
            ten = toNumberLessTen(second);

            if (thousand != -1 && ten != -1) {
                return thousand + ten;
            } else {
                hundred = toNumberLessHundred(first);
                ten = toNumberLessTen(second);

                if (hundred != -1 && ten != -1) {
                    return hundred + ten;
                } else {
                    throw new IllegalArgumentException("Input number is not right. The number must be between 0 and 999.");
                }
            }
        }
    }

    private int threeWord(String first, String second, String third) {

        if (first.length() == 0 || second.length() == 0 || third.length() == 0) {
            throw new NullPointerException("input number is empty. The number must be between 0 and 999.");
        }

        int thousand = toNumberLessThousand(first);
        int hundred = toNumberLessHundred(second);
        int ten = toNumberLessTen(third);

        if (thousand == -1 || hundred == -1 || ten == -1) {
            throw new IllegalArgumentException("Input number is not right. The number must be between 0 and 999.");
        }
        return thousand + hundred + ten;
    }

    private int toNumberLessTen(String num) {

        List<String> str = List.of("ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять",
                "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать");

        return str.indexOf(num) != -1 ? str.indexOf(num) : -1;
    }

    private int toNumberLessHundred(String num) {

        List<String> str = List.of("", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто");

        return str.indexOf(num) != -1 ? str.indexOf(num) * 10 : -1;
    }

    private int toNumberLessThousand(String num) {

        List<String> str = List.of("", "сто", "двести", "тристо", "четыресто", "пятсот", "шестьсот", "семьсот", "восемьсот", "девятьсот");

        return str.indexOf(num) != -1 ? str.indexOf(num) * 100 : -1;
    }
}
