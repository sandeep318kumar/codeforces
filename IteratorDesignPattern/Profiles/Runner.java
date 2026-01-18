class Runner {
    public static void main(String[] args) {
        SocialNetworkProfile profiles = new SocialNetworkProfile();

        profiles.addProfile("Phil");
        profiles.addProfile("Rico");
        profiles.addProfile("Haaland");
        profiles.addProfile("Semenyo");

        Iterator<String> profileIterator = profiles.createIterator();

        while(profileIterator.hasNext()) {
            System.out.println(profileIterator.next());
        }
    }
}