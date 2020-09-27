package ru.convert;

import java.util.List;

public class ConvertNumber {

    public String numberToString(int num)  {

        String result = "";

        if (num < 0 || num > 999) {
            throw new IllegalArgumentException("Input number is not right. The number must be between 0 and 900.");
        }

        String numString =  Integer.toString(num);
        List<String> listNum = List.of(numString.split(""));

        if (listNum.size() == 1) {
            result =  toStringLessTen(Integer.parseInt(listNum.get(0)), 0);
        } else if (listNum.size() == 2) {
            int numbr = Integer.parseInt(listNum.get(0) + listNum.get(1));
            if (numbr >= 11 && numbr <= 19) {
                result = toStringLessTwenty(numbr);
            } else {
                result = toStringLessHundred(Integer.parseInt(listNum.get(0)))
                        + " " + toStringLessTen(Integer.parseInt(listNum.get(1)), 1);
            }
        } else if (listNum.size() == 3) {

            int numbr = Integer.parseInt(listNum.get(1) + listNum.get(2));
            if (numbr >= 11 && numbr <= 19) {
                result = toStringLessThousand(Integer.parseInt(listNum.get(0))) + " " + toStringLessTwenty(numbr);
            } else {
                result = toStringLessThousand(Integer.parseInt(listNum.get(0)))
                        + " " + toStringLessHundred(Integer.parseInt(listNum.get(1)))
                        + " " + toStringLessTen(Integer.parseInt(listNum.get(2)), 1);
            }
        }
        return result.replaceAll("\\s{2,}", " ").trim();
    }

    private String toStringLessTwenty(int num) {


        List<String> str = List.of("одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать");

        return str.get(num - 11);
    }

    private String toStringLessTen(int num, int isMoreTen) {

        String result = (isMoreTen == 1) ? "" : "ноль";

        List<String> str = List.of(result, "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "");

        return str.get(num);
    }

    private String toStringLessHundred(int num) {

        List<String> str = List.of("", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто");

        return str.get(num);
    }

    private String toStringLessThousand(int num) {

        List<String> str = List.of("", "сто", "двести", "тристо", "четыресто", "пятсот", "шестьсот", "семьсот", "восемьсот", "девятьсот");

        return str.get(num);
    }
}
