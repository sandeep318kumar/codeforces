class EC2Instance implements ComputeInstance{
    @Override
    public void start() {
        System.out.println("Starting an AWS EC2 instance.....");
    }
}