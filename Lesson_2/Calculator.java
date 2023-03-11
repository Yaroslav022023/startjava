public class Calculator {

    private int num;
    private int num2;
    private char action;

    void setNum(int num) {
        this.num = num;
    }

    void setAction(char action) {
        this.action = action;
    }

    void setNum2(int num2) {
        this.num2 = num2;
    }

    public int calculate() {
        switch(action) {
            case '+':
                return num + num2;
            case '-':
                return num - num2;
            case '*':
                return num * num2;
            case '/':
                return num / num2;
            case '^':
                int result = num;
                for (int i = 1; i < num2; i++) {
                    result *= num;
                }
                return result;
            case '%':
                return num % num2;
            default:
                return 00;
        }
    }
}