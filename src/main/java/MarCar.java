public class MarCar {
    Location location;
    public void set(int xLength, int yWidth) {

    }

    public Location getLocation() {
        return location;
    }

    public void location(int x, int y, char n) {
        location = new Location(x,y,n);
    }
}
