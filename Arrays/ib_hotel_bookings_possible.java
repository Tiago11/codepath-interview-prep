public class Solution {

    class Booking implements Comparable<Booking>{
        int arrival;
        int departure;

        public Booking(int a, int d) {
            arrival = a;
            departure = d;
        }

        public int compareTo(Booking compareBooking) {
            return this.arrival - compareBooking.arrival;
        }

    }

    public static Comparator<Booking> BookingDepartureComparator = new Comparator<Booking>() {

      public int compare(Booking bookOne, Booking bookTwo) {
          Integer dpOne = bookOne.departure;
          Integer dpTwo = bookTwo.departure;

          return dpOne.compareTo(dpTwo);
      }

    };

    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {

        Booking[] bookings = new Booking[arrive.size()];
        for (int i = 0; i < arrive.size(); i++) {
            bookings[i] = new Booking(arrive.get(i), depart.get(i));
        }

        Arrays.sort(bookings);

        PriorityQueue<Booking> pq = new PriorityQueue<Booking>(BookingDepartureComparator);
        pq.add(bookings[0]);
        int currentGuests = 1;
        for (int i = 1; i < bookings.length; i++) {
            if (bookings[i].arrival < bookings[i].departure) {
                while (pq.size() != 0 && bookings[i].arrival >= pq.peek().departure) {
                    pq.poll();
                    currentGuests--;
                }
                pq.add(bookings[i]);
                currentGuests++;

                if (currentGuests > K) {
                    return false;
                }
            }
        }

        return true;
    }
}
