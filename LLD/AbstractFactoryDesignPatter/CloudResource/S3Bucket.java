class S3Bucket implements StorageBucket {
    @Override
    public void upload(String data) {
        System.out.println("Uploading to AWS S3 .. " + data);
    }
}