class CloudClient {
    private final ComputeInstance compute;
    private final StorageBucket storage;

    CloudClient(CloudResourceFactory factory) {
        this.compute = factory.createCompute();
        this.storage = factory.createStorage();
    }

    public void deployApp() {
        compute.start();
        storage.upload("App config v1.0");
    }

    public static void main(String[] args ) {
        System.out.println("Deploying to AWS.......");
        CloudClient aws = new CloudClient(new AwsResourceFactory());
        aws.deployApp();


        System.out.println("Deploying to Azure .....");
        CloudClient azure = new CloudClient(new AzureResourceFactory());
        azure.deployApp();
    }
}