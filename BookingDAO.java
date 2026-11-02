import java.sql.*;
public class BookingDAO {
    public void saveBooking(Booking b, String customerName, String theatreName){
        try{
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO bookings (booking_id, customer_name, movie_name, theatre_name, seats, total_price) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, b.getBookingId());
            ps.setString(2, customerName);
            ps.setString(3, b.getMovieName());
            ps.setString(4, theatreName);
            ps.setString(5, String.join(",", b.getSeats()));
            ps.setDouble(6, b.getTotalPrice());
            ps.executeUpdate();
            System.out.println(">> Saved to DB");
            con.close();
        }catch(Exception e){
            System.out.println("DB Save Info: " + e.getMessage());
        }
    }
    public void deleteBooking(String id){
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM bookings WHERE booking_id=?");
            ps.setString(1, id);
            ps.executeUpdate();
            con.close();
        }catch(Exception e){}
    }
}