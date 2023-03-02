public class GuessNumber {

    private int computerNum = 1 + (int) (Math.random() * 100);
    private int winNum = 0;


    void checkNum(int playerNum) {
        if (playerNum != computerNum) {
            if (playerNum < computerNum) {
                System.out.println("Число " + playerNum + " меньше того, что загадал компьютер");
            } else if (playerNum > computerNum) {
                System.out.println("Число " + playerNum + " больше того, что загадал компьютер");
            }
        } else {
            winNum = computerNum;
        }
    }

    public int getWinNum() {
        return winNum;
    }

    void setWinNum(int winNum) {
        this.winNum = winNum;
    }

    public int getComputerNum() {
        return computerNum;
    }

    void setComputerNum(int computerNum) {
        this.computerNum = computerNum;
    }
}