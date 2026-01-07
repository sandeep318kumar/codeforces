abstract class DispenseChain {
    protected DispenseChain nextChain;

    public void setNextChain(DispenseChain nextChain) {
        this.nextChain = nextChain;
    }

    public abstract void dispense(int amount);
}