import java.util.*;
public class Booking {
    private String bookingId;
    private Show show;
    private List<String> seatList;
    private double amount;

    public Booking(Show show, String[] codes){
        this.bookingId = "BK" + (int)(System.currentTimeMillis() % 100000);
        this.show = show;
        this.seatList = new ArrayList<>();
        for(String s: codes) seatList.add(s.trim().toUpperCase());
        this.amount = 0;
    }

  public void calculateTotal(){
    double total = 0;
    for(String s: seatList){
        SeatType t = show.getSeatType(s.charAt(0));
        total += t.getPrice(); // Use enum price - No hardcode!
    }
    this.amount = total;
}

public void calculateTotal(String coupon){
    if(coupon.equalsIgnoreCase("CINE10")){
        this.amount = this.amount * 0.9; // 10% off
    }
}

    public String getBookingId(){ return bookingId; }
    public Show getShow(){ return show; }
    public List<String> getSeatList(){ return seatList; }
    public double getAmount(){ return amount; }
    public String getMovieName(){ return show.getMovieName(); }
    public List<String> getSeats(){ return seatList; }
    public double getTotalPrice(){ return amount; }

    public void printSummary() {
        System.out.println("\nBooking ID : " + bookingId);
        System.out.println("Movie      : " + getMovieName());
        System.out.println("Seats      : " + String.join(", ", seatList) + " (PREMIUM)");
        System.out.println("Total      : Rs. " + String.format("%.2f", amount));
    }
}