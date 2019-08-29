public class MarCar {
    private Location location;
    public MarCar(){
        location = new Location();
    }

    public MarCar(Blocks blocks) {
        location.setBlocks(blocks);
    }

    public String run(String commands) {
        String[] split = commands.split(" ");
        for (int i=0;i<split.length;i++){
            Command command = CommandFactory.build(split[i]);
            if (!command.run(location)) {
                break;
            }
        }
        return location.toString();
    }
}
