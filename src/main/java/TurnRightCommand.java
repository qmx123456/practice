public class TurnRightCommand extends Command {
    private int step;

    public TurnRightCommand(String s) {
        step = Integer.parseInt(s);
    }

    @Override
    public boolean run(IBehavior location) {
        location.turnRight(step);
        return true;
    }

    public int getStep() {
        return step;
    }
}
