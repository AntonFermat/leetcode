package leetcode.p1600.p1603;

public class ParkingSystem {

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    private int big;
    private int medium;
    private int small;

    public boolean addCar(int carType) {
        switch (carType) {
            case 1 -> {
                big--;
                return big >= 0;
            }
            case 2 -> {
                medium--;
                return medium >= 0;
            }
            case 3 -> {
                small--;
                return small >= 0;
            }
        }
        return false;
    }
}