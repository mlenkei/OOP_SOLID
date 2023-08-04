package dz_OPP6.task_1;

import dz_OOP2.dz_1.IJumping;
import dz_OOP2.dz_1.IRunable;
import dz_OOP2.dz_1.ISwimable;

/**
 * Принцип подстановки Лискова
 * 
 * Функции, которые используют базовый тип, должны иметь возможность
 *  использовать подтипы базового типа, не зная об этом.
 * 
 * Объекты могут быть заменены их наследниками без изменения свойств программы.
 * 
 * В качестве примера рассмотрим класс Poultry(домашняя птица).
 * Poultry – это класс, в котором есть два метода – eat () и fly (). Он представляет
 *  собой базовый класс, который может расширять любой тип птиц.
 */
public class Poultry {
    
     public void eat() {
        System.out.println("I can eat.");
    }
    public void fly() {
        System.out.println("I can fly.");
    }
}
/**
 * Duck (Утка) – это птица, которая умеет есть и плавать.
 *  Следовательно, он может наследоваться от класса Poultry.
 */
public class Duck extends Poultry {

    @Override
    public void eat() {
        System.out.println("OMG! I can eat pizza!");
    }
    @Override
    public void swim() {
        System.out.println("I believe I can swim!");
    }
}
/**
 * Main – это основной класс нашей программы, который содержит все логику.
 * У него есть два метода: letPoultrySwim (List poultrys) и main (String [] args).
 *  Первый метод принимает список птиц в качестве параметра и вызывает
 *  их методы полета. Второй создает список и передает его первому.
 */
public class Main {
    public static void letPoultrysSwim(List<Poultry> poultrys) {
        for(Poultry poultry: poultrys) {
            poultry.swim();
        }
    }
    public static void main(String[] args) {
        List<Poultry> poultrys = new ArrayList<Poultry>();
        birds.add(new Poultry());
        letBirdsSwim(poultrys);
    }
}
/**
 * Программа просто создает список птиц и позволяет им плавать.
 * Если попытаеvcz запустить эту программу, она выдаст следующий
 * результат:"I can swim."
 * 
 * Если теперь попробуем применить определение этого принципа
 * к нашему основному методу и посмотрим, что произойдет.
 * Мы собираемся заменить объект Poultry на объект Duck.
 */

 public static void main(String[] args) {
    List<Poultry> poultrys = new ArrayList<Poultry>();       
    poultry.add(new Duck());
    letPoultrysSwim(poultrys);
}
запустим программу- после применения изменений, она выдаст
следующий оператор:"I believe I can swim!"(Я верю, что могу плавать!)

/**
 * Мы видим, что все ок- принцип отлично применим к нашему коду.
 * Программа работает как положено, без ошибок и проблем. Но что, 
 * если мы попытаемся расширить класс Poultry новым типом птиц,
 * которые не умеют плавать? Курица например.
 */

public class Chicken extends Poultry {
    @Override
    public void eat() {
        System.out.println("Can I eat taco?");
    }
    @Override
    public void swim() {
        throw new UnsupportedOperationException("Help! I cannot swim!");
    }
}
/**
 * Проверим, применим ли этот принцип к коду 
 * или нет, добавив объект Chicken в список птиц и запустив код.
 */

public static void main(String[] args) {
    List<Poultry> poultrys = new ArrayList<Poultry>();       
    poultrys.add(new Duck());
    poultrys.add(new Chicken());
    letPoultrysSwim(poultrys);
}
/**
 * Получаем: 
 * I believe I can swim!
 * Exception in thread "main" 
 * java.lang.UnsupportedOperationException: Help! I cannot swim!
 * 
 * Не прокатило
 * 
 * Видим, что с объектом Duck код работал отлично. Но с объектом
 * Chicken код выдал исключение UnsupportedOperationException.
 * Этот код нарушает принцип подстановки Лисков, поскольку у 
 * класса Poultry есть дочерний элемент, который неправильно
 * использовал наследование и, следовательно, вызвал проблему.
 *  Chicken пытается расширить логику плавания, но она не умеет плавать!
 * 
 * Решаем проблему так:
 */

 public static void letPoultrysSwim(List<Poultry> poultrys) {
    for(Poultry poultry: poultrys) {
        if(!(poultry instanceof Chicken)) {
            poultry.swim();
        }
    }
}
/**
 * Но это решение плохое, и оно нарушает
 * принцип Open Closed.
 */

 /**
  * Решения изменения принципа – выделить логику плавания в другой класс.
  */

public class Poultry {
    public void eat() {
        System.out.println("I can eat.");
    }
}

public class Duck extends SwimingPoultry {
    @Override
    public void eat() {
        System.out.println("OMG! I can eat!");
    }
    @Override
    public void swim() {
        System.out.println("I believe I can swim!");
    }
}
/**
 * и соответсвенно класс:
 */

public class Chicken extends Poultry {
    @Override
    void eat() {
        System.out.println("Can I eat?");
    }
}
/**
 * Теперь мы можем отредактировать метод letPoultrysSwim
 *  для поддержки только плавающих птиц птиц.
 */

public class Main {
    public static void letPoultrysSwim(List<SwimingPoultry> SwimingPoultrys) {
        for(SwimingPoultry swimingPoultry: swimingPoultrys) {
            swimingPoultry.swim();
        }
    }

    public static void main(String[] args) {
        List<SwimingPoultry> swimingPoultrys = new ArrayList<SwimingPoultry>();     
        swimingPoultry.add(new Swan());
        letPoultrysSwim(swimingPoultrys);
    }
}
/**
 * Заставили метод letPoultrysSwim принимать только плавающих птиц,
 * прикол в том, чтобы гарантировать, что любая замена PoultrysSwim сможет плавать.
 * Теперь программа работает должным образом и выводит следующий результат:"I believe I can swim!"
 * 
 * Принцип замещения Лисков заключается в правильном использовании
 *  отношения наследования. Создаем подтипы какого-либо родителя
 *  тогда и только тогда, когда они собираются правильно 
 * реализовать его логику, не вызывая никаких проблем!
 */