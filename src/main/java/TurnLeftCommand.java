public class TurnLeftCommand  extends  Command{
    private int step;

    public TurnLeftCommand(String commandText) {
        step = Integer.parseInt(commandText);
    }

    @Override
    public boolean run(IBehavior location) {
        location.turnLeft(step);
        return true;
    }

    public int getStep() {
        return step;
    }
}
