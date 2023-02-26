public class Person {

    String name = "Human Design";
    char gender = 'M';
    float height = 180.5f;
    int weight = 80;
    int age = 25;

    void walk() {
        System.out.println("Я иду");
    }

    void sit() {
        System.out.println("Я сижу");
    }

    String run() {
        return "Я бегу";
    }

    String say() {
        return "Я говорю";
    }

    boolean learnJava() {
        return true;
    }
}