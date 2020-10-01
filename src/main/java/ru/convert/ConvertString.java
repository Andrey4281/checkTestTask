
package ru.convert;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Класс ConvertString создан для конвертации из числа указанного прописью в число указанное цифраци.
 * для вызва функционала надо вызвать метод numberToString.
 * Например: входящее значение - "сто", исходящее - 100
 *         ConvertString num = new ConvertString();
 *         int result = num.numberToString("сто");
 */

public class ConvertString {

    private HashMap<String, Integer> map = new HashMap<>();


    public ConvertString() {
        init();
    }

    private void init() {
        map.put("ноль", 0);
        map.put("один", 1);
        map.put("два", 2);
        map.put("три", 3);
        map.put("четыре", 4);
        map.put("пять", 5);
        map.put("шесть", 6);
        map.put("семь", 7);
        map.put("восемь", 8);
        map.put("девять", 9);
        map.put("десять", 10);
        map.put("одиннадцать", 11);
        map.put("двенадцать", 12);
        map.put("тринадцать", 13);
        map.put("четырнадцать", 14);
        map.put("пятнадцать", 15);
        map.put("шестнадцать", 16);
        map.put("семнадцать", 17);
        map.put("восемнадцать", 18);
        map.put("девятнадцать", 19);
        map.put("сто", 100);
        map.put("сорок", 40);
        map.put("девятьсот", 900);
        //TODO сюда можно добавить 20 .. 90 100 и тд
    }

    //TODO слишком длинный метод, мб стоит разбить? А то так код тяжело читать
    public int stringToNumber(String num)  {

        int result = -1;

        String str = num.toLowerCase();
        //TODO 1. Почему здесь не используются регулярное выражение для символа "пробел"???
        // это мелочь но так - если между словами два пробела \\w
        List<String> listNum = List.of(str.split(" "));

        //TODO зачем здесь if else?? Код выглядит нечитабельным, можно просто написать switch
        //TODO еще более лучщее решение использовать паттерн Dispatcher с функциональными интерфейсами и хэш картой
        if (listNum.size() == 1) {
            return oneWord(listNum.get(0));
        } else if (listNum.size() == 2) {
            result = twoWord(listNum.get(0), listNum.get(1));
            if (result == -1) {
                result = twoWordLessTen(listNum.get(0), listNum.get(1));
                if (result == -1) {
                    result = Integer.parseInt(twoStringNumber(listNum.get(0), listNum.get(1)));
                }
            }
            return result;
        } else if (listNum.size() == 3) {
            result = threeWord(listNum.get(0), listNum.get(1), listNum.get(2));
            if (result == -1) {
                result = threeWordLessTen(listNum.get(0), listNum.get(1), listNum.get(2));
                if (result == -1) {
                    result = threeStringNumber(listNum.get(0), listNum.get(1), listNum.get(2));
                }
            }
        } else {
            throw new IllegalArgumentException("Input number is not right. The number must be between 0 and 999.");
        }

         if (result == -1) {
            throw new IllegalArgumentException("Input number is not right. The number must be between 0 and 999.");
        }

        return result;
    }

    private int threeStringNumber(String first, String second, String third) {
        String num = "";
        if (first.length() == 0 || second.length() == 0 || third.length() == 0) {
            throw new NullPointerException("input number is empty. The number must be between 0 and 999.");
        }
        num = twoStringNumber(first, second);
        int ten = toNumberLessTen(third);

        if (num.length() == 0 || ten == -1) {
            num = twoStringNumber(second, third);
            int thousand = toNumber(first);
            if (num.length() == 0 || thousand == -1) {
                return -1;
            } else {
                return Integer.parseInt(Integer.toString(thousand) + num);
            }
        } else {
            return Integer.parseInt(num + Integer.toString(ten));
        }

//        return -1;
    }

    private String twoStringNumber(String first, String second) {
        String num = "";
        if (first.length() == 0 || second.length() == 0) {
            throw new NullPointerException("input number is empty. The number must be between 0 and 999.");
        }

        if (first.equals("два") || first.equals("две")) {
            String scnd = Integer.toString(toNumber(second));
            if (!scnd.equals("-1")) {
                return String.join("", Collections.nCopies(2, scnd));
            }
        }

        return "";
    }

    private int toNumber(String num) {

        if (num.length() == 0) {
            throw new NullPointerException("input number is empty. The number must be between 0 and 999.");
        }

        List<String> str = List.of("нуля", "единици", "двойки", "тройки", "четверки", "пятерки", "шестерки", "семерки", "восмерки", "девятки");
        List<String> strSecond = List.of("", "единица", "двойка", "тройка", "четверка", "пятерка", "шестерка", "семерка", "восмерка", "девятка");

        if (str.indexOf(num) == -1) {
            return strSecond.indexOf(num) != -1 ? strSecond.indexOf(num) : -1;
        } else {
            return str.indexOf(num) != -1 ? str.indexOf(num) : -1;
        }
    }

    private int twoWordLessTen(String first, String second) {

        if (first.length() == 0 || second.length() == 0) {
            throw new NullPointerException("input number is empty. The number must be between 0 and 999.");
        }

        int hundred = toNumberLessTen(first);
        int ten = toNumberLessTen(second);

//        if (hundred == -1 || ten == -1) {
//            throw new IllegalArgumentException("Input number is not right. The number must be between 0 and 999.");
//        }
        return (hundred == -1 || ten == -1) ? -1 : (hundred * 10) + ten;
    }

    private int threeWordLessTen(String first, String second, String third) {

        if (first.length() == 0 || second.length() == 0 || third.length() == 0) {
            throw new NullPointerException("input number is empty. The number must be between 0 and 999.");
        }

        //TODO методы toNumberLessTen, toNumberLessTen
        int thousand = toNumberLessTen(first);
        int hundred = toNumberLessTen(second);
        int ten = toNumberLessTen(third);

        if (thousand == -1 || hundred == -1 || ten == -1) {
            return -1;
        }
        return (thousand * 100) + (hundred * 10) + ten;
    }

    private int oneWord(String first) {

        if (first.length() == 0) {
            throw new NullPointerException("input number is empty. The number must be between 0 and 999.");
        }

        //TODO зачем это если можно использовать хэшкарты? Так лучще и читабельнее
        Integer result = map.get(first);
//        result = toNumberLessTen(first);
//
//        if (result == -1) {
//            result = toNumberLessHundred(first);
//            if (result == -1) {
//                result = toNumberLessThousand(first);
//            }
//        }

        if (result == null) {
            throw new IllegalArgumentException("Input number is not right. The number must be between 0 and 999.");
        }

        return result;
    }

    private int twoWord(String first, String second) {

        if (first.length() == 0 || second.length() == 0) {
            throw new NullPointerException("input number is empty. The number must be between 0 and 999.");
        }

        //TODO зачем эти методы вообще? Вместо них можно занести все слова в словарь в init
        //TODO и просто дергать map.get(first) и map.get(second)..Не нужно плодить лишний код
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
                    return -1;
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
            return -1;
        }
        return thousand + hundred + ten;
    }

    private int toNumberLessTen(String num) {

        //TODO зачем при вызове метода каждый раз создавать словарь?
        //TODO весь словарь можно создать в методе init() один раз
        List<String> str = List.of("ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять",
                "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать");

        return str.indexOf(num) != -1 ? str.indexOf(num) : -1;
    }

    private int toNumberLessHundred(String num) {

        //TODO зачем при вызове метода каждый раз создавать словарь?
        //TODO весь словарь можно создать в методе init() один раз
        List<String> str = List.of("", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто");

        return str.indexOf(num) != -1 ? str.indexOf(num) * 10 : -1;
    }

    private int toNumberLessThousand(String num) {

        //TODO зачем при вызове метода каждый раз создавать словарь?
        //TODO весь словарь можно создать в методе init() один раз
        List<String> str = List.of("", "сто", "двести", "триста", "четыресто", "пятсот", "шестьсот", "семьсот", "восемьсот", "девятьсот");

        return str.indexOf(num) != -1 ? str.indexOf(num) * 100 : -1;
    }

    public static void main(String[] args) {
        String sRepeated = String.join("", Collections.nCopies(2, "*"));

        System.out.println("-1".equals("-1"));
    }
}
