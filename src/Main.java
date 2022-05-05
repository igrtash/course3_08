import java.awt.*;
import java.util.Optional;
import java.lang.reflect.Field;

/** Урок 6: Интерфейсы и Enum
 * Практические упражнения
 * Придумать индивидуальное семейство классов на основе разобранного примера
 * Создать два класса, которые будет наследовать поля и методы от абстрактного класса.
 * Также дочерние классы должен наследовать 2 интерфейса
 * 1. Должен давать возможность выводить поля класса.
 * 2. Выводить сообщение: «Сейчас *Время года из перечисления*. *Цвет сезона*».
 * Так же необходимо реализовать перечисление, в котором будут объявлены дополнительные поля
 * (они должны быть прописаны как приватные).
 * Тема задания:
 * Абстрактный класс – Person
 * Класс – Client, Employee
 * Интерфейсы – Printable, SeasonHandler.
 * Перечисление – Season(color) (Время года, с привязкой цвета этого сезона).
 */

public class Main {

    private static void PersonPrint(Printable obj) {
        obj.Print();
    }

    private static void FavoriteSeason(SeasonHandler obj) {
        obj.favoriteSeason();
    }

    public static void main(String[] args) {
        Person person1 = new Employee(1);
        Person person2 = new Employee(2,"Иван", "Иванов", "ivan@yandex.ru", "программист", "Отдел разработки", 10000, Season.AUTUMN);
        Person person3 = new Client(3);
        Person person4 = new Client(4,"Петр", "Петров", "petr@yandex.ru","ООО \"Светлячок\"","Энергетика", Season.SUMMER);

        Person[] persons = {person1, person2, person3, person4};
        for (Person item: persons) {
            //System.out.println(item.PersonInfo());
        }
        // печать данных о персоне
        for (Person item: persons) {
            PersonPrint((Printable) item);
        }
        // Любимое время года
        for (Person item: persons) {
            FavoriteSeason((SeasonHandler) item);
        }

    }

}
