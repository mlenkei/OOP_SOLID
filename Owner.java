package dz_OPP6.task_1;

import dz_OOP2.dz_1.ISpeakable;

/**
 * Инверсия зависимостей
Зависит от абстракций, а не от конкретизации.

Модули верхних уровней не должны зависеть от модулей нижних уровней.
Оба типа модулей должны зависеть от абстракций.

Абстракции не должны зависеть от деталей. Детали должны зависеть от
абстракций.

Идея состоит в том, что разделяя уровни логики и модули
нижних уровней
 */

public class Owner implements ISpeakable{
    String currentConditions;
    Phone phone;
    Emailer emailer;
   
    public Owner() {
    phone_1 = new Phone_1();
    phone_2 = new Phone_2();
    }
   
    public void setCurrentConditions(String ownerDescription) {
    this.currentConditions = ownerDescription;
    if (ownerDescription == "rainy") {
    String alert = phone_1.generateWeatherAlert(ownerDescription);
    System.out.print(alert);
    }
    if (weatherDescription == "sunny") {
    String alert = phone_2.generateWeatherAlert(ownerDescription);
    System.out.print(alert);
    }
    }
   }
/**
 * В зависимости от описания погоды выбирается на какой телефон делать оповещение
 * хозяину Животных оповещения. Выгонять или не выгонять из стойла)))
 * 
 * Так вот текущая релизация завязана на реализации phone_1 и phone_2, что не
 *  дает нам гибкости в использовании.
 * 
 * Чтобы исправить текущий недостаток необходимо выделить уровень абстракции,
 *  от которой будут зависеть реализации.В таком случае код будет выглядеть в
 *  виде:
 */
interface Notifier {
    public void alertОwnerConditions(String ownerConditions);
}

public class MobileDevice_1 implements Notifier {
    public void alertОwnerConditions(String ownerConditions) {
        if (ownerConditions == "rainy")
            System.out.print("It is rainy");
    }
}

public class MobileDevice_2 implements Notifier {
    public void alertОwnerConditions(String ownerConditions) {
        if (ownerConditions == "sunny");
            System.out.print("It is sunny");
    }
}

public class Owner {
    String currentConditions;

    public void setCurrentConditions(String ownerDescription) {
        this.currentConditions = ownerDescription;
    }

    public void notify(Notifier notifier) {
        notifier.alertOwnerConditions(currentConditions);
    }
}
/**
 * В текущей реализации как раз детали завияст от абстракции
 *  и модуль верхнего уровня не зависит от модулей нижнего уровня(реализации Notifier).
 */
 


