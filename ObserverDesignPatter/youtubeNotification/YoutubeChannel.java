import java.util.ArrayList;
import java.util.List;

class YoutubeChannel implements Channel {
    List<Subscriber> subscribers = new ArrayList<> ();
    private String ChannelName;

    YoutubeChannel(String ch) {
        this.ChannelName = ch;
    }

    @Override
    public void subscribe(Subscriber sub) {
        subscribers.add(sub);
    }

    @Override
    public void unsubscribe(Subscriber sub) {
        subscribers.remove(sub);
    }

    @Override
    public void notify(String title) {
        // call update of each subscribers
        for(Subscriber sub : subscribers) {
            sub.update(title);
        }
    }

    public void upload(String title) {
        this.notify(title);
    }

}