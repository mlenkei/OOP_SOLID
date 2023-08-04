package dz_OPP6.task_1;
/**
 * Принцип открытого / закрытого
 * Т.е класс должен быть закрыт к изменению извне, но при этом - 
 * должен иметь возможности к расширению реализации.

В качестве примера рассмотрим класс Cat, отвечающий за котиков:
 */

public class Cat {
    /**
     * Без Solid
     */
    String formality;

    public String cat() {
        if (this.formality == "первая") {
            return "Cat вислоухая";
        }
        else if (this.formality == "вторая") {
            return "Cat сиамская";
        }
        else if (this.formality == "третья") {
            return "Cat британская";
        }
        else {
            return "Безродная";
        }
    }

    public void setFormality(String formality) {
        this.formality = formality;
    }
}
/**
 * В зависимости от 'формальности' мы подбираем породу кошек.

Данный код плох, тем, что при добавлении новой породs кошки, необходимо изменять код Cat, класс не открыт для расширения.

В то же время, если постараться сделать его более расширяемым можно ввести понятие интерфейса Personality, отвечающего за то, какое приветствие будет:
 */
public class Cat {
    private Personality personality;

    public Cat(Personality personality) {
            this.personality = personality;
        }

    public String cat() {
        return personality.cat();
    }
}

/**
 * Причем интерфейс Personality:
 */
public class  FormalPersonality implements Personality {
    public String cat() {
    return "Cat good";
    }
}
/**
 * Класс Cat спроектирован так, что открыт для расширения,
 *  мы можем передать любой Personality, в зависимости от задачи.
 *  И получим необходимый результат. При этом сам код Cat не изменяется.
 * Т.е классы и модули должны проектироваться так, чтобы для изменения их
 *  поведения, нам не нужно было изменять их исходный код.
 * В этом и состоит суть OCP принципа.
 */