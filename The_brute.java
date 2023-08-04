package dz_OPP6.task_1;
/**
 * Принцип единой ответственности - SRP
У класса должна быть одна, и только одна, причина для изменения.
Класс должен иметь только одну причину для изменения.   
 */

import dz_OOP2.dz_1.ISpeakable;

/**
 * Каждый класс должен иметь одну обязанность(ответственность за что-то)
 *  и эта обязанность должна быть полностью инкапсулирована в классе.
 * Для примера рассмотрим class The_brute, который занимается "обьединением" домашнего скота.
 * 
 * Из-за того, что класс ответственен сразу за несколько задач в дальнейшем могут возникнуть
 * сложности в поддержке работоспособности кода, в гибкости использования сервиса и т.д
 * 
 * SRP говорит как раз о том, что надо разделить такой класс на несколько классов,
 *  чтобы каждый класс был ответственен за свою область. Один класс отвечает за "действие" Животных,
 *  другой - за окрас, кличку, породу, звуки и т.д..
 * 
 * В таком случае запрашиваеться сначала один класс, потом другой по порядку.
 * Следование SRP принципу даст нам слабо связанное приложение, которое будет
 * легко изменять и дорабатывать в дальнейшем.
 */

public class The_brute {
    public abstract class The_brute implements ISpeakable{

    private String name;
    private int box;

    public The_brute(String name, int box) {
        this.name = name;
        this.box = box;
    }

    @Override
    public String toString() {
        String text = String.format("name: %s, box: %d", this.name, this.box);

        return text;
    }

    public abstract String say();
}
}
/**
 * в частности Class Cat:
 */
public class Cat extends The_brute implements IRunable{

    private String color;

    public Cat(String name, int box, String color) {
        super(name, box);
        this.color = color;
    }

    @Override
    public int speedOfRun() {
        return 15;
    }

    @Override
    public String say() {
        return "Мяу";
    }

    @Override
    public String toString() {
        return String.format("Cat: %s, colour: %s", super.toString(), this.color);
    }
}
/**
 * ....Class Ram
 */
public class Ram extends The_brute implements IRunable, ISwimable{
    private String wool;
    public Ram(String name, int box, String wool) {
        super(name, box);
        this.wool = wool;
    }
    @Override
    public int speedOfSwim() {
        return 5;
    }
    @Override
    public int speedOfRun() {
        return 8;
    }

    @Override
    public String say() {
        return "Бее бее";
    }
    @Override
    public String toString() {
        return String.format("Ram: %s, wool: %s", super.toString(), this.wool);
    }
}
/**
 * и другие
 * 
 * Следовательно SRP принцип дает нам слабо связанное приложение,
 *  которое будет легко изменять и дорабатывать в дальнейшем.
 */