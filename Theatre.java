import java.util.*;
public class Theatre {
    private List<Show> shows = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();
    private BookingDAO dao = new BookingDAO();
    private String theatreName = "PVR Chennai";
    public String getTheatreName(){ return theatreName; }
    public void addShow(Show s){ shows.add(s); }
    public List<Show> getShows(){ return shows; }
    public void addBooking(Booking b, String customerName){
        bookings.add(b);
        dao.saveBooking(b, customerName, theatreName);
        b.printSummary();
    }
    public void cancel(String id){
        Iterator<Booking> it = bookings.iterator();
        while(it.hasNext()){
            Booking b = it.next();
            if(b.getBookingId().equalsIgnoreCase(id)){
                b.getShow().freeSeats(b.getSeatList().toArray(new String[0]));
                dao.deleteBooking(id);
                System.out.printf("Cancelled. Refund: Rs. %.2f (80%%)\n",b.getAmount()*0.8);
                it.remove();
                return;
            }
        }
        System.out.println("Booking ID not found");
    }
}