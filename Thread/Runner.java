class Runner {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyRunnable("thread1"));
        Thread t2 = new Thread(new MyRunnable("thread2"));

        t1.start();
        // t1.join();

        t2.start();
        // t2.join();

        Thread t3 = new ThreadDemo();
        t3.start();
        t3.yield();
    }
}