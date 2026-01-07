class Runner {
    public static void main(String[] args) {
        DispenseChain c1 = new Dollar1Handler();
        DispenseChain c5 = new Dollar5Handler();
        DispenseChain c10 = new Dollar10Handler();
        DispenseChain c20 = new Dollar20Handler();
        DispenseChain c50 = new Dollar50Handler();
        c50.setNextChain(c20);
        c20.setNextChain(c10);
        c10.setNextChain(c5);
        c5.setNextChain(c1);

        System.out.println("--- Requesting $130 ---");
        c50.dispense(130);

        System.out.println("\n--- Requesting $40 ---");
        c50.dispense(40);

        System.out.println("\n--- Requesting $10 ---");
        c50.dispense(10);



        System.out.println("\n--- Requesting $117 ---");
        c50.dispense(117);

    }
}