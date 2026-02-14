interface Channel {
    public void subscribe(Subscriber sub);

    public void unsubscribe(Subscriber sub);

    public void notify(String title);
}