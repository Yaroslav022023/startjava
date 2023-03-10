public class Calculator {

    private int num;
    private int num2;
    private char action;

    void setNum(int num) {
        this.num = num;
    }

    void setNum2(int num2) {
        this.num2 = num2;
    }

    void setAction(char action) {
        this.action = action;
    }

    public int calculate() {
        int result;

        switch(action) {
        case '+':
             result = num + num2;
             break;
        case '-':
             result = num - num2;
             break;
        case '*':
             result = num * num2;
             break;
        case '/':
             result = num / num2;
             break;
        case '^':
            result = num;
            for (int i = 1; i < num2; i++) {
                result *= num;
            }
            break;
        case '%':
             result = num % num2;
             break;
        default:
            result = 01;
        }
        return result;
    }
}