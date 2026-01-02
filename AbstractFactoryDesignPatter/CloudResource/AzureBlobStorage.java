class AzureBlobStorage implements StorageBucket {
    @Override
    public void upload(String data) {
        System.out.println("Uploading data to Azure Blob..." + data);
    }
}