import java.util.List;
import java.util.ArrayList;

class SocialNetworkProfile implements ProfileCollection {
    private List<String> profiles = new ArrayList<>();

    public void addProfile(String profile) {
        profiles.add(profile);
    }

    @Override
    public Iterator<String> createIterator() {
        return new ProfileIterator();
    }

    private class ProfileIterator implements Iterator<String> {
        private int position = 0;

        public boolean hasNext() {
            return position < profiles.size();
        }

        public String next() {
            if(this.hasNext()) {
                return profiles.get(position++);
            }
            return null;
        }
    }
}