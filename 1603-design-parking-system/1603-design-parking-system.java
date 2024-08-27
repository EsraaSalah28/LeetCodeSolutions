class ParkingSystem {
    private int big;
    private int medium;
    private int small;
    private int[] parkingLot;

    public ParkingSystem(int big, int medium, int small) 
    {   parkingLot = new int[3];
        this.big=big;
        this.medium=medium;
        this.small=small;
        parkingLot[0] = this.big;
        parkingLot[1] = this.medium;
        parkingLot[2] = this.small;
        
    }
    
    public boolean addCar(int carType) {
         if (parkingLot[carType-1] > 0) {
            parkingLot[carType-1]--;
            return true;
        }
        return false;
        
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */