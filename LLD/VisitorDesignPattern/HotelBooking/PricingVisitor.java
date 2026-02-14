class PricingVisitor implements HotelVisitor {
    double total = 0;

    @Override
    public void visit(SingleRoom room) {
        total += 500;
    }

    @Override
    public void visit(DeluxRoom room) {
        total += 1500;
    }
}