import java.util.*;
public class CineApp {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Theatre theatre = new Theatre();
        theatre.addShow(new Show("Interstellar","7:30 PM"));
        theatre.addShow(new Show("Avengers","5:00 PM"));
        theatre.addShow(new Show("Inception","9:00 PM"));

        while(true){
            System.out.println("\n========== CineBook ["+theatre.getTheatreName()+"] ==========");
            System.out.println("1. View Shows");
            System.out.println("2. Book Seats");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.println("==================================================");
            
            System.out.print("Enter Your Choice (1-4): ");
            String choice = sc.nextLine();

            if(choice.equals("1")){
                System.out.println("\n--- You chose 1: View Shows ---");
                System.out.println("Available Movies:");
                List<Show> list = theatre.getShows();
                for(int i=0;i<list.size();i++){
                    System.out.println((i+1)+". "+list.get(i).getMovieName()+" - "+list.get(i).getTime());
                }
                System.out.print("\nPress Enter to go back to Main Menu...");
                sc.nextLine();
            }
            else if(choice.equals("2")){
                System.out.println("\n--- You chose 2: Book Seats ---");
                List<Show> list = theatre.getShows();
                for(int i=0;i<list.size();i++){
                    System.out.println((i+1)+". "+list.get(i).getMovieName()+" - "+list.get(i).getTime());
                }
                System.out.print("\nEnter Show No (1-3): ");
                int showNo = Integer.parseInt(sc.nextLine())-1;
                Show selectedShow = list.get(showNo);

                System.out.println("\nYou Selected Movie: " + selectedShow.getMovieName() + " (" + selectedShow.getTime() + ")");
                System.out.println("Seat Map: O = Free, X = Booked");
                selectedShow.displaySeatMap();

                System.out.print("\nEnter Customer Name: ");
                String custName = sc.nextLine();

                System.out.print("Enter Seat Numbers (e.g. C3,C4): ");
                String seatInput = sc.nextLine();

                System.out.print("Enter Coupon Code (CINE10 for 10% off, or Press Enter to Skip): ");
                String coupon = sc.nextLine();

                Booking b = selectedShow.bookSeats(seatInput.split(","), coupon);
                if(b!=null){
                    theatre.addBooking(b, custName);
                    System.out.println("\nBooking Successful!");
                    System.out.println("\nUpdated Seat Map: O = Free, X = Booked");
                    selectedShow.displaySeatMap();
                }
                System.out.print("\nPress Enter to go back to Main Menu...");
                sc.nextLine();
            }
            else if(choice.equals("3")){
                System.out.println("\n--- You chose 3: Cancel Booking ---");
                System.out.print("Enter Booking ID to Cancel (e.g. BK1001): ");
                String id = sc.nextLine();
                theatre.cancel(id);
                System.out.print("\nPress Enter to go back to Main Menu...");
                sc.nextLine();
            }
            else if(choice.equals("4")){
                System.out.println("\n--- You chose 4: Exit ---");
                System.out.println("Thank you! Exiting CineBook...");
                break;
            }
            else{
                System.out.println("Invalid Choice! Enter 1,2,3 or 4 only");
            }
        }
        sc.close();
    }
}