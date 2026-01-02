class Watch extends ElectronicDevice implements Clock, FitnessTracker {
    public void showTime() {
        System.out.println("current time is 12:15pm");
    }

    public void trackSteps() {
        System.out.println("steps count is 8993");
    }

    public void heartRate() {
        System.out.println("Heart rate is 70 bpm");
    }

    public static void main(String[] args) {
        Watch w = new Watch();
        w.showTime();
        w.trackSteps();
        w.heartRate();
        w.plugin();
    }
}