package DataStructure.LinkedList;
/*
OnlineTicketReservationSystem
This standalone Java class (no package) implements FULL circular singly linked list for online movie ticket reservations.

NODE STRUCTURE:
TicketNode: ticketId(int unique), customerName(String), movieName(String), seatNumber(int), bookingTime(String "HH:MM"), next(TicketNode)
Circular: head -> ... -> last.next = head (head null=empty)

LIST MAINTENANCE:
head: first ticket (null=empty)
Always maintain last.next == head
Traverse: do-while (curr = curr.next) until curr==head

CORE OPERATIONS:
1. addTicket(): Appends new ticket to end (find last O(n)), sets last.next=new, new.next=head O(n)
2. removeById(id): Special head case O(n find last), else prev-next unlink O(n)
3. displayAll(): Circular print from head: ID:Name:Movie:Seat:Time O(n)
4. searchName(name): Circular find customer/movie (case-insens contains), print matches O(n)
5. totalTickets(): Count nodes via circular traverse O(n)

COMPLEXITIES:
   Operation        Complexity
   addTicket        O(n) find last
   removeById       O(n) find+unlink
   displayAll       O(n)
   search           O(n)
   totalTickets     O(n)

EDGE CASES:
- Empty: head==null safe msgs
- Single node: remove sets null, add circular self
- Remove head: last.next = head.next, head=head.next
- Remove last: prev.next=head
- Dupe ID: add rejects
- Search no match: "None found"
- BookingTime: simple HH:MM input

COMPILE/RUN: javac OnlineTicketReservationSystem.java && java OnlineTicketReservationSystem
Menu: 1=add ticket, 2=remove ID, 3=display all, 4=search name/movie, 5=total, 0=exit
Test: add few, display circular, remove head/middle, search "Avengers" etc.

Full circular ticket system with all ops - reservation mgmt ready for interviews!
*/

import java.util.Scanner;

public class OnlineTicketReservationSystem {
    static class TicketNode {
        int ticketId;
        String customerName;
        String movieName;
        int seatNumber;
        String bookingTime;
        TicketNode next;

        TicketNode(int id, String cust, String movie, int seat, String time) {
            ticketId = id;
            customerName = cust;
            movieName = movie;
            seatNumber = seat;
            bookingTime = time;
            next = null;
        }
    }

    TicketNode head;

    public OnlineTicketReservationSystem() {
        head = null;
    }

    // Check if id exists
    boolean idExists(int id) {
        if (head == null) return false;
        TicketNode curr = head;
        do {
            if (curr.ticketId == id) return true;
            curr = curr.next;
        } while (curr != head);
        return false;
    }

    // Add at end (circular append)
    void addTicket(int id, String cust, String movie, int seat, String time) {
        if (idExists(id)) {
            System.out.println("Ticket ID " + id + " already exists!");
            return;
        }
        TicketNode newTicket = new TicketNode(id, cust, movie, seat, time);
        if (head == null) {
            // First: self-circular
            head = newTicket;
            head.next = head;
        } else {
            // Find last
            TicketNode last = head;
            do {
                last = last.next;
            } while (last.next != head);
            last.next = newTicket;
            newTicket.next = head;  // close circle
        }
        System.out.println("Added ticket " + id + " for " + cust);
    }

    // Remove by ticketId, fix circular
    void removeById(int id) {
        if (head == null) {
            System.out.println("No tickets!");
            return;
        }
        if (head.ticketId == id) {  // Remove head
            TicketNode last = head;
            do {
                last = last.next;
            } while (last.next != head);
            if (head.next == head) {  // Single
                head = null;
            } else {
                last.next = head.next;
                head = head.next;
            }
            System.out.println("Removed ticket " + id);
            return;
        }
        // Find non-head
        TicketNode prev = head;
        TicketNode curr = head.next;
        while (curr != head) {
            if (curr.ticketId == id) {
                prev.next = curr.next;
                System.out.println("Removed ticket " + id);
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        System.out.println("Ticket " + id + " not found!");
    }

    // Display all circular
    void displayAll() {
        if (head == null) {
            System.out.println("No tickets booked!");
            return;
        }
        System.out.println("Current Bookings:");
        TicketNode curr = head;
        do {
            System.out.println("ID:" + curr.ticketId + " | Cust:" + curr.customerName +
                    " | Movie:" + curr.movieName + " | Seat:" + curr.seatNumber +
                    " | Time:" + curr.bookingTime);
            curr = curr.next;
        } while (curr != head);
    }

    // Search by customer or movie (contains)
    void search(String query) {
        if (head == null) {
            System.out.println("No tickets!");
            return;
        }
        boolean found = false;
        TicketNode curr = head;
        do {
            if (curr.customerName.toLowerCase().contains(query.toLowerCase()) ||
                    curr.movieName.toLowerCase().contains(query.toLowerCase())) {
                System.out.println("Found: ID:" + curr.ticketId + " Cust:" + curr.customerName +
                        " Movie:" + curr.movieName + " Seat:" + curr.seatNumber +
                        " Time:" + curr.bookingTime);
                found = true;
            }
            curr = curr.next;
        } while (curr != head);
        if (!found) {
            System.out.println("No tickets for '" + query + "'");
        }
    }

    // Total count
    int totalTickets() {
        if (head == null) {
            System.out.println("Total booked: 0");
            return 0;
        }
        int count = 1;
        TicketNode curr = head.next;
        while (curr != head) {
            count++;
            curr = curr.next;
        }
        System.out.println("Total booked: " + count);
        return count;
    }

    public static void main(String[] args) {
        OnlineTicketReservationSystem system = new OnlineTicketReservationSystem();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Online Ticket Reservation ---");
            System.out.println("1. Add Ticket");
            System.out.println("2. Remove Ticket (ID)");
            System.out.println("3. Display All");
            System.out.println("4. Search (Cust/Movie)");
            System.out.println("5. Total Tickets");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // clear
            switch (choice) {
                case 1:
                    System.out.print("Ticket ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Customer: "); String cust = sc.nextLine();
                    System.out.print("Movie: "); String movie = sc.nextLine();
                    System.out.print("Seat: "); int seat = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Time (HH:MM): "); String time = sc.nextLine();
                    system.addTicket(id, cust, movie, seat, time);
                    break;
                case 2:
                    System.out.print("Ticket ID: "); int rid = sc.nextInt();
                    system.removeById(rid);
                    break;
                case 3:
                    system.displayAll();
                    break;
                case 4:
                    System.out.print("Search Cust/Movie: "); String q = sc.nextLine();
                    system.search(q);
                    break;
                case 5:
                    system.totalTickets();
                    break;
                case 0:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid! 0-5 only.");
            }
        } while (choice != 0);
        sc.close();
    }
}
/* END - Complete circular linked list ticket reservation system with all features. Test add/remove/search circularly! */
