class Ball{
    public int runs;
    public boolean isWicket;
    public WicketType wicket;
    public BallType type;

    public Ball(int runs, BallType type) {
        this.runs = runs;
        this.type = type;
    }

    public static Ball wicket(WicketType type) {
        Ball ball = new Ball(0, BallType.NORMAL);
        ball.isWicket = true;
        ball.wicket = type;
        return ball;
    }
}