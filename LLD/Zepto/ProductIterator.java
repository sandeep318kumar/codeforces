class ProuductIterator implements Iterator<Product> {
    private ProductCatalogue catalogue;
    private int position = 0;

    ProuductIterator(ProductCatalogue catalogue) {
        this.catalogue = catalogue;
    }

    @Override
    public boolean hasNext() {
        return position < catalogue.getProducts().size();
    }

    @Override
    public Product next() {
        if(this.hasNext()) {
            return catalogue.getProducts().get(position++);
        }
        return null;
    }
}