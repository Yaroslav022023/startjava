public class JaegerTest {

    public static void main(String[] args) {
        Jaeger gipsyDanger = new Jaeger("Gipsy Danger", 'M', 79.25f, 1980, 6, 8);

        System.out.println(gipsyDanger);

        System.out.println();
        gipsyDanger.move();
        gipsyDanger.scanKaiju();
        gipsyDanger.useVortexCannon();
        gipsyDanger.speak();
        System.out.println(gipsyDanger.shoot());

        Jaeger strikerEureka = new Jaeger();

        strikerEureka.setName("Striker Eureka");
        strikerEureka.setSpeed(10);
        strikerEureka.setHeight(76.2f);
        strikerEureka.setWeight(1859);
        strikerEureka.setArmor(9);
        strikerEureka.setStrength(10);

        System.out.println("\nName: " + strikerEureka.getName());
        System.out.println("Speed: " + strikerEureka.getSpeed());
        System.out.println("Height: " + strikerEureka.getHeight());
        System.out.println("Weight: " + strikerEureka.getWeight());
        System.out.println("Armor: " + strikerEureka.getArmor());
        System.out.println("Strength: " + strikerEureka.getStrength());

        System.out.println();
        strikerEureka.move();
        strikerEureka.scanKaiju();
        strikerEureka.useVortexCannon();
        strikerEureka.speak();
        System.out.println(strikerEureka.shoot());
    }
}