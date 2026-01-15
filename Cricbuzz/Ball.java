class Ball{
    public int runs;
    public boolean isWicket;
    public WicketType wicket;
    public BallType type;

    public Ball(Builder b) {
        this.runs = b.runs;
        this.type = b.type;
        this.isWicket = b.isWicket;
        this.wicket = b.wicket;
    }

    static class Builder {
        int runs = 0;
        boolean isWicket = false;
        WicketType wicket = null;
        BallType type = BallType.NORMAL;

        Builder runs(int runs ) {
            this.runs = runs;
            return this;
        }

        Builder wide() {
            this.runs = 1;
            this.type = BallType.WIDE;
            return this;
        }

        Builder wicket(WicketType type) {
            this.isWicket = true;
            this.wicket = type;
            return this;
        }

        Ball build() {
            if (runs < 0) {
                throw new IllegalStateException("Runs cannot be negative");
            }

            if (isWicket && type != BallType.NORMAL) {
                throw new IllegalStateException("Wicket can only occur on NORMAL ball");
            }

            if (isWicket && runs != 0) {
                throw new IllegalStateException("Wicket ball cannot have runs");
            }

            if (type == BallType.WIDE && runs != 1) {
                throw new IllegalStateException("Wide must have exactly 1 run");
            }
            return new Ball(this);
        }
    }
}