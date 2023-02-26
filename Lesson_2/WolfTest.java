public class WolfTest {

    public static void main(String[] args) {
        Wolf wolf1 = new Wolf();

        wolf1.nickname = "Robert";
        wolf1.gender = 'M';
        wolf1.weight = 120.5f;
        wolf1.age = 18;
        wolf1.color = "gray";

        System.out.println("nickname = " + wolf1.nickname);
        System.out.println("gender = " + wolf1.gender);
        System.out.println("weight = " + wolf1.weight);
        System.out.println("age = " + wolf1.age);
        System.out.println("color = " + wolf1.color + "\n");

        wolf1.walk();
        wolf1.sit();
        wolf1.run();
        wolf1.voice();
        wolf1.hunting();
    }
}