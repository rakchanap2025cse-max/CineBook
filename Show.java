import java.util.*;
public class Show implements Bookable {
    private String movieName;
    private String time;
    private char[][] seats = new char[5][8];

    public Show(String movieName, String time){
        this.movieName = movieName;
        this.time = time;
        for(int i=0;i<5;i++) for(int j=0;j<8;j++) seats[i][j]='O';
    }
    public String getMovieName(){ return movieName; }
    public String getTime(){ return time; }
    
    public SeatType getSeatType(char row){
        if(row=='A'||row=='B') return SeatType.REGULAR;
        if(row=='C'||row=='D') return SeatType.PREMIUM;
        return SeatType.VIP;
    }

    public void displaySeatMap(){
        System.out.println("\nShow: "+movieName+" ("+time+")");
        System.out.println("      1 2 3 4 5 6 7 8");
        for(int i=0;i<5;i++){
            char r = (char)('A'+i);
            System.out.print("  "+r+"   ");
            for(int j=0;j<8;j++) System.out.print(seats[i][j]+" ");
            System.out.println();
        }
        System.out.println("O = Free, X = Booked");
    }

    private boolean isValid(String s){
        if(s==null||s.length()!=2) return false;
        s=s.toUpperCase();
        return s.charAt(0)>='A'&&s.charAt(0)<='E'&&s.charAt(1)>='1'&&s.charAt(1)<='8';
    }

    @Override
    public Booking bookSeats(String[] codes, String coupon){
        for(String s: codes){
            s=s.trim().toUpperCase();
            if(!isValid(s)){ System.out.println("Invalid seat: "+s); return null; }
            if(seats[s.charAt(0)-'A'][s.charAt(1)-'1']=='X'){
                System.out.println("Seat "+s+" already booked! Transaction cancelled.");
                return null;
            }
        }
        for(String s: codes){
            s=s.trim().toUpperCase();
            seats[s.charAt(0)-'A'][s.charAt(1)-'1']='X';
        }
        Booking b = new Booking(this, codes);
        b.calculateTotal();
        if(coupon!=null&&!coupon.isBlank()) b.calculateTotal(coupon);
        return b;
    }

    @Override public void cancelBooking(String id){}
    public void freeSeats(String[] codes){
        for(String s: codes){
            s=s.trim().toUpperCase();
            if(isValid(s)) seats[s.charAt(0)-'A'][s.charAt(1)-'1']='O';
        }
    }
}