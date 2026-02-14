import java.util.List;
import java.util.ArrayList;
class Over {
    List<Ball> currentOver = new ArrayList<>();

    public void addBall(Ball ball) {
        currentOver.add(ball);
    }

    boolean isComplete() {
        int count = 0;
        for(Ball ball: currentOver) {
            if(ball.type == BallType.NORMAL)
                count++;
        }
        return count == 6;
    }
}