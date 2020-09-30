package ru.convert;

import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConvertStringTest {

    @Test
    public void whenNumber0() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("ноль");

        assertThat(result, is(0));
    }

    @Test
    public void whenNumber2() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("два");

        assertThat(result, is(2));
    }

    @Test
    public void whenNumber5() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("пять");

        assertThat(result, is(5));
    }

    @Test
    public void whenNumber10() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("десять");

        assertThat(result, is(10));
    }

    @Test
    public void whenNumber11() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("одиннадцать");

        assertThat(result, is(11));
    }

    @Test
    public void whenNumber15() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("пятнадцать");

        assertThat(result, is(15));
    }

    @Test
    public void whenNumber123() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("сто двадцать три");

        assertThat(result, is(123));
    }

    @Test
    public void whenNumber291() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("двести девяносто один");

        assertThat(result, is(291));
    }

    @Test
    public void whenNumber999() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("девятьсот девяносто девять");

        assertThat(result, is(999));
    }

    @Test
    public void whenNumber900() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("девятьсот");

        assertThat(result, is(900));
    }

    @Test
    public void whenNumber100() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("сто");

        assertThat(result, is(100));
    }

    @Test
    public void whenNumber40() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("сорок");

        assertThat(result, is(40));
    }

    @Test
    public void whenNumber24() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("двадцать четыре");

        assertThat(result, is(24));
    }

    @Test
    public void whenNumber36() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("тридцать шесть");

        assertThat(result, is(36));
    }

    @Test
    public void whenNumber47() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("сорок семь");

        assertThat(result, is(47));
    }

    @Test
    public void whenNumber58() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("пятьдесят восемь");

        assertThat(result, is(58));
    }

    @Test
    public void whenNumber69() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("шестьдесят девять");

        assertThat(result, is(69));
    }

    @Test
    public void whenNumber72() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("семьдесят два");

        assertThat(result, is(72));
    }

    @Test
    public void whenNumber92() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("девяносто два");

        assertThat(result, is(92));
    }

    @Test
    public void whenNumber55() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("пятьдесят пять");

        assertThat(result, is(55));
    }

    @Test
    public void whenNumber101() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("сто один");

        assertThat(result, is(101));
    }

    @Test
    public void whenNumber313() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("триста тринадцать");

        assertThat(result, is(313));
    }

    @Test
    public void whenNumber416() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("четыресто шестнадцать");

        assertThat(result, is(416));
    }

    @Test
    public void whenNumber514() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("пятсот четырнадцать");

        assertThat(result, is(514));
    }

    @Test
    public void whenNumber617() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("шестьсот семнадцать");

        assertThat(result, is(617));
    }

    @Test
    public void whenNumber118() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("сто восемнадцать");

        assertThat(result, is(118));
    }

    @Test
    public void whenNumber719() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("семьсот девятнадцать");

        assertThat(result, is(719));
    }

    @Test
    public void whenNumber325() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("триста двадцать пять");

        assertThat(result, is(325));
    }

    @Test
    public void whenNumber17() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("семнадцать");

        assertThat(result, is(17));
    }

    @Test
    public void whenNumber81() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("восемьдесят один");

        assertThat(result, is(81));
    }

    @Test
    public void whenNumber3251() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("Три два пять");

        assertThat(result, is(325));
    }

    @Test
    public void whenNumber57() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("пять семь");

        assertThat(result, is(57));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenNumberError6171() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("шесттьсот семнадцать");
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenNumberError6172() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("шестьсот семнадцаать");
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenNumberError100() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("cсто");
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenNumberError2311() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("ддвести тридцать один");
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenNumberError2312() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("двести ттридцать один");
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenNumberError2313() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("двести тридцать одиин");
    }

    @Test (expected = NullPointerException.class)
    public void whenNumberErrorNull1() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("");
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenNumberErrorNull2() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber(" ");
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenNumberErrorNull3() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("  ");
    }

    @Test (expected = NullPointerException.class)
    public void whenNumberErrorNull4() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("девятьсот  девять");

        assertThat(result, is(999));
    }

    @Test
    public void whenNumber22() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("Две двойки");

        assertThat(result, is(22));
    }

    @Test
    public void whenNumber222() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("Две двойки два");

        assertThat(result, is(222));
    }

    @Test
    public void whenNumber100Right() {
        ConvertString num = new ConvertString();
        int result = num.stringToNumber("Единица два нуля");

        assertThat(result, is(100));
    }
}