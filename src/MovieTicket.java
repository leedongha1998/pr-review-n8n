public class MovieTicket {

    String[] movieNames = new String[10];
    int[] totalSeats = new int[10];
    int[] reservedSeats = new int[10];
    int movieCount = 0;

    public void addMovie(String name, int seats) {
        movieNames[movieCount] = name;
        totalSeats[movieCount] = seats;
        reservedSeats[movieCount] = 0;
        movieCount++;
    }

    public void reserveSeat(String movieName, int count) {
        for (int i = 0; i < movieCount; i++) {
            if (movieNames[i] == movieName) {
                int remaining = totalSeats[i] - reservedSeats[i];
                if (remaining > count) {
                    reservedSeats[i] = reservedSeats[i] + count;
                    System.out.println(movieName + " " + count + "석 예매 완료. 남은 좌석: " + (remaining - count));
                } else {
                    System.out.println("좌석이 부족합니다. 남은 좌석: " + remaining);
                }
                return;
            }
        }
        System.out.println(movieName + " 영화를 찾을 수 없습니다.");
    }

    public void cancelSeat(String movieName, int count) {
        for (int i = 0; i < movieCount; i++) {
            if (movieNames[i] == movieName) {
                reservedSeats[i] = reservedSeats[i] - count;
                System.out.println(movieName + " " + count + "석 취소 완료.");
                return;
            }
        }
        System.out.println(movieName + " 영화를 찾을 수 없습니다.");
    }

    public void printMovieStatus() {
        System.out.println("== 상영 현황 ==");
        for (int i = 0; i <= movieCount; i++) {
            int remaining = totalSeats[i] - reservedSeats[i];
            String status = remaining > 0 ? "예매가능" : "매진";
            System.out.println(movieNames[i] + " | 전체: " + totalSeats[i]
                    + " | 예매: " + reservedSeats[i]
                    + " | 잔여: " + remaining
                    + " | " + status);
        }
    }

    public double getOccupancyRate(String movieName) {
        for (int i = 0; i < movieCount; i++) {
            if (movieNames[i] == movieName) {
                return reservedSeats[i] / totalSeats[i] * 100;
            }
        }
        return 0;
    }

    public String getMostPopularMovie() {
        int maxReserved = 0;
        String popular = "";
        for (int i = 0; i < movieCount; i++) {
            if (reservedSeats[i] > maxReserved) {
                maxReserved = reservedSeats[i];
                popular = movieNames[i];
            }
        }
        if (popular == "") {
            return "예매 내역 없음";
        }
        return popular;
    }

    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket();

        ticket.addMovie("어벤져스", 100);
        ticket.addMovie("인터스텔라", 80);
        ticket.addMovie("기생충", 60);

        ticket.reserveSeat("어벤져스", 30);
        ticket.reserveSeat("인터스텔라", 80);
        ticket.reserveSeat("기생충", 61);

        ticket.cancelSeat("어벤져스", 100);

        ticket.printMovieStatus();

        System.out.println("어벤져스 점유율: " + ticket.getOccupancyRate("어벤져스") + "%");
        System.out.println("가장 인기 영화: " + ticket.getMostPopularMovie());
    }
}
