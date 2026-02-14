class HomeTheatreFacade {
    Amplifier amplifier = new Amplifier();
    Lights lights = new Lights();
    Projector projector = new Projector();
    SoundSystem soundSystem = new SoundSystem();


    void watchMovie() {
        System.out.println("Get ready to watch movie.....");
        lights.dim(10);
        amplifier.on();
        amplifier.setVolume(80);
        projector.on();
        projector.wideScreenMode();
        soundSystem.setSurroundSound();
    }
}