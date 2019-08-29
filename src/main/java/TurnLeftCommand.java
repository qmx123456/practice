public class TurnLeftCommand  extends  Command{
    private int step;

    public TurnLeftCommand(String commandText) {
        step = Integer.parseInt(commandText);
    }

    @Override
    public void run(Location location) {
        location.turnLeft(step);
    }

    public int getStep() {
        return step;
    }
}
