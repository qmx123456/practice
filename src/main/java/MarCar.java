public class MarCar {
    private Location location;
    public MarCar(){
        location = new Location();
    }
    public String run(String commands) {
        String[] split = commands.split(" ");
        for (int i=0;i<split.length;i++){
            Command command = CommandFactory.build(split[i]);
            command.run(location);
        }
        return location.toString();
    }
}
