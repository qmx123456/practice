public class BackCommand extends Command{
    private int step;

    public BackCommand(String commandText) {
        step = Integer.parseInt(commandText);
    }

    @Override
    public void run(Location location) {
        switch (location.getDirection()){
            case "N":location.setY(location.getY()-step);break;
            case "S":location.setY(location.getY()+step);break;
            case "E":location.setX(location.getX()-step);break;
            case "W":location.setX(location.getX()+step);break;
        }
    }

    public int getStep() {
        return step;
    }
}
