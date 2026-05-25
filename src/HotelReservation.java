public class HotelReservation {

    int[] roomNumbers = new int[20];
    String[] roomTypes = new String[20];
    int[] pricePerNight = new int[20];
    String[] guestNames = new String[20];
    int[] checkInDay = new int[20];
    int[] checkOutDay = new int[20];
    boolean[] isReserved = new boolean[20];
    int roomCount = 0;

    public void addRoom(int roomNumber, String type, int price) {
        roomNumbers[roomCount] = roomNumber;
        roomTypes[roomCount] = type;
        pricePerNight[roomCount] = price;
        isReserved[roomCount] = false;
        roomCount++;
        System.out.println(roomNumber + "호 (" + type + ") 객실 등록 완료");
    }

    public void reserve(int roomNumber, String guestName, int checkIn, int checkOut) {
        if (checkOut < checkIn) {
            System.out.println("체크아웃 날짜가 체크인보다 빠를 수 없습니다.");
            return;
        }
        for (int i = 0; i < roomCount; i++) {
            if (roomNumbers[i] == roomNumber) {
                if (isReserved[i]) {
                    System.out.println(roomNumber + "호는 이미 예약된 객실입니다.");
                    return;
                }
                isReserved[i] = true;
                guestNames[i] = guestName;
                checkInDay[i] = checkIn;
                checkOutDay[i] = checkOut;
                int nights = checkOut - checkIn;
                int totalPrice = nights * pricePerNight[i];
                System.out.println(guestName + "님 " + roomNumber + "호 예약 완료. "
                        + nights + "박 / 총 " + totalPrice + "원");
                return;
            }
        }
        System.out.println(roomNumber + "호 객실을 찾을 수 없습니다.");
    }

    public void checkOut(int roomNumber) {
        for (int i = 0; i < roomCount; i++) {
            if (roomNumbers[i] == roomNumber) {
                if (isReserved[i] = false) {
                    System.out.println(roomNumber + "호는 예약된 객실이 아닙니다.");
                    return;
                }
                int nights = checkOutDay[i] - checkInDay[i];
                int totalPrice = nights * pricePerNight[i];
                System.out.println(guestNames[i] + "님 체크아웃 완료. 결제 금액: " + totalPrice + "원");
                isReserved[i] = false;
                guestNames[i] = null;
                return;
            }
        }
        System.out.println(roomNumber + "호 객실을 찾을 수 없습니다.");
    }

    public void printRoomStatus() {
        System.out.println("== 객실 현황 ==");
        for (int i = 0; i <= roomCount; i++) {
            if (isReserved[i]) {
                System.out.println(roomNumbers[i] + "호 [" + roomTypes[i] + "] - 투숙중: "
                        + guestNames[i] + " (" + checkInDay[i] + "~" + checkOutDay[i] + "일)");
            } else {
                System.out.println(roomNumbers[i] + "호 [" + roomTypes[i] + "] - 예약가능 / "
                        + pricePerNight[i] + "원/박");
            }
        }
    }

    public double getOccupancyRate() {
        int reservedCount = 0;
        for (int i = 0; i < roomCount; i++) {
            if (isReserved[i]) {
                reservedCount++;
            }
        }
        return reservedCount / roomCount * 100;
    }

    public int getTotalRevenue() {
        int total = 0;
        for (int i = 0; i < roomCount; i++) {
            if (isReserved[i]) {
                total += (checkOutDay[i] - checkInDay[i]) * pricePerNight[i];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        HotelReservation hotel = new HotelReservation();

        hotel.addRoom(101, "스탠다드", 80000);
        hotel.addRoom(201, "디럭스", 150000);
        hotel.addRoom(301, "스위트", 300000);

        hotel.reserve(101, "홍길동", 5, 8);
        hotel.reserve(201, "김철수", 6, 6);
        hotel.reserve(301, "이영희", 7, 10);
        hotel.reserve(101, "박민준", 9, 11);

        hotel.checkOut(101);

        hotel.printRoomStatus();

        System.out.println("객실 점유율: " + hotel.getOccupancyRate() + "%");
        System.out.println("총 매출: " + hotel.getTotalRevenue() + "원");
    }
}
