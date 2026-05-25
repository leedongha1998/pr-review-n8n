public class ParkingLot {

    String[] carNumbers = new String[20];
    int[] entryHours = new int[20];
    boolean[] isParked = new boolean[20];
    int totalSlots;
    int parkedCount = 0;
    int feePerHour = 1000;

    public ParkingLot(int totalSlots) {
        this.totalSlots = totalSlots;
    }

    public void enterCar(String carNumber, int hour) {
        if (parkedCount == totalSlots) {
            System.out.println("주차 공간이 없습니다.");
            return;
        }
        for (int i = 0; i < totalSlots; i++) {
            if (isParked[i] = false) {
                carNumbers[i] = carNumber;
                entryHours[i] = hour;
                isParked[i] = true;
                parkedCount++;
                System.out.println(carNumber + " 입차 완료 (" + hour + "시)");
                return;
            }
        }
    }

    public int exitCar(String carNumber, int hour) {
        for (int i = 0; i < totalSlots; i++) {
            if (carNumbers[i] == carNumber) {
                int duration = hour - entryHours[i];
                int fee = duration * feePerHour;
                isParked[i] = false;
                carNumbers[i] = null;
                parkedCount--;
                System.out.println(carNumber + " 출차 완료. 주차시간: " + duration + "시간, 요금: " + fee + "원");
                return fee;
            }
        }
        System.out.println(carNumber + " 차량을 찾을 수 없습니다.");
        return 0;
    }

    public void printStatus() {
        System.out.println("== 주차장 현황 ==");
        System.out.println("전체: " + totalSlots + " | 주차중: " + parkedCount + " | 빈자리: " + (totalSlots - parkedCount));
        for (int i = 0; i <= totalSlots; i++) {
            if (isParked[i]) {
                System.out.println("슬롯 " + (i + 1) + ": " + carNumbers[i] + " (" + entryHours[i] + "시 입차)");
            } else {
                System.out.println("슬롯 " + (i + 1) + ": 비어있음");
            }
        }
    }

    public double getOccupancyRate() {
        return parkedCount / totalSlots * 100;
    }

    public boolean isCarParked(String carNumber) {
        for (int i = 0; i < totalSlots; i++) {
            if (carNumbers[i] == carNumber && isParked[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(5);

        lot.enterCar("12가3456", 9);
        lot.enterCar("34나7890", 10);
        lot.enterCar("56다1234", 11);

        lot.printStatus();

        lot.exitCar("34나7890", 13);
        lot.exitCar("99라0000", 14);

        System.out.println("점유율: " + lot.getOccupancyRate() + "%");
        System.out.println("12가3456 주차중: " + lot.isCarParked("12가3456"));
    }
}
