import java.util.concurrent.locks.ReentrantLock;

class InventoryItem {
    Product product;
    int quantity;
    ReentrantLock lock = new ReentrantLock();

    InventoryItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    boolean reserve(int quantity) {
        lock.lock();
        try{
            if(this.quantity >= quantity) {
                this.quantity -= quantity;
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    void release(int quantity) {
        lock.lock();
        try {
            this.quantity += quantity;
        } finally {
            lock.unlock();
        }
    }
}