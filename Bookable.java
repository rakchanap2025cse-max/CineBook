public interface Bookable {
    Booking bookSeats(String[] seats, String coupon);
    void cancelBooking(String bookingId);
}