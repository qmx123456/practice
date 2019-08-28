public class LocationCommand extends Command{

    private Location location;

    public LocationCommand(String commandText) {
        String[] split = commandText.split(",");
        location = new Location(Integer.parseInt(split[0]),Integer.parseInt(split[1]),split[2]);
    }

    public void run(Location location) {
        location.setX(this.location.getX());
        location.setY(this.location.getY());
        location.setDirection(this.location.getDirection());
    }

    public Location getLocation() {
        return location;
    }
}
