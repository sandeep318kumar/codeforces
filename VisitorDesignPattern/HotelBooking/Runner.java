import java.util.List;
import java.util.ArrayList;

class Runner {
    public static void main(String[] args) {
        List<HotelElement> stays = new ArrayList<>();

        SingleRoom r101 = new SingleRoom();
        r101.roomNumber = 101;

        DeluxRoom delux1 = new DeluxRoom();
        delux1.roomNumber = 201;
        stays.add(r101);
        stays.add(delux1);

        PricingVisitor price = new PricingVisitor();
        BookingVisitor book = new BookingVisitor();

        System.out.println("Calculating Bill==========");
        for(HotelElement h: stays) {
            h.accept(price);
        }
        System.out.println("Total amount is: " + price.total);


        System.out.println("attempting to book");
        for(HotelElement h: stays) {
            h.accept(book);
        }

        HotelVisitor maintenance = new HotelVisitor() {
            public void visit(SingleRoom room) {
                System.out.println("Cleaning single room " + room.roomNumber);
            }
            public void visit(DeluxRoom room) {
                System.out.println("Cleaning Delux room " + room.roomNumber);
            }
        };

        System.out.println("Staff tasks");
        stays.forEach(e -> e.accept(maintenance));
    }
}