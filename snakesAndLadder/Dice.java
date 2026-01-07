import java.util.concurrent.ThreadLocalRandom;
class Dice {
    int count = 0;
    int maxValue = 6;
    int minValue = 1;

    public Dice(int count ) {
        this.count = count;
    }

    public int rollDice() {
        int sum = 0, rolls = count;
        while(rolls > 0) {
            // minValue is inclusive, maxValue exclusive to +1
            sum += ThreadLocalRandom.current().nextInt(minValue, maxValue + 1);
            rolls--;
        }
        return sum;
    }
}