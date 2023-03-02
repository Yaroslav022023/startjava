public class WolfTest {

    public static void main(String[] args) {
        Wolf wolf1 = new Wolf();

        wolf1.setNickname("Robert");
        wolf1.setGender('M');
        wolf1.setWeight(120.5f);
        wolf1.setAge(8);
        wolf1.setColor("gray");

        System.out.println("nickname = " + wolf1.getNickname());
        System.out.println("gender = " + wolf1.getGender());
        System.out.println("weight = " + wolf1.getWeight());
        System.out.println("age = " + wolf1.getAge());
        System.out.println("color = " + wolf1.getColor());

        System.out.println();
        wolf1.walk();
        wolf1.sit();
        wolf1.run();
        wolf1.howl();
        wolf1.hunt();
    }
}