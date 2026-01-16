class Platform {
    Inventory inventory;

    Platform(Inventory inventory) {
        this.inventory = inventory;
    }

    void displayAllProducts() {
        System.out.println("======Displaying all Products===========");
        for(Product prod : inventory.stock.keySet()) {
            System.out.println(prod.name + " : ₹" + prod.price + " category: " + prod.category);
        }
    }

    void displayCategory(CategoryType category) {
        for(Product prod : inventory.stock.keySet()) {
            if(prod.category.equals(category))
                System.out.println(prod.name + " : ₹" + prod.price + " category: " + prod.category);
        }
    }
}