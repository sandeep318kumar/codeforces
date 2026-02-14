class ObserverDemo {
    public static void main (String[] args) {
        YoutubeChannel youtubeChannel = new YoutubeChannel("Sandeep Kumar Channel");

        User u1 = new User("Lucy");
        User u2 = new User("Lucifer");

        youtubeChannel.subscribe(u1);
        youtubeChannel.subscribe(u2);

        youtubeChannel.upload("New vlog");

        youtubeChannel.unsubscribe(u1);
        youtubeChannel.upload("Happy new year vlog");
    }
}