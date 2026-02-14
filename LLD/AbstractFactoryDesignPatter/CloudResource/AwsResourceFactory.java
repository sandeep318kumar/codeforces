class AwsResourceFactory implements CloudResourceFactory {
    @Override
    public ComputeInstance createCompute() {
        return new EC2Instance();
    }

    @Override
    public StorageBucket createStorage() {
        return new S3Bucket();
    }
}