abstract class VendingMachineState {
    
    public void pressInsertCoinButton(VendingMachine machine) {

    }

    public void insertCoin(VendingMachine machine, Coin coin) {

    }

    public void clickonSelectProduct(VendingMachine machine) {

    }

    public double returnChange(double amount) {
        return 0;
    }

    public double cancel(VendingMachine machine) {
        // do full refund;
        return 0;
    }

    public Product dispenseProduct(VendingMachine machine, String code){
        return null;
    }

    public void addProduct(VendingMachine machine, Product prod) {

    }

    public void displayProducts(VendingMachine machine)  {
        
    }

    public void chooseProduct(VendingMachine machine, String code) {

    }
}