public class TurnLeftCommand  extends  Command{
    private int step;

    public TurnLeftCommand(String commandText) {
        step = Integer.parseInt(commandText);
    }

    @Override
    public void run(IBehavior location) {
        location.turnLeft(step);
    }

    public int getStep() {
        return step;
    }
}
