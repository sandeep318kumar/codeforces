class AzureResourceFactory implements CloudResourceFactory {
    @Override
    public ComputeInstance createCompute() {
        return new AzureVM();
    }

    @Override
    public StorageBucket createStorage() {
        return new AzureBlobStorage();
    }
}