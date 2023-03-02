public class Player {

    private String name;
    private int num;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    void setNum(int num) {
        if (num > 0 && num <=100) {
            this.num = num;
        } else {
            System.out.println("Введите число 1-100: ");
        }
    }
}