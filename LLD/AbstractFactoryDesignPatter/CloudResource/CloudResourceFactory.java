interface CloudResourceFactory {
    ComputeInstance createCompute();
    StorageBucket createStorage();
}