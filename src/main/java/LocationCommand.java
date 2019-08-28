public class LocationCommand extends Command{

    private Location location;

    public LocationCommand(String commandText) {
        String[] split = commandText.split(",");
        location = new Location(Integer.parseInt(split[0]),Integer.parseInt(split[1]),split[2]);
    }

    public void run(Location location) {
        location.set(this.location);
        }

    public Location getLocation() {
        return location;
    }
}
